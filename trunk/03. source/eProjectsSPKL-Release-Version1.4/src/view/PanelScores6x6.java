package view;
import java.awt.Color;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.GameDao;

import model.PlayerModel;

public class PanelScores6x6 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image img;
	public int width;
	public int height;
	GridBagConstraints bagConstraints = new GridBagConstraints();
	public JLabel lbPlayerName;
	public JLabel lbPlayerScore;
	public JLabel lbPlayerTime;

	public JButton bt4x4 = new JButton();
	public PanelScores6x6(Image _img,int _width,int _height) {
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
		ArrayList<PlayerModel> listHighScore =  new ArrayList<PlayerModel>();
		listHighScore = GameDao.getHighScores6x6();
		createLB(lbPlayerName, 0, 0, new Insets(190, 40, 0, 0), listHighScore.get(0).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 0, new Insets(190, 0, 0, 0), listHighScore.get(0).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 0, new Insets(190, 0, 0, 0), listHighScore.get(0).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 1, new Insets(0, 40, 0, 0), listHighScore.get(1).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 1, new Insets(0, 0, 0, 0), listHighScore.get(1).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 1, new Insets(0, 0, 0, 0), listHighScore.get(1).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 2, new Insets(0, 40, 0, 0), listHighScore.get(2).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 2, new Insets(0, 0, 0, 0), listHighScore.get(2).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 2, new Insets(0, 0, 0, 0), listHighScore.get(2).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 3, new Insets(0, 40, 0, 0), listHighScore.get(3).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 3, new Insets(0, 0, 0, 0), listHighScore.get(3).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 3, new Insets(0, 0, 0, 0), listHighScore.get(3).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 4, new Insets(0, 40, 0, 0), listHighScore.get(4).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 4, new Insets(0, 0, 0, 0), listHighScore.get(4).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 4, new Insets(0, 0, 0, 0), listHighScore.get(4).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 5, new Insets(0, 40, 0, 0), listHighScore.get(5).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 5, new Insets(0, 0, 0, 0), listHighScore.get(5).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 5, new Insets(0, 0, 0, 0), listHighScore.get(5).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 6, new Insets(0, 40, 0, 0), listHighScore.get(6).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 6, new Insets(0, 0, 0, 0), listHighScore.get(6).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 6, new Insets(0, 0, 0, 0), listHighScore.get(6).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 7, new Insets(0, 40, 0, 0), listHighScore.get(7).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 7, new Insets(0, 0, 0, 0), listHighScore.get(7).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 7, new Insets(0, 0, 0, 0), listHighScore.get(7).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 8, new Insets(0, 40, 0, 0), listHighScore.get(8).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 8, new Insets(0, 0, 0, 0), listHighScore.get(8).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 8, new Insets(0, 0, 0, 0), listHighScore.get(8).getPlayerTime(), 100, 30);
		
		createLB(lbPlayerName, 0, 9, new Insets(0, 40, 0, 0), listHighScore.get(9).getPlayerName(), 130, 30);
		createLB(lbPlayerScore, 1, 9, new Insets(0, 0, 0, 0), listHighScore.get(9).getPlayerScore(), 125, 30);
		createLB(lbPlayerTime, 2, 9, new Insets(0, 0, 0, 0), listHighScore.get(9).getPlayerTime(), 100, 30);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 10;
		bagConstraints.gridwidth = 3;
		bagConstraints.insets = new Insets(10, 0, 0, 0);
		bt4x4.setIcon(new ImageIcon(getClass().getResource("/images/4x4.png")));
		bt4x4.setPreferredSize(new Dimension(100, 30));bt4x4.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {
				bt4x4.setIcon(new ImageIcon(getClass().getResource("/images/4x4.png")));
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
	}
	public void createLB(JLabel _label, int _locationX, int _locationY,Insets _insets, String _txtData, int _width, int _height) {
		bagConstraints.gridx = _locationX;
		bagConstraints.gridy = _locationY;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = _insets;
		_label = new JLabel();
		_label.setText(_txtData);
		_label.setPreferredSize(new Dimension(_width, _height));
		_label.setFont(new Font("Arial", 1, 17));
		_label.setForeground(Color.blue);
		this.add(_label,bagConstraints);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
	}
}
