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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.WindowConstants;

import util.StringUtil;

import dao.AdminDao;

public class CreateAdminUserAndPass extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel pnLogin = new JPanel();
	
	private JTextField txtUsername = new JTextField();
	private JPasswordField txtPassword = new JPasswordField();
	private JPasswordField txtConfirmPassword = new JPasswordField();
	
	private JButton btSubmit = new JButton();
	public CreateAdminUserAndPass() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
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
		this.setPreferredSize(new Dimension(400, 300));
		this.setTitle("Create Administrator's Username and Password");
    	ImageIcon images = new javax.swing.ImageIcon(getClass().getResource("/images/administrator.png"));
        Image imgs = images.getImage();
		this.setIconImage(imgs);
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.white);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2);
		this.setResizable(false);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth =1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnLogin.setPreferredSize(new Dimension(390, 270));
		pnLogin.setLayout(new GridBagLayout());
		pnLogin.setBackground(Color.white);
		pnLogin.setBorder(BorderFactory.createTitledBorder("Create Admin's Username and Password Form"));
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
		constraints.gridy = 2;
		constraints.gridwidth =2;
		constraints.insets = new Insets(10, 0, 0, 0);
		txtConfirmPassword.setPreferredSize(new Dimension(300, 50));
		txtConfirmPassword.setBorder(BorderFactory.createTitledBorder("Confirm Password:"));
		pnLogin.add(txtConfirmPassword,constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth =2;
		constraints.insets = new Insets(20, 30, 0, 0);
		btSubmit.setPreferredSize(new Dimension(150, 40));
		btSubmit.setText("Submit");
		btSubmit.setIcon(new ImageIcon(getClass().getResource("/images/submit.png")));
		pnLogin.add(btSubmit,constraints);
		
		proccess();
		this.pack();
	}
	public void proccess() {
		btSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				char[] strPassword = txtPassword.getPassword();
				String password = new String(strPassword);
				char[] strConfirmPassword = txtConfirmPassword.getPassword();
				String confirmPassword = new String(strConfirmPassword);
				String username = txtUsername.getText().trim();
				if(password.equals("")||confirmPassword.equals("")||username.equals("")){
					JOptionPane.showMessageDialog(null, "All field not be empty.Try again!");
				}else{
					String usernameReg="[a-z A-Z]+";
					if(!checkValid(usernameReg, username)){
						JOptionPane.showMessageDialog(null, "Username only to accept letter. Try again!");
					}else{
						if(!password.equals(confirmPassword)){
							JOptionPane.showMessageDialog(null, "Password and Confirm Password not same. Try again!");
						}else{
							if(password.length()<6){
								JOptionPane.showMessageDialog(null, "Password's length should eight character minimum. Try again!" );
							}else{
								if(AdminDao.insertAdminUserAndPass(StringUtil.encriptString(username), StringUtil.encriptString(password))){
									new LoginForm("yes").setVisible(true);
									dispose();
								}else{
									JOptionPane.showMessageDialog(null, "Create fail. Try again!");
								}
							}
						}
					}
				}
			}
		});
	}
	public boolean checkValid(String strReg,String valueValid) {
		boolean valid=false;
		Pattern pattern = Pattern.compile(strReg);
		Matcher matcher = pattern.matcher(valueValid);
		valid = matcher.matches();
		return valid;
	}
	
}
