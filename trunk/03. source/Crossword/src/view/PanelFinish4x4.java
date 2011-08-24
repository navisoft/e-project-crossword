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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelFinish4x4 extends JPanel{
	private static final long serialVersionUID = 1L;
	public Image img;
	public int width;
	public int height;
	public JPanel pnResults = new JPanel();
	public JPanel pnAnswers = new JPanel();
	public JPanel pnButton = new JPanel();
	public PanelDisplayAnswer4x4 proAnswer;
	public PanelDisplayAnswer4x4 youAnswer;
	
	public JLabel playerName = new JLabel();
	public JLabel playerResult = new JLabel();
	public JLabel playerScore = new JLabel();
	public JLabel playerTime = new JLabel();
	
	public JButton btBack = new JButton();
	public JButton btMainMenu = new JButton();
	public JButton btQuit = new JButton();
	public JButton btHighScores = new JButton();
	public PanelFinish4x4(Image _img,int _width,int _height) {
		try {
			this.img = _img;
			this.width = _width;
			this.height = _height;
			this.setLayout(new GridBagLayout());
			initComponent();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	private void initComponent() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnResults.setPreferredSize(new Dimension(710, 100));
		pnResults.setBorder(BorderFactory.createTitledBorder("Results"));
		pnResults.setBackground(Color.white);
		pnResults.setLayout(new GridBagLayout());

		GridBagConstraints constraintsResult = new GridBagConstraints();
		constraintsResult.gridx = 0;
		constraintsResult.gridy = 0;
		constraintsResult.gridwidth = 1;
		constraintsResult.insets = new Insets(0, 0, 0, 0);
		playerName.setPreferredSize(new Dimension(200, 30));
		playerName.setFont(new Font("Arial", 0, 15));
		playerName.setForeground(Color.BLUE);
		pnResults.add(playerName,constraintsResult);
		constraintsResult.gridx = 1;
		constraintsResult.gridy = 0;
		constraintsResult.gridwidth = 1;
		constraintsResult.insets = new Insets(0, 0, 0, 0);
		playerResult.setPreferredSize(new Dimension(200, 30));
		playerResult.setFont(new Font("Arial", 0, 15));
		playerResult.setForeground(Color.BLUE);
		pnResults.add(playerResult,constraintsResult);
		constraintsResult.gridx = 0;
		constraintsResult.gridy = 1;
		constraintsResult.gridwidth = 1;
		constraintsResult.insets = new Insets(0, 0, 0, 0);
		playerScore.setPreferredSize(new Dimension(200, 30));
		playerScore.setFont(new Font("Arial", 0, 15));
		playerScore.setForeground(Color.BLUE);
		pnResults.add(playerScore,constraintsResult);
		constraintsResult.gridx = 1;
		constraintsResult.gridy = 1;
		constraintsResult.gridwidth = 1;
		constraintsResult.insets = new Insets(0, 0, 0, 0);
		playerTime.setPreferredSize(new Dimension(200, 30));
		playerTime.setFont(new Font("Arial", 0, 15));
		playerTime.setForeground(Color.BLUE);
		pnResults.add(playerTime,constraintsResult);
		
		this.add(pnResults,constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnAnswers.setPreferredSize(new Dimension(580, 280));
		pnAnswers.setLayout(new GridBagLayout());
		GridBagConstraints constraintsAnswer = new GridBagConstraints();
		constraintsAnswer.gridx = 0;
		constraintsAnswer.gridy = 0;
		constraintsAnswer.gridwidth = 1;
		constraintsAnswer.insets = new Insets(0, 0, 0, 10);
		proAnswer = new PanelDisplayAnswer4x4();
		pnAnswers.add(proAnswer,constraintsAnswer);
		
		constraintsAnswer.gridx = 1;
		constraintsAnswer.gridy = 0;
		constraintsAnswer.gridwidth = 1;
		constraintsAnswer.insets = new Insets(0, 10, 0, 0);
		youAnswer = new PanelDisplayAnswer4x4();
		pnAnswers.add(youAnswer,constraintsAnswer);
		pnAnswers.setBackground(Color.white);
		this.add(pnAnswers,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnButton.setPreferredSize(new Dimension(710, 80));
		pnButton.setBorder(BorderFactory.createTitledBorder("Process"));
		pnButton.setBackground(Color.white);
		pnButton.setLayout(new GridBagLayout());
		
		GridBagConstraints constraintsButton = new GridBagConstraints();
		constraintsButton.gridx = 0;
		constraintsButton.gridy = 0;
		constraintsButton.gridwidth = 1;
		constraintsButton.insets = new Insets(0, 0, 0, 0);
		btBack.setText("Back");
		btBack.setIcon(new ImageIcon("src/view/images/back.png"));
		btBack.setPreferredSize(new Dimension(150, 40));
		pnButton.add(btBack,constraintsButton);
		
		constraintsButton.gridx = 1;
		constraintsButton.gridy = 0;
		constraintsButton.gridwidth = 1;
		constraintsButton.insets = new Insets(0, 0, 0, 0);
		btMainMenu.setText("Main Menu");
		btMainMenu.setPreferredSize(new Dimension(150, 40));
		btMainMenu.setIcon(new ImageIcon("src/view/images/mainmenu.png"));
		pnButton.add(btMainMenu,constraintsButton);
		
		constraintsButton.gridx = 2;
		constraintsButton.gridy = 0;
		constraintsButton.gridwidth = 1;
		constraintsButton.insets = new Insets(0, 0, 0, 0);
		btHighScores.setText("High Scores");
		btHighScores.setPreferredSize(new Dimension(150, 40));
		btHighScores.setIcon(new ImageIcon("src/view/images/high_scores_player.png"));
		pnButton.add(btHighScores,constraintsButton);
		
		constraintsButton.gridx = 3;
		constraintsButton.gridy = 0;
		constraintsButton.gridwidth = 1;
		constraintsButton.insets = new Insets(0, 0, 0, 0);
		btQuit.setText("Quit");
		btQuit.setPreferredSize(new Dimension(150, 40));
		btQuit.setIcon(new ImageIcon("src/view/images/quit30.png"));
		pnButton.add(btQuit,constraintsButton);
		
		this.add(pnButton,constraints);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", 1, 25));
		g.drawString("P", 25, 131);
		g.setFont(new Font("Arial", 1, 27));
		g.drawString("R", 24, 168);
		g.setFont(new Font("Arial", 1, 29));
		g.drawString("O", 23, 207);
		g.setFont(new Font("Arial", 1, 31));
		g.drawString("G", 22, 247);
		g.setFont(new Font("Arial", 1, 33));
		g.drawString("R", 21, 286);
		g.setFont(new Font("Arial", 1, 35));
		g.drawString("A", 20, 330);
		g.setFont(new Font("Arial", 1, 37));
		g.drawString("M", 19, 377);
		
		g.setFont(new Font("Arial", 1, 27));
		g.drawString("Y", 675, 168);
		g.setFont(new Font("Arial", 1, 31));
		g.drawString("O", 673, 247);
		g.setFont(new Font("Arial", 1, 35));
		g.drawString("U", 671, 330);
	}
}
