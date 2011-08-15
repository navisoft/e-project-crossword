package view;


import game4x4view.Game4x4View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ChoseTypeGame extends JFrame{
	/**
	 * 
	 */
	JLabel lbChose = new JLabel();
	JButton bt4x4 = new JButton();
	JButton bt6x6 = new JButton();
	private static final long serialVersionUID = 1L;
	public ChoseTypeGame() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.initComponent();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initComponent() {
		this.setTitle("Chose Game Type");
		this.setPreferredSize(new Dimension(600, 200));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-600)/2, (screenSize.height-200)/2);
		this.setLayout(new GridBagLayout());
		Container container = this.getContentPane();
		this.pack();
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(10, 0, 10, 0);
		lbChose.setText("Chose a game type to play");
		lbChose.setFont(new Font("Arial", NORMAL, 25));
		container.add(lbChose,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 10);
		bt4x4.setText("4 x 4");
		bt4x4.setPreferredSize(new Dimension(150, 40));
		container.add(bt4x4,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 10, 0, 0);
		bt6x6.setText("6 x 6");
		bt6x6.setPreferredSize(new Dimension(150, 40));
		container.add(bt6x6,constraints);
		
		bt4x4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Game4x4View().setVisible(true);
				dispose();
			}
		});
	}
}
