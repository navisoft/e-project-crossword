package admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PanelAccountSetting extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnLogin = new JPanel();
	
	JPasswordField txtOldPassword = new JPasswordField();
	JPasswordField txtNewPassword = new JPasswordField();
	JPasswordField txtConfirmPassword = new JPasswordField();
	
	JButton btSaveAccount = new JButton();
	
	public PanelAccountSetting() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.white);
		initComponent();
	}

	private void initComponent() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth =1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnLogin.setPreferredSize(new Dimension(400, 400));
		pnLogin.setLayout(new GridBagLayout());
		pnLogin.setBackground(Color.white);
		pnLogin.setBorder(BorderFactory.createTitledBorder("Login Form"));
		this.add(pnLogin,constraints);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth =1;
		constraints.insets = new Insets(10, 0, 0, 0);
		txtOldPassword.setPreferredSize(new Dimension(300, 50));
		txtOldPassword.setBorder(BorderFactory.createTitledBorder("Old Password:"));
		pnLogin.add(txtOldPassword,constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth =1;
		constraints.insets = new Insets(10, 0, 0, 0);
		txtNewPassword.setPreferredSize(new Dimension(300, 50));
		txtNewPassword.setBorder(BorderFactory.createTitledBorder("New Password:"));
		pnLogin.add(txtNewPassword,constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth =1;
		constraints.insets = new Insets(10, 0, 0, 0);
		txtConfirmPassword.setPreferredSize(new Dimension(300, 50));
		txtConfirmPassword.setBorder(BorderFactory.createTitledBorder("Confirm Password:"));
		pnLogin.add(txtConfirmPassword,constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth =1;
		constraints.insets = new Insets(20, 0, 0, 0);
		btSaveAccount.setPreferredSize(new Dimension(200, 50));
		btSaveAccount.setIcon(new ImageIcon("src/view/images/save.png"));
		pnLogin.add(btSaveAccount,constraints);
	}
	
}
