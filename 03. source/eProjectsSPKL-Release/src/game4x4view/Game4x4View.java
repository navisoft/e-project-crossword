package game4x4view;

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

import thread.CheckEmpty;
import thread.CountTime;
import view.GameMainView;
import view.PanelFinish;

public class Game4x4View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameBg4x4View panel;
	PanelFinish finish;
	CountTime countTime;
	Thread threadCountTime;
	int countQuestions = 0;
	int countAnswers = 0;
	JPanel pnMain = new JPanel();
	CardLayout cardLayout = new CardLayout();
	
	CheckEmpty checkEmpty;
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
		this.setTitle("Crossword");
		this.setPreferredSize(new Dimension(720, 490));
		this.setResizable(false);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-720)/2, (dimension.height-490)/2);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setVisible(true);
		pnMain.setLayout(cardLayout);
		Container c = this.getContentPane();
        try {
			BufferedImage img = ImageIO.read(new File("src/view/images/crossword_bg.png"));
			panel = new GameBg4x4View(img,this.getSize().width, this.getSize().height);
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
					new Game4x4View().setVisible(true);
					dispose();
				}
			});
			checkEmpty = new CheckEmpty(panel.txt_0_0, panel.txt_0_1, panel.txt_0_2, 
					panel.txt_0_3, panel.txt_1_0, panel.txt_1_1, panel.txt_1_2, panel.txt_1_3, 
					panel.txt_2_0, panel.txt_2_1, panel.txt_2_2, panel.txt_2_3, panel.txt_3_0, 
					panel.txt_3_1, panel.txt_3_2, panel.txt_3_3, panel.btFinish, true);
			threadCheckEmpty = new Thread(checkEmpty);
			threadCheckEmpty.start();
			panel.btFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String playerName = JOptionPane.showInputDialog(null, "Input your name:");
					try {
						if(!playerName.equals("")){
							countTime.flag = false;
							countTime.seconds ++;
							String time = countTime.minutes+":"+countTime.seconds;
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
							
							finish.proAnswer.txt_0_0.setText(panel.listAnswer4x4.get(0).getValue1());
							finish.proAnswer.txt_0_1.setText(panel.listAnswer4x4.get(0).getValue2());
							finish.proAnswer.txt_0_2.setText(panel.listAnswer4x4.get(0).getValue3());
							finish.proAnswer.txt_0_3.setText(panel.listAnswer4x4.get(0).getValue4());	
							
							finish.proAnswer.txt_1_0.setText(panel.listAnswer4x4.get(1).getValue1());
							finish.proAnswer.txt_1_1.setText(panel.listAnswer4x4.get(1).getValue2());
							finish.proAnswer.txt_1_2.setText(panel.listAnswer4x4.get(1).getValue3());
							finish.proAnswer.txt_1_3.setText(panel.listAnswer4x4.get(1).getValue4());	

							finish.proAnswer.txt_2_0.setText(panel.listAnswer4x4.get(2).getValue1());
							finish.proAnswer.txt_2_1.setText(panel.listAnswer4x4.get(2).getValue2());
							finish.proAnswer.txt_2_2.setText(panel.listAnswer4x4.get(2).getValue3());
							finish.proAnswer.txt_2_3.setText(panel.listAnswer4x4.get(2).getValue4());	

							finish.proAnswer.txt_3_0.setText(panel.listAnswer4x4.get(3).getValue1());
							finish.proAnswer.txt_3_1.setText(panel.listAnswer4x4.get(3).getValue2());
							finish.proAnswer.txt_3_2.setText(panel.listAnswer4x4.get(3).getValue3());
							finish.proAnswer.txt_3_3.setText(panel.listAnswer4x4.get(3).getValue4());	
									
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
							panel.btFinish.setEnabled(false);
							checkEmpty.flag = false;
							
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
							cardLayout.show(pnMain, "2");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Continues...");
					}
				}
			});
			pnMain.add(panel,"1");
			img = ImageIO.read(new File("src/view/images/crossword_bg.png"));
			finish = new PanelFinish(img, this.getSize().width, this.getSize().height);
			
			pnMain.add(finish,"2");
			
			cardLayout.show(pnMain, "1");
			c.add(pnMain);
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
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
