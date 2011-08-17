package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ChoseTypeGame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ChoseTypeGameBG panel;
	public ChoseTypeGame() {
		// TODO Auto-generated constructor stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load error!");
		}
		this.setSize(new Dimension(500, 150));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Chose Game Type");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width-300)/2, (dimension.height-150)/2);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		Container c = this.getContentPane();
        try {
			BufferedImage img = ImageIO.read(new File("src/view/images/server_bg.png"));
			panel = new ChoseTypeGameBG(img,this.getSize().width, this.getSize().height);
			c.add(panel);
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
}
