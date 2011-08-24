package admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import dao.GameDao;

import model.HighScoresModel;

public class PanelHighScores extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JScrollPane scpHighScores = new JScrollPane();
	JPanel pnResultPlay = new JPanel();
	JPanel pnProcess = new JPanel();
	JPanel pnDisplayHighScores = new JPanel();
	
	String[] itemType = {"4","6"};
	String[] itemLimit = {"0","1000","2000","3000","4000","5000","6000","7000","8000","9000","10000","11000","12000","13000","14000","15000"};
	JComboBox comboBoxType = new JComboBox(itemType);
	JComboBox comboBoxLowerLimit = new JComboBox(itemLimit);
	JComboBox comboBoxUpperLimit = new JComboBox(itemLimit);
	
	String[][] dataHighScores = null;
	String[] columnNameHighScores ={"ID", "Player Name", "Scores", "Total Time"};
	JTable tbHighScores = new JTable(dataHighScores, columnNameHighScores);
	
	JLabel lbType = new JLabel();
	JLabel lbLower = new JLabel();
	JLabel lbUpper = new JLabel();
	JLabel lbTotalPlayer = new JLabel();
	JLabel lbHighestScore = new JLabel();
	JLabel lbLowestScore = new JLabel();
	
	ArrayList<HighScoresModel> listHighScores = new ArrayList<HighScoresModel>();
	public PanelHighScores() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.white);
		initComponent();
	}
	private void initComponent() {
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnResultPlay.setPreferredSize(new Dimension(800, 100));
		pnResultPlay.setBorder(BorderFactory.createTitledBorder("Result"));
		pnResultPlay.setBackground(Color.white);
		pnResultPlay.setLayout(new GridBagLayout());
		GridBagConstraints constraintsResult = new GridBagConstraints();
		constraintsResult.gridx = 0;
		constraintsResult.gridy = 0;
		constraintsResult.gridwidth = 1;
		constraintsResult.insets = new Insets(0, 0, 0, 0);
		lbTotalPlayer.setPreferredSize(new Dimension(500, 20));
		lbTotalPlayer.setFont(new Font("Arial", 0, 12));
		lbTotalPlayer.setForeground(Color.blue);
		pnResultPlay.add(lbTotalPlayer,constraintsResult);
		
		constraintsResult.gridx = 0;
		constraintsResult.gridy = 1;
		constraintsResult.gridwidth = 1;
		constraintsResult.insets = new Insets(0, 0, 0, 0);
		lbLowestScore.setPreferredSize(new Dimension(500, 20));
		lbLowestScore.setFont(new Font("Arial", 0, 12));
		lbLowestScore.setForeground(Color.blue);
		pnResultPlay.add(lbLowestScore,constraintsResult);
		
		constraintsResult.gridx = 0;
		constraintsResult.gridy = 2;
		constraintsResult.gridwidth = 1;
		constraintsResult.insets = new Insets(0, 0, 0, 0);
		lbHighestScore.setPreferredSize(new Dimension(500, 20));
		lbHighestScore.setFont(new Font("Arial", 0, 12));
		lbHighestScore.setForeground(Color.blue);
		pnResultPlay.add(lbHighestScore,constraintsResult);
		resultPlay();
		this.add(pnResultPlay,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnProcess.setPreferredSize(new Dimension(800, 100));
		pnProcess.setLayout(new GridBagLayout());
		pnProcess.setBorder(BorderFactory.createTitledBorder("Manipulation"));
		pnProcess.setBackground(Color.white);
		
		GridBagConstraints constraintsProcess = new GridBagConstraints();
		constraintsProcess.gridx = 0;
		constraintsProcess.gridy = 0;
		constraintsProcess.gridwidth = 1;
		constraintsProcess.insets = new Insets(0, 0, 0, 0);
		lbType.setText("Type:");
		lbType.setPreferredSize(new Dimension(50, 30));
		pnProcess.add(lbType,constraintsProcess);
		
		constraintsProcess.gridx = 1;
		constraintsProcess.gridy = 0;
		constraintsProcess.gridwidth = 1;
		constraintsProcess.insets = new Insets(0, 0, 0, 10);
		comboBoxType.setPreferredSize(new Dimension(100, 30));
		pnProcess.add(comboBoxType,constraintsProcess);

		constraintsProcess.gridx = 2;
		constraintsProcess.gridy = 0;
		constraintsProcess.gridwidth = 1;
		constraintsProcess.insets = new Insets(0, 0, 0, 0);
		lbLower.setText("Lower Limit:");
		lbLower.setPreferredSize(new Dimension(70, 30));
		pnProcess.add(lbLower,constraintsProcess);
		
		constraintsProcess.gridx = 3;
		constraintsProcess.gridy = 0;
		constraintsProcess.gridwidth = 1;
		constraintsProcess.insets = new Insets(0, 0, 0, 10);
		comboBoxLowerLimit.setPreferredSize(new Dimension(150, 30));
		pnProcess.add(comboBoxLowerLimit,constraintsProcess);

		constraintsProcess.gridx = 4;
		constraintsProcess.gridy = 0;
		constraintsProcess.gridwidth = 1;
		constraintsProcess.insets = new Insets(0, 0, 0, 0);
		lbUpper.setText("Upper Limit:");
		lbUpper.setPreferredSize(new Dimension(70, 30));
		pnProcess.add(lbUpper,constraintsProcess);
		
		constraintsProcess.gridx = 5;
		constraintsProcess.gridy = 0;
		constraintsProcess.gridwidth = 1;
		constraintsProcess.insets = new Insets(0, 0, 0, 0);
		comboBoxUpperLimit.setPreferredSize(new Dimension(150, 30));
		comboBoxUpperLimit.setSelectedIndex(10);
		pnProcess.add(comboBoxUpperLimit,constraintsProcess);
		
		this.add(pnProcess,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		scpHighScores.setPreferredSize(new Dimension(750, 200));
		scpHighScores.setBorder(BorderFactory.createEtchedBorder());
		pnDisplayHighScores.setPreferredSize(new Dimension(800, 230));
		pnDisplayHighScores.setBackground(Color.white);
		pnDisplayHighScores.setLayout(new GridBagLayout());
		pnDisplayHighScores.setBorder(BorderFactory.createTitledBorder("High Score"));
		this.add(pnDisplayHighScores,constraints);
		
		getDataHighScores("4", "0", "15000");
		getTableHighScores();
	}
	public void getDataHighScores(String type, String lowerLimit, String upperLimit) {
		listHighScores = GameDao.getHighScores(type, lowerLimit, upperLimit);
		int row = 0;
		dataHighScores = new String[listHighScores.size()][4];
		Integer i = 0;
		for (HighScoresModel model : listHighScores) {
			i++;
			dataHighScores[row][0] = i.toString();
			dataHighScores[row][1] = model.getPlayerName();
			dataHighScores[row][2] = model.getScores();
			dataHighScores[row][3] = model.getTime();
			row++;
		}
	}
	public void getTableHighScores() {
		tbHighScores = new JTable(dataHighScores,columnNameHighScores);
		tbHighScores.setRowHeight(25);
		scpHighScores.setViewportView(tbHighScores);
		scpHighScores.getViewport().setBackground(Color.white);
		pnDisplayHighScores.add(scpHighScores);
	}
	public void resultPlay() {
		Integer total =GameDao.getTotalPlayer("4")+GameDao.getTotalPlayer("6")-20;
		Integer total4x4 = GameDao.getTotalPlayer("4")-10;
		Integer total6x6 = GameDao.getTotalPlayer("6")-10;
		
		lbTotalPlayer.setText("Total Player: "+total+
		"       Type 4x4: "+total4x4+"     Type 6x6: "+total6x6);
		lbLowestScore.setText("Lowest score:       Type 4x4: "+GameDao.getLowestScore("4")+
		"     Type 6x6: "+GameDao.getLowestScore("6"));
		lbHighestScore.setText("Highest score:      Type 4x4: "+GameDao.getHighestScore("4")+
				"     Type 6x6: "+GameDao.getHighestScore("6"));
	}
}
