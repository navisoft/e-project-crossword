package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelFinish extends JPanel{
	private static final long serialVersionUID = 1L;
	public Image img;
	public int width;
	public int height;
	public JPanel pnResults = new JPanel();
	public JPanel pnAnswers = new JPanel();
	public JPanel pnButton = new JPanel();
	public PanelDisplayAnswer proAnswer;
	public PanelDisplayAnswer youAnswer;
	
	public JLabel playerName = new JLabel();
	public PanelFinish(Image _img,int _width,int _height) {
		try {
			this.img = _img;this.width = _width;
			this.height = _height;
			this.setLayout(new GridBagLayout());
			initComponent();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	private void initComponent() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnResults.setPreferredSize(new Dimension(710, 100));
		pnResults.setBorder(BorderFactory.createTitledBorder("Results"));
		pnResults.setBackground(Color.white);

		GridBagConstraints constraintsResult = new GridBagConstraints();
		constraintsResult.gridx = 0;
		constraintsResult.gridy = 0;
		constraintsResult.gridwidth = 1;
		
		this.add(pnResults,constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnAnswers.setPreferredSize(new Dimension(580, 280));
		pnAnswers.setLayout(new GridBagLayout());
		GridBagConstraints constraintsAnswer = new GridBagConstraints();
		constraintsAnswer.gridx = 0;
		constraintsAnswer.gridy = 0;
		constraintsAnswer.gridwidth = 1;
		constraintsAnswer.insets = new Insets(0, 0, 0, 10);
		proAnswer = new PanelDisplayAnswer();
		pnAnswers.add(proAnswer,constraintsAnswer);
		
		constraintsAnswer.gridx = 1;
		constraintsAnswer.gridy = 0;
		constraintsAnswer.gridwidth = 1;
		constraintsAnswer.insets = new Insets(0, 10, 0, 0);
		youAnswer = new PanelDisplayAnswer();
		pnAnswers.add(youAnswer,constraintsAnswer);
		
		pnAnswers.setBackground(Color.white);
		this.add(pnAnswers,constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnButton.setPreferredSize(new Dimension(710, 80));
		pnButton.setBorder(BorderFactory.createTitledBorder("Process"));
		pnButton.setBackground(Color.white);
		this.add(pnButton,constraints);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", 1, 25));
		g.drawString("P", 25, 131);
		g.setFont(new Font("Arial", 1, 27));
		g.drawString("R", 24, 168);
		g.setFont(new Font("Arial", 1, 29));
		g.drawString("O", 23, 207);
		g.setFont(new Font("Arial", 1, 31));
		g.drawString("G", 22, 247);
		g.setFont(new Font("Arial", 1, 33));
		g.drawString("R", 21, 286);
		g.setFont(new Font("Arial", 1, 35));
		g.drawString("A", 20, 330);
		g.setFont(new Font("Arial", 1, 37));
		g.drawString("M", 19, 377);
		

		g.setFont(new Font("Arial", 1, 27));
		g.drawString("Y", 675, 168);
		g.setFont(new Font("Arial", 1, 31));
		g.drawString("O", 673, 247);
		g.setFont(new Font("Arial", 1, 35));
		g.drawString("U", 671, 330);
	}
	
}
