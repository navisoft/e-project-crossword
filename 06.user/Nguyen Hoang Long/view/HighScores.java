package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HighScores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbHighScores = null;
	private JScrollPane scrHighScores = null;
	private JTable tbHighScores = null;
	/**
	 * This is the default constructor
	 */
	public HighScores() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(554, 323);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbHighScores = new JLabel();
			lbHighScores.setBounds(new Rectangle(160, 10, 210, 38));
			lbHighScores.setFont(new Font("Arial", Font.BOLD, 24));
			lbHighScores.setHorizontalAlignment(SwingConstants.CENTER);
			lbHighScores.setText("High Scores");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbHighScores, null);
			jContentPane.add(getScrHighScores(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes scrHighScores	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrHighScores() {
		if (scrHighScores == null) {
			scrHighScores = new JScrollPane();
			scrHighScores.setBounds(new Rectangle(45, 60, 453, 151));
			scrHighScores.setViewportView(getTbHighScores());
		}
		return scrHighScores;
	}

	/**
	 * This method initializes tbHighScores	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTbHighScores() {
		if (tbHighScores == null) {
			tbHighScores = new JTable();
		}
		return tbHighScores;
	}

}  //  @jve:decl-index=0:visual-constraint="176,-29"
