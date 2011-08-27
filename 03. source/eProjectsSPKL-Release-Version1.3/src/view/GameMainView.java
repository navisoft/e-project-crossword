package view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import sound.Sound_player;

public class GameMainView extends JWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    Clip clip;
    Sound_player sound_player;
	PanelGameMainView panel;
	HighScoresView highScoresView = new HighScoresView("4");
	int xMouseFirst;
	int yMouseFirst;
	public GameMainView() {
		// TODO Auto-generated constructor stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load error!");
		}
		this.setSize(new Dimension(400, 500));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-400)/2, (dimension.height-500)/2);
		this.setLayout(new BorderLayout());
		Container c = this.getContentPane();
        sound_player=new Sound_player();
        clip=sound_player.Player();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        try {
        	ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/images/gamemain.png"));
            Image img = image.getImage();
			panel = new PanelGameMainView(img, this.getSize().width, this.getSize().height);
			panel.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent e) {
					xMouseFirst = e.getX();
					yMouseFirst = e.getY();
				}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
			});
			panel.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					if(e.getY()>=8 && e.getY()<=25){
						if(e.getX()>=482 && e.getX()<=496){
							setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
						}else{
							setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
						}
					}else{
						setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
					}
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					int xMouseCurrent = e.getX();
					int yMouseCurrent = e.getY();
					
					int xLocationFirst = getLocation().x;
					int yLocationFirst = getLocation().y;
					
					setLocation(xMouseCurrent-xMouseFirst+xLocationFirst, yMouseCurrent-yMouseFirst+yLocationFirst);
				}
			});
			panel.btPlayGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ChoseTypeGame().setVisible(true);
					dispose();
					clip.close();
				}
			});
			panel.btManageGame.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new LoginForm("no").setVisible(true);
					dispose();
					clip.close();
				}
			});
			panel.btHighScores.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!highScoresView.isVisible()){
						highScoresView.setVisible(true);
					}else{
						highScoresView.dispose();
						highScoresView.setVisible(true);
					}
				}
			});
			panel.btHelp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
			            Desktop.getDesktop().open(new File("help/help.chm"));
			        } catch (IOException ex) {
			            JOptionPane.showMessageDialog(null, ex);
			        }
				}
			});
			panel.btQuit.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(1);
				}
			});
			c.add(panel);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
