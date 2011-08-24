package config;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import dao.GameDao;
import thread.ThreadConnectServer;
import util.DataUtil;
import view.CreateDataView;
import view.GameMainView;
import view.LoginForm;
public class ServerConfig extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ServerConfig() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load error!");
		}
		ThreadConnectServer threadConnectServer = new ThreadConnectServer();
		Thread THB = new Thread(threadConnectServer);
		THB.start();
		boolean result = DataUtil.connect();
		if(result == false){
			threadConnectServer.dispose();
			int resultConfig = JOptionPane.showConfirmDialog(null, "Connection failure!. Please reconfigure server!");
			if(resultConfig == 0){
				new CreateDataView().setVisible(true);
				this.dispose();
			}else{
				System.exit(1);
			}
		}else{
			threadConnectServer.dispose();
			if(GameDao.checkExistsData("")){
				new GameMainView().setVisible(true);
			}else{
				int resultAdmin = JOptionPane.showConfirmDialog(null, "Don't exists data game in database. Are you want return to Admin form?");
				if(resultAdmin == 0){
					new LoginForm("no").setVisible(true);
				}else{
					System.exit(1);
				}
			}
		}
	}
}
