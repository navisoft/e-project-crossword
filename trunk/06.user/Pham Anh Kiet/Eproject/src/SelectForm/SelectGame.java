package SelectForm;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;


public class SelectGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbLogo = null;
	private JButton bt4x4 = null;
	private JButton jButton = null;
	/**
	 * This is the default constructor
	 */
	public SelectGame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 150);
		this.setContentPane(getJContentPane());
		this.setTitle("Select game form");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbLogo = new JLabel();
			lbLogo.setBounds(new Rectangle(46, 16, 300, 30));
			lbLogo.setFont(new Font("Arial", Font.BOLD, 18));
			lbLogo.setText(" Choose the type of game to play");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbLogo, null);
			jContentPane.add(getBt4x4(), null);
			jContentPane.add(getJButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes bt4x4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt4x4() {
		if (bt4x4 == null) {
			bt4x4 = new JButton();
			bt4x4.setBounds(new Rectangle(87, 60, 78, 31));
			bt4x4.setText("4 x 4");
		}
		return bt4x4;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(227, 59, 80, 32));
			jButton.setText("6 x 6");
		}
		return jButton;
	}

}
