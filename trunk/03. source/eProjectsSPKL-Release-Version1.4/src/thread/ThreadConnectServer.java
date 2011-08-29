package thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ThreadConnectServer extends JWindow implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lbConnectStatus = new JLabel();
	JProgressBar progressBar = new JProgressBar();
	@Override
	public void run() {
		int j = 0;
		for(int i=0; i<1000;i++){
			try {
				if(j!=100){
					j++;
				}
				String connectStatus;
				connectStatus = "Loading";
				lbConnectStatus.setText(connectStatus);
				Thread.sleep(200);
				progressBar.setValue(j);
				if(j!=100){
					j++;
				}
				connectStatus = "Loading.";
				lbConnectStatus.setText(connectStatus);
				Thread.sleep(200);
				progressBar.setValue(j);
				if(j!=100){
					j++;
				}
				connectStatus = "Loading..";
				lbConnectStatus.setText(connectStatus);
				Thread.sleep(200);
				progressBar.setValue(j);
				if(j!=100){
					j++;
				}
				connectStatus = "Loading...";
				lbConnectStatus.setText(connectStatus);
				Thread.sleep(200);
				progressBar.setValue(j);
				if(j!=100){
					j++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ThreadConnectServer() {
		// TODO Auto-generated constructor stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setPreferredSize(new Dimension(500, 300));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-500)/2, (screenSize.height-300)/2);
		this.setLayout(new GridBagLayout());
		this.getContentPane().setBackground(new Color(217, 236, 6));
		this.pack();
		this.setVisible(true);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 10, 0);
		lbConnectStatus.setFont(new Font("Arial", 0, 25));
		lbConnectStatus.setPreferredSize(new Dimension(150, 50));
		lbConnectStatus.setForeground(new Color(28, 28, 88));
		this.add(lbConnectStatus,constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		progressBar.setPreferredSize(new Dimension(450, 30));
		this.add(progressBar,constraints);
	}
}
