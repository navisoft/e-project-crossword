package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class HighScoresView extends JWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelScores4x4 scores4x4;
	PanelScores6x6 scores6x6;
	JPanel pnMain = new JPanel();
	CardLayout cardLayout = new CardLayout();
	String type;
	public HighScoresView(String type) {
		this.type = type;
		// TODO Auto-generated constructor stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load error!");
		}
		this.setSize(new Dimension(400, 550));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-400)/2, (dimension.height-550)/2);
		this.setLayout(new BorderLayout());
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Container c = this.getContentPane();
		pnMain.setLayout(cardLayout);
        try {
			BufferedImage img = ImageIO.read(new File("src/view/images/score.png"));
			scores4x4 = new PanelScores4x4(img,this.getSize().width, this.getSize().height);
			pnMain.add(scores4x4,"1");
			scores6x6 = new PanelScores6x6(img,this.getSize().width, this.getSize().height);
			pnMain.add(scores6x6,"2");
			cardLayout.show(pnMain, type);
			c.add(pnMain);
			scores4x4.bt6x6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(pnMain, "2");
				}
			});
			scores6x6.bt4x4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(pnMain, "1");
				}
			});
			c.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					dispose();
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
}
