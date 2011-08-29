package view;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelAbout extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image img;
	public int width;
	public int height;
	
	public PanelAbout(Image _img,int _width,int _height) {
		try {
			// TODO Auto-generated constructor stub
			this.img = _img;
			this.width = _width;
			this.height = _height;
			this.setLayout(new GridBagLayout());
			initComponent();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	private void initComponent() {
	
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
	}
}
