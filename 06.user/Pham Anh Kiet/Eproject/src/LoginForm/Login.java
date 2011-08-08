package LoginForm;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbLogo = null;
	private JLabel lbAdmin = null;
	private JTextField tfAdministrator = null;
	private JLabel lbPassword = null;
	private JPasswordField tfPassword = null;
	private JButton btLogin = null;
	private JButton btExit = null;
	/**
	 * This is the default constructor
	 */
	public Login() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 250);
		this.setContentPane(getJContentPane());
		this.setTitle(" Adminstrator login form");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbPassword = new JLabel();
			lbPassword.setBounds(new Rectangle(25, 119, 109, 33));
			lbPassword.setText("Password : ");
			lbAdmin = new JLabel();
			lbAdmin.setBounds(new Rectangle(25, 73, 110, 34));
			lbAdmin.setText("Administrator : ");
			lbLogo = new JLabel();
			lbLogo.setBounds(new Rectangle(156, 16, 101, 45));
			lbLogo.setFont(new Font("Arial", Font.BOLD, 24));
			lbLogo.setHorizontalTextPosition(SwingConstants.CENTER);
			lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lbLogo.setText(" Login ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbLogo, null);
			jContentPane.add(lbAdmin, null);
			jContentPane.add(getTfAdministrator(), null);
			jContentPane.add(lbPassword, null);
			jContentPane.add(getTfPassword(), null);
			jContentPane.add(getBtLogin(), null);
			jContentPane.add(getBtExit(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes tfAdministrator	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfAdministrator() {
		if (tfAdministrator == null) {
			tfAdministrator = new JTextField();
			tfAdministrator.setBounds(new Rectangle(144, 74, 218, 34));
		}
		return tfAdministrator;
	}

	/**
	 * This method initializes tfPassword	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JPasswordField();
			tfPassword.setBounds(new Rectangle(144, 118, 217, 35));
		}
		return tfPassword;
	}

	/**
	 * This method initializes btLogin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtLogin() {
		if (btLogin == null) {
			btLogin = new JButton();
			btLogin.setBounds(new Rectangle(79, 165, 104, 37));
			btLogin.setText("Login");
		}
		return btLogin;
	}

	/**
	 * This method initializes btExit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtExit() {
		if (btExit == null) {
			btExit = new JButton();
			btExit.setBounds(new Rectangle(215, 165, 105, 37));
			btExit.setText("Exit");
		}
		return btExit;
	}

}
