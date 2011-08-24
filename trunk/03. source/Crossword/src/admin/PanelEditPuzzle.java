package admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import util.DocumentUtil;

import dao.GameDao;

import model.PuzzleModel;


public class PanelEditPuzzle extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel pnSearch = new JPanel();
	JPanel pnDisplay = new JPanel();
	JPanel pnButton = new JPanel();
	
	JTextField txtPuzzleIdEdit = new JTextField();
	JTextField txtPuzzleNameEdit = new JTextField();
	
	String[] itemType = {"4","6"};
	JComboBox comboBoxType = new JComboBox(itemType);
	JButton btEdit = new JButton();
	JButton btDelete = new JButton();
	JButton btUpdate = new JButton();
	
	JScrollPane scpPuzzle = new JScrollPane();
	
	String[][] dataPuzzle = {};
	String[] columnNamePuzzle = {"ID","Name"};
	JTable tbPuzzle = new JTable(dataPuzzle,columnNamePuzzle);
	
	ArrayList<PuzzleModel> lisPuzzle = new ArrayList<PuzzleModel>();
	public PanelEditPuzzle() {
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
		pnSearch.setPreferredSize(new Dimension(800, 100));
		pnSearch.setBackground(Color.white);
		pnSearch.setLayout(new GridBagLayout());
		pnSearch.setBorder(BorderFactory.createTitledBorder("Search"));
		this.add(pnSearch,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		txtPuzzleIdEdit.setFont(new Font("Arial", 0, 12));
		txtPuzzleIdEdit.setPreferredSize(new Dimension(300, 45));
		txtPuzzleIdEdit.setDocument(DocumentUtil.getPlainDocument(9, "[0-9]+") );
		txtPuzzleIdEdit.setBorder(BorderFactory.createTitledBorder("Puzzle ID"));
		pnSearch.add(txtPuzzleIdEdit);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		txtPuzzleNameEdit.setFont(new Font("Arial", 0, 12));
		txtPuzzleNameEdit.setPreferredSize(new Dimension(300, 45));
		txtPuzzleNameEdit.setBorder(BorderFactory.createTitledBorder("Puzzle Name"));
		pnSearch.add(txtPuzzleNameEdit);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(5, 0, 0, 0);
		comboBoxType.setPreferredSize(new Dimension(150, 35));
		pnSearch.add(comboBoxType,constraints);
		
		//Pn Display
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		scpPuzzle.setPreferredSize(new Dimension(750, 200));
		scpPuzzle.setBorder(BorderFactory.createEtchedBorder());
		pnDisplay.setPreferredSize(new Dimension(800, 230));
		pnDisplay.setBackground(Color.white);
		pnDisplay.setLayout(new GridBagLayout());
		pnDisplay.setBorder(BorderFactory.createTitledBorder("Display"));
		this.add(pnDisplay,constraints);
		
		loadData("", "", "4");
		createTablePuzzle();
		
		//Pnbutton
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		pnButton.setPreferredSize(new Dimension(800, 100));
		pnButton.setBorder(BorderFactory.createTitledBorder("Choose"));
		pnButton.setBackground(Color.white);
		pnButton.setLayout(new GridBagLayout());
		this.add(pnButton,constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		btEdit.setFont(new Font("Arial", 0, 12));
		btEdit.setText("Edit");
		btEdit.setIcon(new ImageIcon("src/view/images/edit_puzzle.png"));
		btEdit.setPreferredSize(new Dimension(150, 40));
		pnButton.add(btEdit);

		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		btDelete.setFont(new Font("Arial", 0, 12));
		btDelete.setText("Delete");
		btDelete.setIcon(new ImageIcon("src/view/images/delete.png"));
		btDelete.setPreferredSize(new Dimension(150, 40));
		pnButton.add(btDelete);

		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		btUpdate.setFont(new Font("Arial", 0, 12));
		btUpdate.setText("Update");
		btUpdate.setIcon(new ImageIcon("src/view/images/update.png"));
		btUpdate.setPreferredSize(new Dimension(150, 40));
		pnButton.add(btUpdate);
	}
	void createTablePuzzle() {
		if(dataPuzzle!=null){
			tbPuzzle = new JTable(dataPuzzle,columnNamePuzzle);
			scpPuzzle.setViewportView(tbPuzzle);
			pnDisplay.add(scpPuzzle);
		}else{
			String[][] data = {{"NO", "NO"}};
			tbPuzzle = new JTable(data,columnNamePuzzle);
			tbPuzzle.setEnabled(false);
			scpPuzzle.setViewportView(tbPuzzle);
			pnDisplay.add(scpPuzzle);
		}
	}
	public void loadData(String puzzleID, String puzzleName, String type) {
		lisPuzzle = GameDao.searchPuzzle(puzzleID, puzzleName, type);
		int row = 0;
		if(lisPuzzle.size()!=0){
			dataPuzzle = new String[lisPuzzle.size()][2];
			for (PuzzleModel model : lisPuzzle) {
				dataPuzzle[row][0] = model.getPuzzleID();
				dataPuzzle[row][1] = model.getPuzzleName();
				row++;
			}
		}else{
			dataPuzzle = null;
		}
	}  
}
