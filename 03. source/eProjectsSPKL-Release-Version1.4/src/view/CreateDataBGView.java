package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateDataBGView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image img;
	public int width;
	public int height;
	public JLabel lbMain = new JLabel();
	public JLabel lbHost = new JLabel();
	public JLabel lbData = new JLabel();
	public JLabel lbUser = new JLabel();
	public JLabel lbPass = new JLabel();
	public JLabel lbCreateData = new JLabel();
	public JLabel lbInsertData = new JLabel();
	
	public JTextField txtHost = new JTextField();
	public JTextField txtData = new JTextField();
	public JTextField txtUser = new JTextField();
	public JPasswordField txtPass = new JPasswordField();
	
	public JCheckBox cbCreateData = new JCheckBox();
	public JCheckBox cbInsertData = new JCheckBox();
	
	public JButton btConfig = new JButton();
	public JButton btCancel = new JButton();
	
	public CreateDataBGView(Image _img,int _width,int _height) {
		try {
			// TODO Auto-generated constructor stub
			this.img = _img;
			this.width = _width;
			this.height = _height;
			this.setLayout(new GridBagLayout());
			initComponent();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void initComponent() {
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 4;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		lbMain.setText("Please fill in the information box to connect to the server." );
		lbMain.setFont(new Font("Arial",1, 12));
		this.add(lbMain,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		lbHost.setText("Host Name:" );
		lbHost.setPreferredSize(new Dimension(100, 30));
		lbHost.setFont(new Font("Arial",1, 12));
		this.add(lbHost,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		txtHost.setText("SONLD" );
		txtHost.setPreferredSize(new Dimension(150, 25));
		this.add(txtHost,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		lbUser.setText("User Name:" );
		lbUser.setPreferredSize(new Dimension(100, 30));
		lbUser.setFont(new Font("Arial",1, 12));
		this.add(lbUser,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		txtUser.setText("sa");
		txtUser.setPreferredSize(new Dimension(150, 25));
		this.add(txtUser,bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		lbData.setText("Data Name:" );
		lbData.setPreferredSize(new Dimension(100, 30));
		lbData.setFont(new Font("Arial",1, 12));
		this.add(lbData,bagConstraints);
		
		bagConstraints.gridx = 3;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		txtData.setText("CROSSWORD" );
		txtData.setPreferredSize(new Dimension(150, 25));
		this.add(txtData,bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		lbPass.setText("Password:" );
		lbPass.setPreferredSize(new Dimension(100, 25));
		lbPass.setFont(new Font("Arial",1, 12));
		this.add(lbPass,bagConstraints);
		
		bagConstraints.gridx = 3;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		txtPass.setText("123456");
		txtPass.setPreferredSize(new Dimension(150, 25));
		this.add(txtPass,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		cbCreateData.setBorder(BorderFactory.createEmptyBorder());
		cbCreateData.setEnabled(false);
		cbCreateData.setSelected(true);
		this.add(cbCreateData,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		lbCreateData.setText("Create Database." );
		lbCreateData.setPreferredSize(new Dimension(100, 25));
		lbCreateData.setFont(new Font("Arial",1, 12));
		this.add(lbCreateData,bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		cbInsertData.setBorder(BorderFactory.createEmptyBorder());
		this.add(cbInsertData,bagConstraints);
		
		bagConstraints.gridx = 3;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		lbInsertData.setText("Insert Data." );
		lbInsertData.setPreferredSize(new Dimension(100, 25));
		lbInsertData.setFont(new Font("Arial",1, 12));
		this.add(lbInsertData,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 5;
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		btConfig.setText("Config" );
		btConfig.setFont(new Font("Arial",1, 12));
		btConfig.setPreferredSize(new Dimension(150, 40));
		btConfig.setIcon(new ImageIcon(getClass().getResource("/images/config.png")));
		this.add(btConfig,bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 5;
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(10, 0, 10, 0);
		btCancel.setText("Cancel");
		btCancel.setPreferredSize(new Dimension(150, 40));
		btCancel.setIcon(new ImageIcon(getClass().getResource("/images/cancel.png")));
		btCancel.setFont(new Font("Arial",1, 12));
		this.add(btCancel,bagConstraints);
		
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
		g.setColor(Color.white);
		g.drawRoundRect(10, 10, 560, 390, 10, 10);
	}
}
