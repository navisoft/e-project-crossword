package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;

public class main_Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton btnNewGame = null;
	private JButton btnHighScores = null;
	private JButton btnHelp = null;
	private JButton btnManageGame = null;
	private JButton btnQuit = null;
	/**
	 * This is the default constructor
	 */
	public main_Menu() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(319, 383);
		this.setContentPane(getJContentPane());
		this.setTitle("Crossword");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnNewGame(), null);
			jContentPane.add(getBtnHighScores(), null);
			jContentPane.add(getBtnHelp(), null);
			jContentPane.add(getBtnManageGame(), null);
			jContentPane.add(getBtnQuit(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes btnNewGame	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnNewGame() {
		if (btnNewGame == null) {
			btnNewGame = new JButton();
			btnNewGame.setBounds(new Rectangle(85, 25, 121, 37));
			btnNewGame.setText("New Game");
		}
		return btnNewGame;
	}

	/**
	 * This method initializes btnHighScores	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnHighScores() {
		if (btnHighScores == null) {
			btnHighScores = new JButton();
			btnHighScores.setBounds(new Rectangle(85, 87, 121, 37));
			btnHighScores.setText("High Scores");
		}
		return btnHighScores;
	}

	/**
	 * This method initializes btnHelp	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnHelp() {
		if (btnHelp == null) {
			btnHelp = new JButton();
			btnHelp.setBounds(new Rectangle(85, 149, 121, 37));
			btnHelp.setText("Help");
		}
		return btnHelp;
	}

	/**
	 * This method initializes btnManageGame	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnManageGame() {
		if (btnManageGame == null) {
			btnManageGame = new JButton();
			btnManageGame.setBounds(new Rectangle(85, 211, 121, 37));
			btnManageGame.setText("Manage Game");
		}
		return btnManageGame;
	}

	/**
	 * This method initializes btnQuit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnQuit() {
		if (btnQuit == null) {
			btnQuit = new JButton();
			btnQuit.setBounds(new Rectangle(85, 273, 121, 37));
			btnQuit.setText("Quit Game");
		}
		return btnQuit;
	}

}  //  @jve:decl-index=0:visual-constraint="290,26"
