package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import util.DataUtil;
import util.StringUtil;
import dao.ConnectDatabaseDao;

public class CreateDataView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CreateDataBGView panel;
	public CreateDataView() {
		// TODO Auto-generated constructor stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load error!");
		}
		this.setSize(new Dimension(600, 400));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Config Server");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-600)/2, (dimension.height-400)/2);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		Container c = this.getContentPane();
        try {
			BufferedImage img = ImageIO.read(new File("src/view/images/server_bg.png"));
			panel = new CreateDataBGView(img,this.getSize().width, this.getSize().height);
			panel.btConfig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String hostname = panel.txtHost.getText().trim();
					String dataname = panel.txtData.getText().trim();
					String username = panel.txtUser.getText().trim();
					char[] charPassword = panel.txtPass.getPassword();
					String password = new String (charPassword);
					if(hostname.equals("") || dataname.equals("") || username.equals("") || password.equals("")){
						JOptionPane.showMessageDialog(null, "All field not to empty!Try again!" );
					}else{
						setServer(hostname, "master", username, password);
						boolean result = DataUtil.connect();
						if(result){
							if(ConnectDatabaseDao.checkExistsDatabases(dataname)){
								JOptionPane.showMessageDialog(null, "Database "+dataname+" already exists. Input different data name!");
							}
							else{
								boolean resultCreateData = ConnectDatabaseDao.createDatabase(dataname);
								if(resultCreateData){
									setServer(hostname,dataname, username, password);
									result = DataUtil.connect();
									if(result){
										setServer(hostname, dataname, username, password);
										if(ConnectDatabaseDao.createTablePzzule(dataname) 
											&& ConnectDatabaseDao.createTableHighScore(dataname)
											&& ConnectDatabaseDao.createTableAnswer4x4(dataname)
											&& ConnectDatabaseDao.createTableAnswer6x6(dataname)
											&& ConnectDatabaseDao.createTableQuestions(dataname)
											&& ConnectDatabaseDao.createTableUsers(dataname)
										){
											JOptionPane.showMessageDialog(null, "Create database "+dataname+" successfully!");
											boolean checkInputData = panel.cbInsertData.isSelected();
											if(checkInputData){
												boolean resultInsertData = ConnectDatabaseDao.createInsertData(dataname);
												if(resultInsertData){
													JOptionPane.showMessageDialog(null, "Insert data successfully!");
													new CreateAdminUserAndPass() .setVisible(true);
													dispose();
												}
												else{
													JOptionPane.showMessageDialog( null, "Fail!");
													DataUtil.closeConnection();
													DataUtil.connect();
													ConnectDatabaseDao.dropDatabase(dataname);
													setServer("", "", "", "");
													DataUtil.closeConnection();
												}
											}else{
												new CreateAdminUserAndPass() .setVisible(true);
												dispose();
											}
										}
										else{
											JOptionPane.showMessageDialog( null, "Fail!");
											DataUtil.closeConnection();
											setServer(hostname, "master", username, password);
											DataUtil.connect();
											ConnectDatabaseDao.dropDatabase(dataname);
											setServer("", "", "", "");
										}
									}
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, "Hostname,Username or Password not right. Try again!");
						}
					}
					
				}
			});
			panel.btCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			c.add(panel);
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
	public void setServer(String hostname,String dataname, String username, String password) {
		String string = hostname+","+dataname+","+username+","+password;
		String server = StringUtil.encriptString(string);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("src/config/server.txt",false);
	        PrintWriter pw= new PrintWriter(fos); 
	        pw.print(server);
	        pw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
