package view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelGameMainView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image img;
	public int width;
	public int height;
	public JButton btQuit = new JButton();
	public JButton btPlayGame = new JButton();
	public JButton btManageGame = new JButton();
	public JButton btHighScores = new JButton();
	public JButton btHelp = new JButton();
	public PanelGameMainView(Image _img,int _width,int _height) {
		this.img = _img;
		this.width = _width;
		this.height = _height;
		this.setLayout(new GridBagLayout());
		initComponent();
	}
	private void initComponent() {
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(100, 0, 5, 0);
		btPlayGame.setPreferredSize(new Dimension(200, 50));
		btPlayGame.setIcon(new ImageIcon("src/view/images/play.png"));
		this.add(btPlayGame,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(5, 0, 5, 0);
		btManageGame.setPreferredSize(new Dimension(200, 50));
		btManageGame.setIcon(new ImageIcon("src/view/images/manage.png"));
		this.add(btManageGame,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(5, 0, 5, 0);
		btHighScores.setPreferredSize(new Dimension(200, 50));
		btHighScores.setIcon(new ImageIcon("src/view/images/high_scores.png"));
		btHighScores.setToolTipText("High Scores");
		this.add(btHighScores,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 3;
		bagConstraints.gridwidth = 1;
		btHelp = new JButton();
		bagConstraints.insets = new Insets(5, 0, 5, 0);
		btHelp.setPreferredSize(new Dimension(200, 50));
		btHelp.setIcon(new ImageIcon("src/view/images/help.png"));
		btHelp.setToolTipText("Help");
		this.add(btHelp,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth = 1;
		btQuit = new JButton();
		bagConstraints.insets = new Insets(5, 0, 0, 0);
		btQuit.setPreferredSize(new Dimension(200, 50));
		btQuit.setIcon(new ImageIcon("src/view/images/quit.png"));
		btQuit.setToolTipText("Quit Game");
		this.add(btQuit,bagConstraints);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
	}
}
