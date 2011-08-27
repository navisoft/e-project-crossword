package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import util.StringUtil;
import admin.ManageGameView;

import dao.AdminDao;
import dao.GameDao;

public class LoginForm extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel pnLogin = new JPanel();
	
	private JTextField txtUsername = new JTextField();
	private JPasswordField txtPassword = new JPasswordField();
	
	private JButton btSubmit = new JButton();
	private JButton btCancel = new JButton();
	public String status;
	public LoginForm(String status) {
		this.status = status;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initComponent() {
		Container container = this.getContentPane();
		GridBagConstraints constraints = new GridBagConstraints();
		this.setPreferredSize(new Dimension(400, 250));
		this.setTitle("Login Form");
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.white);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-250)/2);
    	ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/images/administrator.png"));
        Image img = image.getImage();
		this.setIconImage(img);
		this.setResizable(false);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth =1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnLogin.setPreferredSize(new Dimension(390, 220));
		pnLogin.setLayout(new GridBagLayout());
		pnLogin.setBackground(Color.white);
		pnLogin.setBorder(BorderFactory.createTitledBorder("Login Form"));
		container.add(pnLogin,constraints);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth =2;
		constraints.insets = new Insets(10, 0, 0, 0);
		txtUsername.setPreferredSize(new Dimension(300, 50));
		txtUsername.setBorder(BorderFactory.createTitledBorder("Username:"));
		pnLogin.add(txtUsername,constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth =2;
		constraints.insets = new Insets(10, 0, 0, 0);
		txtPassword.setPreferredSize(new Dimension(300, 50));
		txtPassword.setBorder(BorderFactory.createTitledBorder("Password:"));
		pnLogin.add(txtPassword,constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth =1;
		constraints.insets = new Insets(20, 30, 0, 0);
		btSubmit.setPreferredSize(new Dimension(100, 40));
		btSubmit.setIcon(new ImageIcon(getClass().getResource("/images/submit.png")));
		btSubmit.setText("Submit");
		pnLogin.add(btSubmit,constraints);

		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth =1;
		constraints.insets = new Insets(20, 10, 0, 0);
		btCancel.setPreferredSize(new Dimension(100, 40));
		btCancel.setIcon(new ImageIcon(getClass().getResource("/images/cancel.png")));
		btCancel.setText("Cancel");
		pnLogin.add(btCancel,constraints);
		
		proccess();
		this.pack();
	}
	public void proccess() {
		btSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsername.getText().trim();
				char[] cs = txtPassword.getPassword();
				String password = new String(cs);
				if(username.equals("")|| password.equals("")){
					JOptionPane.showMessageDialog(null, "All the fields are not blank! Try again!");
				}else{
					if(AdminDao.checkExistsUsername(StringUtil.encriptString(username))){
						if(AdminDao.checkRightPassword(StringUtil.encriptString(username), StringUtil.encriptString(password))){
							if(GameDao.checkExistsData("") && status.equals("yes")){
								new GameMainView().setVisible(true);
								dispose();
							}else{
								new ManageGameView(username).setVisible(true);
								dispose();
							}
						}else{
							JOptionPane.showMessageDialog(null, "Password not right. Try again!");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Don't exists this username in database. Try again!");
					}
				}
			}
		});
		btCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new GameMainView().setVisible(true);
				dispose();
			}
		});
	}
}
