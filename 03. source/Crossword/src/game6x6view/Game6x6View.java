package game6x6view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dao.GameDao;

import thread.CheckEmpty6x6;
import thread.CountTime;
import view.GameMainView;
import view.HighScoresView;
import view.PanelFinish6x6;

public class Game6x6View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameBg6x6View panel;
	PanelFinish6x6 finish;
	CountTime countTime;
	Thread threadCountTime;
	int countQuestions = 0;
	int countAnswers = 0;
	JPanel pnMain = new JPanel();
	CardLayout cardLayout = new CardLayout();
	public Game6x6View() {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load error!");
		}
		this.setTitle("Crossword");
		this.setPreferredSize(new Dimension(760, 510));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-720)/2, (dimension.height-490)/2);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setVisible(true);
		pnMain.setLayout(cardLayout);
		Container c = this.getContentPane();
        try {
			BufferedImage img = ImageIO.read(new File("src/view/images/crossword_bg.png"));
			panel = new GameBg6x6View(img,this.getSize().width, this.getSize().height);
			countTime = new CountTime(panel.lbTime);
			threadCountTime = new Thread(countTime);
			threadCountTime.start();
			panel.btMainMenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new GameMainView().setVisible(true);
					dispose();
				}
			});
			panel.btNewGame.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Game6x6View().setVisible(true);
					dispose();
				}
			});
			CheckEmpty6x6 checkEmpty6x6 = new CheckEmpty6x6(
					panel.txt_0_0, panel.txt_0_1, panel.txt_0_2, panel.txt_0_3, panel.txt_0_4, panel.txt_0_5,
					panel.txt_1_0, panel.txt_1_1, panel.txt_1_2, panel.txt_1_3, panel.txt_1_4, panel.txt_1_5, 
					panel.txt_2_0, panel.txt_2_1, panel.txt_2_2, panel.txt_2_3, panel.txt_2_4, panel.txt_2_5, 
					panel.txt_3_0, panel.txt_3_1, panel.txt_3_2, panel.txt_3_3, panel.txt_3_4, panel.txt_3_5,
					panel.txt_4_0, panel.txt_4_1, panel.txt_4_2, panel.txt_4_3, panel.txt_4_4, panel.txt_5_5, 
					panel.txt_5_0, panel.txt_5_1, panel.txt_5_2, panel.txt_5_3, panel.txt_4_4, panel.txt_5_5, 
					panel.btFinish, true);
			Thread threadCheckEmpty = new Thread(checkEmpty6x6);
			threadCheckEmpty.start();
			panel.btFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(panel.btFinish.getText().equals("Finish")){
						int result = JOptionPane.showConfirmDialog(null, "Are you sure you've completed the game?");
						if(result==0){
							countTime.flag = false;
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
								String answer0 = panel.txt_0_0.getText()+panel.txt_0_1.getText()+panel.txt_0_2.getText()+panel.txt_0_3.getText()+panel.txt_0_4.getText()+panel.txt_0_5.getText();
								String answer1 = panel.txt_1_0.getText()+panel.txt_1_1.getText()+panel.txt_1_2.getText()+panel.txt_1_3.getText()+panel.txt_1_4.getText()+panel.txt_1_5.getText();
								String answer2 = panel.txt_2_0.getText()+panel.txt_2_1.getText()+panel.txt_2_2.getText()+panel.txt_2_3.getText()+panel.txt_2_4.getText()+panel.txt_2_5.getText();
								String answer3 = panel.txt_3_0.getText()+panel.txt_3_1.getText()+panel.txt_3_2.getText()+panel.txt_3_3.getText()+panel.txt_3_4.getText()+panel.txt_3_5.getText();
								String answer4 = panel.txt_4_0.getText()+panel.txt_4_1.getText()+panel.txt_4_2.getText()+panel.txt_4_3.getText()+panel.txt_4_4.getText()+panel.txt_4_5.getText();
								String answer5 = panel.txt_5_0.getText()+panel.txt_5_1.getText()+panel.txt_5_2.getText()+panel.txt_5_3.getText()+panel.txt_5_4.getText()+panel.txt_5_5.getText();
								
								String answer6 = panel.txt_0_0.getText()+panel.txt_1_0.getText()+panel.txt_2_0.getText()+panel.txt_3_0.getText()+panel.txt_4_0.getText()+panel.txt_5_0.getText();
								String answer7 = panel.txt_0_1.getText()+panel.txt_1_1.getText()+panel.txt_2_1.getText()+panel.txt_3_1.getText()+panel.txt_4_1.getText()+panel.txt_5_1.getText();
								String answer8 = panel.txt_0_2.getText()+panel.txt_1_2.getText()+panel.txt_2_2.getText()+panel.txt_3_2.getText()+panel.txt_4_2.getText()+panel.txt_5_2.getText();
								String answer9 = panel.txt_0_3.getText()+panel.txt_1_3.getText()+panel.txt_2_3.getText()+panel.txt_3_3.getText()+panel.txt_4_3.getText()+panel.txt_5_3.getText();
								String answer10 =panel.txt_0_4.getText()+panel.txt_1_4.getText()+panel.txt_2_4.getText()+panel.txt_3_4.getText()+panel.txt_4_4.getText()+panel.txt_5_4.getText();
								String answer11 =panel.txt_0_5.getText()+panel.txt_1_5.getText()+panel.txt_2_5.getText()+panel.txt_3_5.getText()+panel.txt_4_5.getText()+panel.txt_5_5.getText();
								checkSame(answer0, 0);
								checkSame(answer1, 1);
								checkSame(answer2, 2);
								checkSame(answer3, 3);
								checkSame(answer4, 4);
								checkSame(answer5, 5);
								checkSame(answer6, 6);
								checkSame(answer7, 7);
								checkSame(answer8, 8);
								checkSame(answer9, 9);
								checkSame(answer10, 10);
								checkSame(answer11, 11);finish.playerName.setText("Player Name: "+playerName);
								finish.playerResult.setText("You answered correctly: "+countAnswers+"/"+countQuestions);
								float scores = 15000/(float)countQuestions*(float)countAnswers;
								String score_insert;
								Float score = scores;
								if(score>=10000){
									score_insert = score.toString().substring(0,5);
								}else{
									score_insert = score.toString().substring(0,4);
								}
								finish.playerScore.setText("Your Score: "+ score_insert);
								finish.playerTime.setText("Total Time: "+time);
								
								finish.proAnswer.txt_0_0.setText(panel.listAnswer6x6.get(0).getValue1());
								finish.proAnswer.txt_0_1.setText(panel.listAnswer6x6.get(0).getValue2());
								finish.proAnswer.txt_0_2.setText(panel.listAnswer6x6.get(0).getValue3());
								finish.proAnswer.txt_0_3.setText(panel.listAnswer6x6.get(0).getValue4());
								finish.proAnswer.txt_0_4.setText(panel.listAnswer6x6.get(0).getValue5());
								finish.proAnswer.txt_0_5.setText(panel.listAnswer6x6.get(0).getValue6());		
								
								finish.proAnswer.txt_1_0.setText(panel.listAnswer6x6.get(1).getValue1());
								finish.proAnswer.txt_1_1.setText(panel.listAnswer6x6.get(1).getValue2());
								finish.proAnswer.txt_1_2.setText(panel.listAnswer6x6.get(1).getValue3());
								finish.proAnswer.txt_1_3.setText(panel.listAnswer6x6.get(1).getValue4());	
								finish.proAnswer.txt_1_4.setText(panel.listAnswer6x6.get(1).getValue5());
								finish.proAnswer.txt_1_5.setText(panel.listAnswer6x6.get(1).getValue6());

								finish.proAnswer.txt_2_0.setText(panel.listAnswer6x6.get(2).getValue1());
								finish.proAnswer.txt_2_1.setText(panel.listAnswer6x6.get(2).getValue2());
								finish.proAnswer.txt_2_2.setText(panel.listAnswer6x6.get(2).getValue3());
								finish.proAnswer.txt_2_3.setText(panel.listAnswer6x6.get(2).getValue4());
								finish.proAnswer.txt_2_4.setText(panel.listAnswer6x6.get(2).getValue5());
								finish.proAnswer.txt_2_5.setText(panel.listAnswer6x6.get(2).getValue6());	

								finish.proAnswer.txt_3_0.setText(panel.listAnswer6x6.get(3).getValue1());
								finish.proAnswer.txt_3_1.setText(panel.listAnswer6x6.get(3).getValue2());
								finish.proAnswer.txt_3_2.setText(panel.listAnswer6x6.get(3).getValue3());
								finish.proAnswer.txt_3_3.setText(panel.listAnswer6x6.get(3).getValue4());
								finish.proAnswer.txt_3_4.setText(panel.listAnswer6x6.get(3).getValue5());
								finish.proAnswer.txt_3_5.setText(panel.listAnswer6x6.get(3).getValue6());

								finish.proAnswer.txt_4_0.setText(panel.listAnswer6x6.get(4).getValue1());
								finish.proAnswer.txt_4_1.setText(panel.listAnswer6x6.get(4).getValue2());
								finish.proAnswer.txt_4_2.setText(panel.listAnswer6x6.get(4).getValue3());
								finish.proAnswer.txt_4_3.setText(panel.listAnswer6x6.get(4).getValue4());
								finish.proAnswer.txt_4_4.setText(panel.listAnswer6x6.get(4).getValue5());
								finish.proAnswer.txt_4_5.setText(panel.listAnswer6x6.get(4).getValue6());	

								finish.proAnswer.txt_5_0.setText(panel.listAnswer6x6.get(5).getValue1());
								finish.proAnswer.txt_5_1.setText(panel.listAnswer6x6.get(5).getValue2());
								finish.proAnswer.txt_5_2.setText(panel.listAnswer6x6.get(5).getValue3());
								finish.proAnswer.txt_5_3.setText(panel.listAnswer6x6.get(5).getValue4());
								finish.proAnswer.txt_5_4.setText(panel.listAnswer6x6.get(5).getValue5());
								finish.proAnswer.txt_5_5.setText(panel.listAnswer6x6.get(5).getValue6());	
								
										
								finish.youAnswer.txt_0_0.setText(panel.txt_0_0.getText().toUpperCase());
								finish.youAnswer.txt_0_1.setText(panel.txt_0_1.getText().toUpperCase());
								finish.youAnswer.txt_0_2.setText(panel.txt_0_2.getText().toUpperCase());
								finish.youAnswer.txt_0_3.setText(panel.txt_0_3.getText().toUpperCase());
								finish.youAnswer.txt_0_4.setText(panel.txt_0_4.getText().toUpperCase());
								finish.youAnswer.txt_0_5.setText(panel.txt_0_5.getText().toUpperCase());

								finish.youAnswer.txt_1_0.setText(panel.txt_1_0.getText().toUpperCase());
								finish.youAnswer.txt_1_1.setText(panel.txt_1_1.getText().toUpperCase());
								finish.youAnswer.txt_1_2.setText(panel.txt_1_2.getText().toUpperCase());
								finish.youAnswer.txt_1_3.setText(panel.txt_1_3.getText().toUpperCase());
								finish.youAnswer.txt_1_4.setText(panel.txt_1_4.getText().toUpperCase());
								finish.youAnswer.txt_1_5.setText(panel.txt_1_5.getText().toUpperCase());

								finish.youAnswer.txt_2_0.setText(panel.txt_2_0.getText().toUpperCase());
								finish.youAnswer.txt_2_1.setText(panel.txt_2_1.getText().toUpperCase());
								finish.youAnswer.txt_2_2.setText(panel.txt_2_2.getText().toUpperCase());
								finish.youAnswer.txt_2_3.setText(panel.txt_2_3.getText().toUpperCase());
								finish.youAnswer.txt_2_4.setText(panel.txt_2_4.getText().toUpperCase());
								finish.youAnswer.txt_2_5.setText(panel.txt_2_5.getText().toUpperCase());

								finish.youAnswer.txt_3_0.setText(panel.txt_3_0.getText().toUpperCase());
								finish.youAnswer.txt_3_1.setText(panel.txt_3_1.getText().toUpperCase());
								finish.youAnswer.txt_3_2.setText(panel.txt_3_2.getText().toUpperCase());
								finish.youAnswer.txt_3_3.setText(panel.txt_3_3.getText().toUpperCase());
								finish.youAnswer.txt_3_4.setText(panel.txt_3_4.getText().toUpperCase());
								finish.youAnswer.txt_3_5.setText(panel.txt_3_5.getText().toUpperCase());

								finish.youAnswer.txt_4_0.setText(panel.txt_4_0.getText().toUpperCase());
								finish.youAnswer.txt_4_1.setText(panel.txt_4_1.getText().toUpperCase());
								finish.youAnswer.txt_4_2.setText(panel.txt_4_2.getText().toUpperCase());
								finish.youAnswer.txt_4_3.setText(panel.txt_4_3.getText().toUpperCase());
								finish.youAnswer.txt_4_4.setText(panel.txt_4_4.getText().toUpperCase());
								finish.youAnswer.txt_4_5.setText(panel.txt_4_5.getText().toUpperCase());

								finish.youAnswer.txt_5_0.setText(panel.txt_5_0.getText().toUpperCase());
								finish.youAnswer.txt_5_1.setText(panel.txt_5_1.getText().toUpperCase());
								finish.youAnswer.txt_5_2.setText(panel.txt_5_2.getText().toUpperCase());
								finish.youAnswer.txt_5_3.setText(panel.txt_5_3.getText().toUpperCase());
								finish.youAnswer.txt_5_4.setText(panel.txt_5_4.getText().toUpperCase());
								finish.youAnswer.txt_5_5.setText(panel.txt_5_5.getText().toUpperCase());
								if(playerName == null ||  "".equals(playerName)){
									JOptionPane.showMessageDialog(null, "You must put your name on the program finished.");
								}else{
									GameDao.insertHighScore("6",playerName, score_insert, time);
								}
							}
							cardLayout.show(pnMain, "2");
						}
					}else{
						panel.btFinish.setText("Result");
						cardLayout.show(pnMain, "2");
					}
				}
			});
			pnMain.add(panel,"1");img = ImageIO.read(new File("src/view/images/crossword_bg.png"));
			finish = new PanelFinish6x6(img, this.getSize().width, this.getSize().height);
			finish.btBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(pnMain, "1");
					panel.btFinish.setText("Result");
				}
			});
			finish.btMainMenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new GameMainView().setVisible(true);
					dispose();
				}
			});
			finish.btQuit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "Are you want to quit game?");
					if(result == 0){
						System.exit(1);
					}
				}
			});
			finish.btHighScores.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new HighScoresView("2").setVisible(true);
				}
			});
			pnMain.add(finish,"2");
			cardLayout.show(pnMain, "1");
			c.add(pnMain);
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
	public void checkSame(String _answer, int _location) {
		if(panel.listAnswer6x6.get(_location).getDetail() != null){
			countQuestions++;
			String answerData1 = 
			panel.listAnswer6x6.get(_location).getValue1()+
			panel.listAnswer6x6.get(_location).getValue2()+
			panel.listAnswer6x6.get(_location).getValue3()+
			panel.listAnswer6x6.get(_location).getValue4()+
			panel.listAnswer6x6.get(_location).getValue5()+
			panel.listAnswer6x6.get(_location).getValue6();
			if(_answer.equals(answerData1.toLowerCase())){
				countAnswers++;
			}
		}
	}
}
