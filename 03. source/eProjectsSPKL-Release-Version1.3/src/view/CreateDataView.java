package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import util.DataUtil;
import util.ServerUtil;
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Config Server");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-600)/2, (dimension.height-400)/2);
    	ImageIcon images = new javax.swing.ImageIcon(getClass().getResource("/images/server_icon.png"));
        Image imgs = images.getImage();
		this.setIconImage(imgs);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		Container c = this.getContentPane();
        try {
        	ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/images/server_bg.png"));
            Image img = image.getImage();
			panel = new CreateDataBGView(img,this.getSize().width, this.getSize().height);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error Load form!");
		} 
			panel.btConfig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					setCursor(new Cursor(Cursor.WAIT_CURSOR));
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
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
							}else{
								boolean resultCreateData = ConnectDatabaseDao.createDatabase(dataname);
								if(resultCreateData){
									setServer(hostname,dataname, username, password);
									result = DataUtil.connect();
									if(result){
										if(ConnectDatabaseDao.createTablePzzule() 
											&& ConnectDatabaseDao.createTableHighScore()
											&& ConnectDatabaseDao.createTableAnswer4x4()
											&& ConnectDatabaseDao.createTableAnswer6x6()
											&& ConnectDatabaseDao.createTableQuestions()
											&& ConnectDatabaseDao.createTableUsers()
										){
											JOptionPane.showMessageDialog(null, "Create database "+dataname+" successfully!");
											boolean checkInputData = panel.cbInsertData.isSelected();
											if(checkInputData){
												boolean resultInsertData = ConnectDatabaseDao.createInsertData();
												if(resultInsertData){
													JOptionPane.showMessageDialog(null, "Insert data successfully!");
													setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
													new CreateAdminUserAndPass() .setVisible(true);
													dispose();
												}
												else{
													JOptionPane.showMessageDialog( null, "Insert data fail!");
													setServer(hostname, "master", username, password);
													DataUtil.connect();
													if(ConnectDatabaseDao.dropDatabase(dataname)){
														JOptionPane.showMessageDialog(null, "Drop database successfully0!");
													}
													setServer("aaaa", "aaaa", "aaaa", "aaaa");
													System.exit(1);
												}
											}else{
												new CreateAdminUserAndPass() .setVisible(true);
												dispose();
											}
										}
										else{
											JOptionPane.showMessageDialog( null, "Create database fail. Try again!");
											setServer(hostname, "master", username, password);
											DataUtil.connect();
											if(ConnectDatabaseDao.dropDatabase(dataname)){
												JOptionPane.showMessageDialog(null, "Drop database successfully1!");
											}
											setServer("aaaa", "aaaa", "aaaa", "aaaa");
											System.exit(1);
										}
									}else{
										setServer(hostname, "master", username, password);
										DataUtil.connect();
										if(ConnectDatabaseDao.dropDatabase(dataname)){
											JOptionPane.showMessageDialog(null, "Drop database successfully2!");
										}
										setServer("aaaa", "aaaa", "aaaa", "aaaa");
										System.exit(1);
									}
								}else{
									setServer("aaaa", "aaaa", "aaaa", "aaaa");
									System.exit(1);
								}
							}
						}else{
							setServer("aaaa", "aaaa", "aaaa", "aaaa");
							JOptionPane.showMessageDialog(null, "Hostname,Username or Password not right.\n " +
									"Restart program, then reconfig server!");
							setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
							System.exit(1);	
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
	}
	public void setServer(String hostname,String dataname, String username, String password) {
		String string = hostname+"ithvasolution,"+dataname+"puzzlecrossword,"+username+"tptinhanhvanthe,"+password+"khongbiet";
		String server = ServerUtil.encryptionStr(string);//StringUtil.encriptString(string);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("input/server.ser",false);
	        PrintWriter pw= new PrintWriter(fos);
		    pw.print(server);
	        pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
