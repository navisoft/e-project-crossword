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

import thread.CheckEmpty;
import thread.CountTime;
import view.GameMainView;

public class Game6x6View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameBg6x6View panel;
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
		this.setPreferredSize(new Dimension(720, 490));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-720)/2, (dimension.height-490)/2);
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
			CheckEmpty checkEmpty = new CheckEmpty(panel.txt_0_0, panel.txt_0_1, panel.txt_0_2, 
					panel.txt_0_3, panel.txt_1_0, panel.txt_1_1, panel.txt_1_2, panel.txt_1_3, 
					panel.txt_2_0, panel.txt_2_1, panel.txt_2_2, panel.txt_2_3, panel.txt_3_0, 
					panel.txt_3_1, panel.txt_3_2, panel.txt_3_3, panel.btFinish, true);
			Thread threadCheckEmpty = new Thread(checkEmpty);
			threadCheckEmpty.start();
			panel.btFinish.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you've completed the game?");
					if(result==0){
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
						JOptionPane.showMessageDialog(null, "You answered the "+countAnswers+" / "+countQuestions+" questions.\n" +
								" As time is: "+time+"\n"+
								"Correct answer is:\n"+
								panel.listAnswer6x6.get(0).getValue1()+"  "+
								panel.listAnswer6x6.get(0).getValue2()+"  "+
								panel.listAnswer6x6.get(0).getValue3()+"  "+
								panel.listAnswer6x6.get(0).getValue4()+"\n"+

								panel.listAnswer6x6.get(1).getValue1()+"  "+
								panel.listAnswer6x6.get(1).getValue2()+"  "+
								panel.listAnswer6x6.get(1).getValue3()+"  "+
								panel.listAnswer6x6.get(1).getValue4()+"\n"+

								panel.listAnswer6x6.get(2).getValue1()+"  "+
								panel.listAnswer6x6.get(2).getValue2()+"  "+
								panel.listAnswer6x6.get(2).getValue3()+"  "+
								panel.listAnswer6x6.get(2).getValue4()+"\n"+

								panel.listAnswer6x6.get(3).getValue1()+"  "+
								panel.listAnswer6x6.get(3).getValue2()+"  "+
								panel.listAnswer6x6.get(3).getValue3()+"  "+
								panel.listAnswer6x6.get(3).getValue4()
								);
								cardLayout.show(pnMain, "2");
						panel.txt_0_0.setEditable(false);
						panel.txt_0_1.setEditable(false);
						panel.txt_0_2.setEditable(false);
						panel.txt_0_3.setEditable(false);
						panel.txt_1_0.setEditable(false);
						panel.txt_1_1.setEditable(false);
						panel.txt_1_2.setEditable(false);
						panel.txt_1_3.setEditable(false);
						panel.txt_2_0.setEditable(false);
						panel.txt_2_1.setEditable(false);
						panel.txt_2_2.setEditable(false);
						panel.txt_2_3.setEditable(false);
						panel.txt_3_0.setEditable(false);
						panel.txt_3_1.setEditable(false);
						panel.txt_3_2.setEditable(false);
						panel.txt_3_3.setEditable(false);
					}
				}
			});
			pnMain.add(panel,"1");
			cardLayout.show(pnMain, "1");
			c.add(pnMain);
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
	public void checkSame(String _answer, int _location) {
		if(panel.listAnswer6x6.get(_location).getDetail() != null){
			countQuestions++;
			String answerData1 = panel.listAnswer6x6.get(_location).getValue1()+
			panel.listAnswer6x6.get(_location).getValue2()+
			panel.listAnswer6x6.get(_location).getValue3()+
			panel.listAnswer6x6.get(_location).getValue4();
			if(_answer.equals(answerData1.toLowerCase())){
				countAnswers++;
			}
		}
	}
}
