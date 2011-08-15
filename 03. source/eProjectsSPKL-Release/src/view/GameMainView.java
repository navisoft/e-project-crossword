package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import sound.Sound_player;

public class GameMainView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btQuit;
	JButton btNewGame;
	public JButton btManageGame;
	JButton btHighScores;
	JButton btHelp;
	Sound_player player;
	Clip clip;
	public GameMainView() {
		// TODO Auto-generated constructor stub
		this.initComponent();
		this.setTitle("Main Menu");
		this.setIconImage(Toolkit.getDefaultToolkit().createImage("src/view/images/crossword.png"));
		this.pack();
	}
	@SuppressWarnings("static-access")
	private void initComponent() {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

        player = new Sound_player();
        clip = player.Player();
        clip.loop(clip.LOOP_CONTINUOUSLY);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(400,500));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-500)/2);
		this.setLayout(new GridBagLayout());
		this.getContentPane().setBackground(Color.white);
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(5, 0, 5, 0);
		this.getContentPane().add(createBtNewGame(),bagConstraints);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		this.getContentPane().add(createBtManageGame(),bagConstraints);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 1;
		this.getContentPane().add(createBtHighScores(),bagConstraints);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 3;
		bagConstraints.gridwidth = 1;
		this.getContentPane().add(createBtSetting(),bagConstraints);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth = 1;
		this.getContentPane().add(createBtExit(),bagConstraints);
		this.pack();
	}
	private JButton createBtNewGame() {
		if(btNewGame==null){
			btNewGame = new JButton();
			btNewGame.setText("Play Game");
			btNewGame.setPreferredSize(new Dimension(150, 40));
			btNewGame.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new ChoseTypeGame().setVisible(true);
					dispose();
					clip.stop();
				}
			});
		}
		return btNewGame;
	}
	public JButton createBtManageGame() {
		if(btManageGame==null){
			btManageGame = new JButton();
			btManageGame.setPreferredSize(new Dimension(150, 40));
			btManageGame.setText("Manager Game");
			btManageGame.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new LoginForm("no").setVisible(true);
					dispose();
					clip.stop();
				}
			});
		}
		return btManageGame;
	}
	private JButton createBtHighScores() {
		if(btHighScores==null){
			btHighScores = new JButton();
			btHighScores.setText("High Scores");
			btHighScores.setPreferredSize(new Dimension(150, 40));
			btHighScores.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				}
			});
		}
		return btHighScores;
	}
	private JButton createBtSetting() {
		if(btHelp==null){
			btHelp = new JButton();
			btHelp.setText("Help");
			btHelp.setPreferredSize(new Dimension(150, 40));
			btHelp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				}
			});
		}
		return btHelp;
	}
	private JButton createBtExit() {
		if(btQuit==null){
			btQuit = new JButton();
			btQuit.setText("Quit");
			btQuit.setPreferredSize(new Dimension(150, 40));
			btQuit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});
		}
		return btQuit;
	}
}
