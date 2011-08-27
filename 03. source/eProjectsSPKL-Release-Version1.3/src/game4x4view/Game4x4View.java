package game4x4view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dao.GameDao;

import thread.CheckEmpty4x4;
import thread.CountTime;
import view.GameMainView;
import view.HighScoresView;
import view.PanelFinish4x4;

public class Game4x4View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameBg4x4View panel;
	PanelFinish4x4 finish;
	CountTime countTime;
	Thread threadCountTime;
	int countQuestions;
	int countAnswers;
	JPanel pnMain = new JPanel();
	CardLayout cardLayout = new CardLayout();
	
	CheckEmpty4x4 checkEmpty4x4;
	Thread threadCheckEmpty;
	public Game4x4View() {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load error!");
		}
		this.setTitle("Crossword 4 x 4");
    	ImageIcon images = new javax.swing.ImageIcon(getClass().getResource("/images/game_icon.png"));
        Image imgs = images.getImage();
		this.setIconImage(imgs);
		this.setPreferredSize(new Dimension(720, 490));
		this.setResizable(false);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-720)/2, (dimension.height-490)/2);
		this.setFocusTraversalKeysEnabled(false);
		this.setLayout(new BorderLayout());
		this.pack();
		pnMain.setLayout(cardLayout);
		Container c = this.getContentPane();
        try {
        	ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/images/crossword_bg.png"));
            Image img = image.getImage();
			panel = new GameBg4x4View(img,this.getSize().width, this.getSize().height);
			panel.btFinish.setToolTipText("Finish");
			countTime = new CountTime(panel.lbTime);
			threadCountTime = new Thread(countTime);
			threadCountTime.start();
			//Return main menu
			panel.btMainMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new GameMainView().setVisible(true);
					dispose();
				}
			});
			//Create new game
			panel.btNewGame.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Game4x4View().setVisible(true);
					dispose();
				}
			});
			checkEmpty4x4 = new CheckEmpty4x4(panel.txt_0_0, panel.txt_0_1, panel.txt_0_2, 
					panel.txt_0_3, panel.txt_1_0, panel.txt_1_1, panel.txt_1_2, panel.txt_1_3, 
					panel.txt_2_0, panel.txt_2_1, panel.txt_2_2, panel.txt_2_3, panel.txt_3_0, 
					panel.txt_3_1, panel.txt_3_2, panel.txt_3_3, panel.btFinish, true);
			threadCheckEmpty = new Thread(checkEmpty4x4);
			threadCheckEmpty.start();
			//Finish game
			panel.btFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(panel.btFinish.getToolTipText().equals("Finish")){
						int result = JOptionPane.showConfirmDialog(null, "Are you sure finished game?");
						if(result == 0){
							countTime.flag = false;
							panel.txt_0_0.setEnabled(false);
							panel.txt_0_0.setEnabled(false);
							panel.txt_0_1.setEnabled(false);
							panel.txt_0_2.setEnabled(false);
							panel.txt_0_3.setEnabled(false);
							panel.txt_1_0.setEnabled(false);
							panel.txt_1_1.setEnabled(false);
							panel.txt_1_2.setEnabled(false);
							panel.txt_1_3.setEnabled(false);
							panel.txt_2_0.setEnabled(false);
							panel.txt_2_1.setEnabled(false);
							panel.txt_2_2.setEnabled(false);
							panel.txt_2_3.setEnabled(false);
							panel.txt_3_0.setEnabled(false);
							panel.txt_3_1.setEnabled(false);
							panel.txt_3_2.setEnabled(false);
							panel.txt_3_3.setEnabled(false);
							String time;
							if(countTime.seconds<10 && countTime.minutes>9){
								time = countTime.minutes+":0"+countTime.seconds;
							}else if(countTime.minutes<10 && countTime.seconds>9){
								time = "0"+countTime.minutes+":"+countTime.seconds;
							}else if(countTime.seconds<10 && countTime.minutes<10){
								time = "0"+countTime.minutes+":0"+countTime.seconds;
							}else{
								time = countTime.minutes+":"+countTime.seconds;
							}
							String playerName = null;
							while( playerName == null ||  "".equals(playerName)){
								countAnswers=0;
								countQuestions=0;
								playerName = JOptionPane.showInputDialog(null, "Input your name:","Information",JOptionPane.INFORMATION_MESSAGE);
								String answer0 = panel.txt_0_0.getText()+panel.txt_0_1.getText()+panel.txt_0_2.getText()+panel.txt_0_3.getText();
								String answer1 = panel.txt_1_0.getText()+panel.txt_1_1.getText()+panel.txt_1_2.getText()+panel.txt_1_3.getText();
								String answer2 = panel.txt_2_0.getText()+panel.txt_2_1.getText()+panel.txt_2_2.getText()+panel.txt_2_3.getText();
								String answer3 = panel.txt_3_0.getText()+panel.txt_3_1.getText()+panel.txt_3_2.getText()+panel.txt_3_3.getText();
								String answer4 = panel.txt_0_0.getText()+panel.txt_1_0.getText()+panel.txt_2_0.getText()+panel.txt_3_0.getText();
								String answer5 = panel.txt_0_1.getText()+panel.txt_1_1.getText()+panel.txt_2_1.getText()+panel.txt_3_1.getText();
								String answer6 = panel.txt_0_2.getText()+panel.txt_1_2.getText()+panel.txt_2_2.getText()+panel.txt_3_2.getText();
								String answer7 = panel.txt_0_3.getText()+panel.txt_1_3.getText()+panel.txt_2_3.getText()+panel.txt_3_3.getText();
								checkSame(answer0, 0);
								checkSame(answer1, 1);
								checkSame(answer2, 2);
								checkSame(answer3, 3);
								checkSame(answer4, 4);
								checkSame(answer5, 5);
								checkSame(answer6, 6);
								checkSame(answer7, 7);
								finish.playerName.setText("Player Name: "+playerName);
								finish.playerResult.setText("You answered correctly: "+countAnswers+"/"+countQuestions);
								Float scores = 10000/(float)countQuestions*(float)countAnswers;
								
								String score = scores.toString();
								finish.playerScore.setText("Your Score: "+ scores);
								finish.playerTime.setText("Total Time: "+time);
								
								finish.proAnswer.txt_0_0.setText(panel.listAnswer4x4.get(0).getValue1().toUpperCase());
								finish.proAnswer.txt_0_1.setText(panel.listAnswer4x4.get(0).getValue2().toUpperCase());
								finish.proAnswer.txt_0_2.setText(panel.listAnswer4x4.get(0).getValue3().toUpperCase());
								finish.proAnswer.txt_0_3.setText(panel.listAnswer4x4.get(0).getValue4().toUpperCase());	
								
								finish.proAnswer.txt_1_0.setText(panel.listAnswer4x4.get(1).getValue1().toUpperCase());
								finish.proAnswer.txt_1_1.setText(panel.listAnswer4x4.get(1).getValue2().toUpperCase());
								finish.proAnswer.txt_1_2.setText(panel.listAnswer4x4.get(1).getValue3().toUpperCase());
								finish.proAnswer.txt_1_3.setText(panel.listAnswer4x4.get(1).getValue4().toUpperCase());	

								finish.proAnswer.txt_2_0.setText(panel.listAnswer4x4.get(2).getValue1().toUpperCase());
								finish.proAnswer.txt_2_1.setText(panel.listAnswer4x4.get(2).getValue2().toUpperCase());
								finish.proAnswer.txt_2_2.setText(panel.listAnswer4x4.get(2).getValue3().toUpperCase());
								finish.proAnswer.txt_2_3.setText(panel.listAnswer4x4.get(2).getValue4().toUpperCase());	

								finish.proAnswer.txt_3_0.setText(panel.listAnswer4x4.get(3).getValue1().toUpperCase());
								finish.proAnswer.txt_3_1.setText(panel.listAnswer4x4.get(3).getValue2().toUpperCase());
								finish.proAnswer.txt_3_2.setText(panel.listAnswer4x4.get(3).getValue3().toUpperCase());
								finish.proAnswer.txt_3_3.setText(panel.listAnswer4x4.get(3).getValue4().toUpperCase());	
										
								
								finish.youAnswer.txt_0_0.setText(panel.txt_0_0.getText().toUpperCase());
								finish.youAnswer.txt_0_1.setText(panel.txt_0_1.getText().toUpperCase());
								finish.youAnswer.txt_0_2.setText(panel.txt_0_2.getText().toUpperCase());
								finish.youAnswer.txt_0_3.setText(panel.txt_0_3.getText().toUpperCase());

								finish.youAnswer.txt_1_0.setText(panel.txt_1_0.getText().toUpperCase());
								finish.youAnswer.txt_1_1.setText(panel.txt_1_1.getText().toUpperCase());
								finish.youAnswer.txt_1_2.setText(panel.txt_1_2.getText().toUpperCase());
								finish.youAnswer.txt_1_3.setText(panel.txt_1_3.getText().toUpperCase());

								finish.youAnswer.txt_2_0.setText(panel.txt_2_0.getText().toUpperCase());
								finish.youAnswer.txt_2_1.setText(panel.txt_2_1.getText().toUpperCase());
								finish.youAnswer.txt_2_2.setText(panel.txt_2_2.getText().toUpperCase());
								finish.youAnswer.txt_2_3.setText(panel.txt_2_3.getText().toUpperCase());

								finish.youAnswer.txt_3_0.setText(panel.txt_3_0.getText().toUpperCase());
								finish.youAnswer.txt_3_1.setText(panel.txt_3_1.getText().toUpperCase());
								finish.youAnswer.txt_3_2.setText(panel.txt_3_2.getText().toUpperCase());
								finish.youAnswer.txt_3_3.setText(panel.txt_3_3.getText().toUpperCase());
								if(playerName == null ||  "".equals(playerName)){
									JOptionPane.showMessageDialog(null, "You must put your name on the program finished.");
								}else{
									GameDao.insertHighScore("4",playerName, score, time);
								}
							}
							cardLayout.show(pnMain, "2");
						}
					}else{
						panel.btFinish.setToolTipText("Result");
						cardLayout.show(pnMain, "2");
					}
				}
			});
			pnMain.add(panel,"1");
			finish = new PanelFinish4x4(img, this.getSize().width, this.getSize().height);
			//Return game form
			finish.btBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(pnMain, "1");
					panel.btFinish.setToolTipText("Result");
					panel.btFinish.setIcon(new ImageIcon(getClass().getResource("/images/result.png")));
				}
			});
			//Return main menu
			finish.btMainMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new GameMainView().setVisible(true);
					dispose();
				}
			});
			//Quit game
			finish.btQuit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "Are you want to quit game?");
					if(result == 0){
						System.exit(1);
					}
				}
			});
			//View top high score
			finish.btHighScores.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new HighScoresView("4").setVisible(true);
				}
			});
			pnMain.add(finish,"2");
			
			cardLayout.show(pnMain, "1");
			c.add(pnMain);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	//Check right result of player
	public void checkSame(String _answer, int _location) {
		if(panel.listAnswer4x4.get(_location).getDetail() != null){
			countQuestions++;
			String answerData1 = panel.listAnswer4x4.get(_location).getValue1()+
			panel.listAnswer4x4.get(_location).getValue2()+
			panel.listAnswer4x4.get(_location).getValue3()+
			panel.listAnswer4x4.get(_location).getValue4();
			if(_answer.equals(answerData1.toLowerCase())){
				countAnswers++;
			}
		}
	}
}
