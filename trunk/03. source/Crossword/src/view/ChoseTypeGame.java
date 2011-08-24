package view;

import game4x4view.Game4x4View;
import game6x6view.Game6x6View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dao.GameDao;

public class ChoseTypeGame extends JWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ChoseTypeGameBG panel;
	int xMouseFirst;
	int yMouseFirst;
	public ChoseTypeGame() {
		// TODO Auto-generated constructor stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load error!");
		}
		this.setSize(new Dimension(500, 200));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-500)/2, (dimension.height-200)/2);
		this.setLayout(new BorderLayout());
		Container c = this.getContentPane();
        try {
			BufferedImage img = ImageIO.read(new File("src/view/images/chosetypebg.png"));
			panel = new ChoseTypeGameBG(img,this.getSize().width, this.getSize().height);
			panel.bt4x4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Game4x4View().setVisible(true);
					dispose();
				}
			});
			panel.bt6x6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Game6x6View().setVisible(true);
					dispose();
				}
			});
			panel.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					if(e.getY()>=0 && e.getY()<=20){
						if(e.getX()>=482 && e.getX()<=500){
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
			panel.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					if(e.getY()>=8 && e.getY()<=25){
						if(e.getX()>=482 && e.getX()<=496){
							setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
							new GameMainView().setVisible(true);
							dispose();
						}
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {
					xMouseFirst = e.getX();
					yMouseFirst = e.getY();
				}
				
				@Override
				public void mouseExited(MouseEvent e) {}
				
				@Override
				public void mouseEntered(MouseEvent e) {}
				
				@Override
				public void mouseClicked(MouseEvent e) {}
			});
			this.addComponentListener(new ComponentListener() {
				
				@Override
				public void componentShown(ComponentEvent arg0) {
					if(GameDao.checkExistsData("4")){
						panel.bt4x4.setEnabled(true);
					}else{
						panel.bt4x4.setEnabled(false);
					}
					if(GameDao.checkExistsData("6")){
						panel.bt6x6.setEnabled(true);
					}else{
						panel.bt6x6.setEnabled(false);
					}
				}
				
				@Override
				public void componentResized(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void componentMoved(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void componentHidden(ComponentEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			c.add(panel);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
