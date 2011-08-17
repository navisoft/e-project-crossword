package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;


import javax.swing.JButton;

import javax.swing.ImageIcon;
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
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void initComponent() {
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 3;
		bagConstraints.insets = new Insets(10, 10, 10, 10);
		lbMain.setText("Please chose a game type to play");
		lbMain.setFont(new Font("Arial",1, 20));
		this.add(lbMain,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 10, 10, 10);
		bt4x4.setText("4 x 4");
		bt4x4.setPreferredSize(new Dimension(150, 40));
		bt4x4.setIcon(new ImageIcon("src/view/images/cancel.png"));
		bt4x4.setFont(new Font("Arial",1, 12));
		this.add(bt4x4,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 10, 10, 10);
		bt6x6.setText("6 x 6");
		bt6x6.setPreferredSize(new Dimension(150, 40));
		bt6x6.setIcon(new ImageIcon("src/view/images/cancel.png"));
		bt6x6.setFont(new Font("Arial",1, 12));
		this.add(bt6x6,bagConstraints);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
	}
}
