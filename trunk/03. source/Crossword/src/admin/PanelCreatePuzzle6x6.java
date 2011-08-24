package admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCreatePuzzle6x6 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelTxtBox6x6Admin panelTxtBox6x6Admin = new PanelTxtBox6x6Admin();
	
	JPanel pnQuestion = new JPanel();
	JPanel pnButton = new JPanel();
	
	JButton btSavePuzzle = new JButton();
	JButton btEmpty = new JButton();
	public JLabel lbInputAnswers = new JLabel();
	
	public JTextField txtPuzzleName = new JTextField();
	public JTextField txtQuestion1 = new JTextField();
	public JTextField txtQuestion2 = new JTextField();
	public JTextField txtQuestion3 = new JTextField();
	public JTextField txtQuestion4 = new JTextField();
	public JTextField txtQuestion5 = new JTextField();
	public JTextField txtQuestion6 = new JTextField();
	public JTextField txtQuestion7 = new JTextField();
	public JTextField txtQuestion8 = new JTextField();
	public JTextField txtQuestion9 = new JTextField();
	public JTextField txtQuestion10 = new JTextField();
	public JTextField txtQuestion11 = new JTextField();
	public JTextField txtQuestion12 = new JTextField();
	
	public PanelCreatePuzzle6x6() {
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(980, 500));
		this.setBackground(Color.white);
		this.setVisible(true);
		GridBagConstraints bagConstraints = new GridBagConstraints();
		
		//Day la noi chua cau tra loi

		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 10);
		
		this.add(panelTxtBox6x6Admin,bagConstraints);
		
		//Day la noi chua cac button

		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(10, 0, 0, 10);
		pnButton.setPreferredSize(new Dimension(390, 50));
		pnButton.setBackground(Color.white);
		pnButton.setLayout(new GridBagLayout());
		this.add(pnButton,bagConstraints);
		
		//Dua ca thanh phan vao pnButton
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		btSavePuzzle.setPreferredSize(new Dimension(195, 50));
		btSavePuzzle.setIcon(new ImageIcon("src/view/images/save.png"));
		btSavePuzzle.setToolTipText("Save");
		pnButton.add(btSavePuzzle,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		btEmpty.setPreferredSize(new Dimension(195, 50));
		btEmpty.setIcon(new ImageIcon("src/view/images/clear.png"));
		btEmpty.setToolTipText("Clear");
		pnButton.add(btEmpty,bagConstraints);
		
		//Day la noi chua cac cau hoi
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.gridheight = 2;
		bagConstraints.insets = new Insets(0, 10, 0, 0);
		pnQuestion.setPreferredSize(new Dimension(510, 440));
		pnQuestion.setBackground(Color.white);
		pnQuestion.setLayout(new GridBagLayout());
		this.add(pnQuestion,bagConstraints);
		

		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth =2;
		bagConstraints.gridheight = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtPuzzleName.setPreferredSize(new Dimension(510, 55));
		txtPuzzleName.setBorder(BorderFactory.createTitledBorder("Puzzle Name:"));
		pnQuestion.add(txtPuzzleName,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion1.setPreferredSize(new Dimension(255, 55));
		txtQuestion1.setBorder(BorderFactory.createTitledBorder("Question row 1:"));
		pnQuestion.add(txtQuestion1,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion2.setPreferredSize(new Dimension(255, 55));
		txtQuestion2.setBorder(BorderFactory.createTitledBorder("Question row 2:"));
		pnQuestion.add(txtQuestion2,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion3.setPreferredSize(new Dimension(255, 55));
		txtQuestion3.setBorder(BorderFactory.createTitledBorder("Question row 3:"));
		pnQuestion.add(txtQuestion3,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion4.setPreferredSize(new Dimension(255, 55));
		txtQuestion4.setBorder(BorderFactory.createTitledBorder("Question row 4:"));
		pnQuestion.add(txtQuestion4,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 3;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion5.setPreferredSize(new Dimension(255, 55));
		txtQuestion5.setBorder(BorderFactory.createTitledBorder("Question row 5:"));
		pnQuestion.add(txtQuestion5,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 3;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion6.setPreferredSize(new Dimension(255, 55));
		txtQuestion6.setBorder(BorderFactory.createTitledBorder("Question row 6:"));
		pnQuestion.add(txtQuestion6,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion7.setPreferredSize(new Dimension(255, 55));
		txtQuestion7.setBorder(BorderFactory.createTitledBorder("Question colunm 1:"));
		pnQuestion.add(txtQuestion7,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion8.setPreferredSize(new Dimension(255, 55));
		txtQuestion8.setBorder(BorderFactory.createTitledBorder("Question colunm 2:"));
		pnQuestion.add(txtQuestion8,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 5;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion9.setPreferredSize(new Dimension(255, 55));
		txtQuestion9.setBorder(BorderFactory.createTitledBorder("Question colunm 3:"));
		pnQuestion.add(txtQuestion9,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 5;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion10.setPreferredSize(new Dimension(255, 55));
		txtQuestion10.setBorder(BorderFactory.createTitledBorder("Question colunm 4:"));
		pnQuestion.add(txtQuestion10,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 6;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion11.setPreferredSize(new Dimension(255, 55));
		txtQuestion11.setBorder(BorderFactory.createTitledBorder("Question colunm 5:"));
		pnQuestion.add(txtQuestion11,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 6;
		bagConstraints.gridwidth =1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		txtQuestion12.setPreferredSize(new Dimension(255, 55));
		txtQuestion12.setBorder(BorderFactory.createTitledBorder("Question colunm 6:"));
		pnQuestion.add(txtQuestion12,bagConstraints);
	}
}
