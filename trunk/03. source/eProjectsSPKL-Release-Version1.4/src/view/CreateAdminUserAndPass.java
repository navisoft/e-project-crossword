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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import util.DocumentUtil;
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
		this.setTitle("Create Administrator's Username and Password");
    	ImageIcon images = new javax.swing.ImageIcon(getClass().getResource("/images/administrator.png"));
        Image imgs = images.getImage();
		this.setIconImage(imgs);
		this.setLayout(new GridBagLayout());
		this.getContentPane().setBackground(Color.white);
		this.setPreferredSize(new Dimension(500, 310));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-500)/2, (screenSize.height-310)/2);
		this.setResizable(false);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth =1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnLogin.setPreferredSize(new Dimension(480, 280));
		pnLogin.setLayout(new GridBagLayout());
		pnLogin.setBackground(Color.white);
		pnLogin.setBorder(BorderFactory.createTitledBorder("Create Admin's Username and Password Form"));
		container.add(pnLogin,constraints);
		
		GridBagConstraints constraintsPnLogin = new GridBagConstraints();
		constraintsPnLogin.gridx = 0;
		constraintsPnLogin.gridy = 0;
		constraintsPnLogin.gridwidth =1;
		constraintsPnLogin.insets = new Insets(10, 0, 0, 0);
		txtUsername.setPreferredSize(new Dimension(300, 50));
		txtUsername.setDocument(DocumentUtil.getPlainDocument(10, "[a-z A-Z]+"));
		txtUsername.setBorder(BorderFactory.createTitledBorder("Username:"));
		pnLogin.add(txtUsername,constraintsPnLogin);

		constraintsPnLogin.gridx = 0;
		constraintsPnLogin.gridy = 1;
		constraintsPnLogin.gridwidth =1;
		constraintsPnLogin.insets = new Insets(10, 0, 0, 0);
		txtPassword.setPreferredSize(new Dimension(300, 50));
		txtPassword.setBorder(BorderFactory.createTitledBorder("Password:"));
		pnLogin.add(txtPassword,constraintsPnLogin);

		constraintsPnLogin.gridx = 0;
		constraintsPnLogin.gridy = 2;
		constraintsPnLogin.gridwidth =1;
		constraintsPnLogin.insets = new Insets(10, 0, 0, 0);
		txtConfirmPassword.setPreferredSize(new Dimension(300, 50));
		txtConfirmPassword.setBorder(BorderFactory.createTitledBorder("Confirm Password:"));
		pnLogin.add(txtConfirmPassword,constraintsPnLogin);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth =1;
		constraints.insets = new Insets(20, 0, 0, 0);
		btSubmit.setPreferredSize(new Dimension(150, 40));
		btSubmit.setText("Submit");
		btSubmit.setEnabled(false);
		btSubmit.setIcon(new ImageIcon(getClass().getResource("/images/submit.png")));
		pnLogin.add(btSubmit,constraints);
		
		proccess();
		this.pack();
	}
	public void proccess() {
		txtUsername.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent arg0) {
				String user = txtUsername.getText();
				char[] charPass = txtPassword.getPassword();
				String password = new String(charPass);
				char[] charConfirmPass = txtConfirmPassword.getPassword();
				String confirmPassword = new String(charConfirmPass);
				if(password.length()<6 || user.length()<1 || confirmPassword.length()<6 || !password.equals(confirmPassword)){
					btSubmit.setEnabled(false);
				}else{
					btSubmit.setEnabled(true);
				}
			}
		});
		txtPassword.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent arg0) {
				String user = txtUsername.getText();
				char[] charPass = txtPassword.getPassword();
				String password = new String(charPass);
				char[] charConfirmPass = txtConfirmPassword.getPassword();
				String confirmPassword = new String(charConfirmPass);
				if(password.length()<6 || user.length()<1 || confirmPassword.length()<6 || !password.equals(confirmPassword)){
					btSubmit.setEnabled(false);
				}else{
					btSubmit.setEnabled(true);
				}
			}
		});
		txtConfirmPassword.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				String user = txtUsername.getText();
				char[] charPass = txtPassword.getPassword();
				String password = new String(charPass);
				char[] charConfirmPass = txtConfirmPassword.getPassword();
				String confirmPassword = new String(charConfirmPass);
				if(password.length()<6 || user.length()<1 || confirmPassword.length()<6 || !password.equals(confirmPassword)){
					btSubmit.setEnabled(false);
				}else{
					btSubmit.setEnabled(true);
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		btSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				char[] strPassword = txtPassword.getPassword();
				String password = new String(strPassword);
				String username = txtUsername.getText().trim();
				if(AdminDao.insertAdminUserAndPass(StringUtil.encriptString(username), StringUtil.encriptString(password))){
					new LoginForm("yes").setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Create fail. Try again!");
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
