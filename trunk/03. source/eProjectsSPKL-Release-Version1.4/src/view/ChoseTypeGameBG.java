package view;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChoseTypeGameBG extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image img;
	public int width;
	public int height;
	public JLabel lbMain = new JLabel();
	
	public JButton bt4x4 = new JButton();
	public JButton bt6x6 = new JButton();
	
	public ChoseTypeGameBG(Image _img,int _width,int _height) {
		try {
			// TODO Auto-generated constructor stub
			this.img = _img;
			this.width = _width;
			this.height = _height;
			this.setLayout(new GridBagLayout());
			initComponent();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	private void initComponent() {
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 25);
		bt4x4.setFont(new Font("Arial",1, 25));
		bt4x4.setPreferredSize(new Dimension(150, 50));
		bt4x4.setIcon(new ImageIcon(getClass().getResource("/images/4x4.png")));
		bt4x4.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {
				bt4x4.setIcon(new ImageIcon(getClass().getResource("/images/4x4.png")));
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				bt4x4.setIcon(new ImageIcon(getClass().getResource("/images/4x4_hover.png")));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		this.add(bt4x4,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 25, 0, 0);
		bt6x6.setPreferredSize(new Dimension(150, 50));
		bt6x6.setIcon(new ImageIcon(getClass().getResource("/images/6x6.png")));
		bt6x6.setBorder(BorderFactory.createEmptyBorder());
		bt6x6.setFont(new Font("Arial",1, 25));
		bt6x6.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {
				bt6x6.setIcon(new ImageIcon(getClass().getResource("/images/6x6.png")));
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				bt6x6.setIcon(new ImageIcon(getClass().getResource("/images/6x6_hover.png")));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		this.add(bt6x6,bagConstraints);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
	}
}
