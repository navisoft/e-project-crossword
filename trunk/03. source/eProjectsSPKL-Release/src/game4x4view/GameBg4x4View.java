package game4x4view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.GameDao;

import model.Answer4x4Model;
public class GameBg4x4View extends JPanel{
	private static final long serialVersionUID = 1L;
	public Image img;public int width;public int height;
	
	public JTextField txt_0_0 = new JTextField();public JTextField txt_0_1 = new JTextField();public JTextField txt_0_2 = new JTextField();
	public JTextField txt_0_3 = new JTextField();public JTextField txt_1_0 = new JTextField();public JTextField txt_1_1 = new JTextField();
	public JTextField txt_1_2 = new JTextField();public JTextField txt_1_3 = new JTextField();public JTextField txt_2_0 = new JTextField();
	public JTextField txt_2_1 = new JTextField();public JTextField txt_2_2 = new JTextField();public JTextField txt_2_3 = new JTextField();
	public JTextField txt_3_0 = new JTextField();public JTextField txt_3_1 = new JTextField();public JTextField txt_3_2 = new JTextField();
	public JTextField txt_3_3 = new JTextField();
	
	public JPanel pnAnswers = new JPanel();public JPanel pnQuestion = new JPanel();public JPanel pnButton = new JPanel();
	
	public JTextArea txtAreaRow = new JTextArea();public JTextArea txtAreaColunm = new JTextArea();
	
	public JLabel lbRow = new JLabel();public JLabel lbColunm = new JLabel();public JLabel lbTime = new JLabel();
	
	public JButton btFinish = new JButton();public JButton btNewGame = new JButton();public JButton btMainMenu = new JButton();
	
	public JScrollPane spRow = new JScrollPane();public JScrollPane spColunm = new JScrollPane();
	
	GridBagConstraints bagConstraints = new GridBagConstraints();
	
	public String puzzleID;
	
	public ArrayList<Answer4x4Model> listAnswer4x4;

	public GameBg4x4View(Image _img,int _width,int _height) {
		try {
			this.img = _img;this.width = _width;
			this.height = _height;
			this.setLayout(new GridBagLayout());
			initComponent();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, width, height, null);
		g.setColor(Color.cyan);
		g.drawRoundRect(10, 40, 330, 400, 10, 10);
		g.drawRoundRect(360, 40, 330, 400, 10, 10);
		g.setColor(Color.BLUE);
		g.drawString("Crossword create by SPKL group", 20, 20);
		g.setFont(new Font("Arial", 1, 12));
		g.drawString("Answers", 150, 39);
		g.drawString("Question", 500, 39);
	}
	private void initComponent() {
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(50, 5, 0, 20);
		pnAnswers.setPreferredSize(new Dimension(280,280));pnAnswers.setLayout(new GridBagLayout());
		this.add(pnAnswers,bagConstraints);
		//4 o dau
		createTextBox(txt_0_0, 0, 0);createTextBox(txt_0_1, 1, 0);createTextBox(txt_0_2, 2, 0);createTextBox(txt_0_3, 3, 0);
		//4 o thu 2
		createTextBox(txt_1_0, 0, 1);createTextBox(txt_1_1, 1, 1);createTextBox(txt_1_2, 2, 1);createTextBox(txt_1_3, 3, 1);
		//4 o thu 3
		createTextBox(txt_2_0, 0, 2);createTextBox(txt_2_1, 1, 2);createTextBox(txt_2_2, 2, 2);createTextBox(txt_2_3, 3, 2);
		//4 o tu 4
		createTextBox(txt_3_0, 0, 3);createTextBox(txt_3_1, 1, 3);createTextBox(txt_3_2, 2, 3);createTextBox(txt_3_3, 3, 3);
		
		bagConstraints.gridx = 0;bagConstraints.gridy = 1;bagConstraints.gridwidth = 1;bagConstraints.gridheight = 1;
		bagConstraints.insets = new Insets(10, 5, 0, 20);
		pnButton.setPreferredSize(new Dimension(280, 40));pnButton.setLayout(new GridBagLayout());
		this.add(pnButton,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		btNewGame.setPreferredSize(new Dimension(93, 40));
		btNewGame.setText("New Game");
		pnButton.add(btNewGame,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		btFinish.setPreferredSize(new Dimension(93, 40));
		btFinish.setText("Finish");pnButton.add(btFinish,bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		btMainMenu.setPreferredSize(new Dimension(94, 40));
		btMainMenu.setText("Main Menu");
		btMainMenu.setToolTipText("Main Menu");
		pnButton.add(btMainMenu,bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.gridheight = 2;
		bagConstraints.insets = new Insets(30, 30, 0, 0);
		pnQuestion.setPreferredSize(new Dimension(320,380));
		pnQuestion.setBackground(Color.white);
		pnQuestion.setLayout(new GridBagLayout());
		pnQuestion.setOpaque(isOpaque());
		this.add(pnQuestion,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 1;
		bagConstraints.gridheight = 1;
		bagConstraints.insets = new Insets(0, 0, 10, 0);
		lbRow.setText("Row");
		lbRow.setFont(new Font("Arial", 0, 20));
		lbRow.setForeground(Color.blue);
		pnQuestion.add(lbRow,bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 1;
		bagConstraints.gridheight = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		spRow.setPreferredSize(new Dimension(300, 100));pnQuestion.add(spRow,bagConstraints);
		
		txtAreaRow.setFont(new Font("Arial", 0, 12));txtAreaRow.setForeground(Color.blue);txtAreaRow.setEditable(false);
		spRow.setViewportView(txtAreaRow);
		
		bagConstraints.gridx = 0;bagConstraints.gridy = 2;bagConstraints.gridwidth = 1;bagConstraints.gridheight = 1;
		bagConstraints.insets = new Insets(15, 0, 10, 0);
		lbColunm.setText("Colunm");lbColunm.setFont(new Font("Arial", 0, 20));lbColunm.setForeground(Color.blue);
		pnQuestion.add(lbColunm,bagConstraints);
		
		bagConstraints.gridx = 0;bagConstraints.gridy = 3;bagConstraints.gridwidth = 1;bagConstraints.gridheight = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		spColunm.setPreferredSize(new Dimension(300, 100));pnQuestion.add(spColunm,bagConstraints);
		
		txtAreaColunm.setFont(new Font("Arial", 0, 12));txtAreaColunm.setForeground(Color.blue);txtAreaColunm.setEditable(false);
		spColunm.setViewportView(txtAreaColunm);
		
		bagConstraints.gridx = 0;bagConstraints.gridy = 4;bagConstraints.gridwidth = 1;bagConstraints.gridheight = 1;
		bagConstraints.insets = new Insets(30, 0, 0, 0);
		lbTime.setText("00:00");lbTime.setFont(new Font("Arial", 0, 30));lbTime.setForeground(Color.blue);
		pnQuestion.add(lbTime,bagConstraints);
		randomPuzzleID();
		mapData(puzzleID);
	}
	public void mapData(String puzzleID) {
		listAnswer4x4 = new ArrayList<Answer4x4Model>();
		listAnswer4x4 = GameDao.getData(puzzleID);
		//bon o hang thu nhat
		mapOneData1(txt_0_0, 0, 4);mapOneData2(txt_0_1, 0, 5);mapOneData3(txt_0_2, 0, 6);mapOneData4(txt_0_3, 0, 7);
		//bon o hang thu hai
		mapOneData1(txt_1_0, 1, 4);mapOneData2(txt_1_1, 1, 5);mapOneData3(txt_1_2, 1, 6);mapOneData4(txt_1_3, 1, 7);
		//bon o hang thu ba
		mapOneData1(txt_2_0, 2, 4);mapOneData2(txt_2_1, 2, 5);mapOneData3(txt_2_2, 2, 6);mapOneData4(txt_2_3, 2, 7);
		//bon o hang thu 4
		mapOneData1(txt_3_0, 3, 4);mapOneData2(txt_3_1, 3, 5);mapOneData3(txt_3_2, 3, 6);mapOneData4(txt_3_3, 3, 7);
	}
	public void createTextBox(final JTextField _txtField, int _locationX, int _locationY) {
		bagConstraints.gridx = _locationX;
		bagConstraints.gridy = _locationY;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		_txtField.setPreferredSize(new Dimension(70,70));
		_txtField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		_txtField.setForeground(Color.blue);
		_txtField.setFont(new Font("Arial", 0, 25));
		_txtField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				_txtField.setText("");
			}
			public void keyReleased(KeyEvent arg0) {
				_txtField.setText(_txtField.getText().toLowerCase());
			}
			public void keyPressed(KeyEvent arg0) {}
		});
		pnAnswers.add(_txtField,bagConstraints);
	}
	public String checkLengthAnswer(int _location) {
		Integer length = 0;
		String string;
		String _string ="";
		string = listAnswer4x4.get(_location).getValue1()+","+
		listAnswer4x4.get(_location).getValue2()+","+
		listAnswer4x4.get(_location).getValue3()+","+
		listAnswer4x4.get(_location).getValue4();
		String[] list = string.split(",");
		for(int i = 0; i<list.length;i++){
			if(list[i].equals("*")){
				length = i;
				break;
			}else{
				length = 4;
			}
		}
		_string = length.toString();
		return _string;
	}
	public void mapOneData1(JTextField _textField, final int _locationRow, final int _locationColunm ) {
		if(listAnswer4x4.get(_locationRow).getValue1().equals("*")){
			_textField.setText(listAnswer4x4.get(_locationRow).getValue1());
			_textField.setEditable(false);
		}else{
			_textField.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					txtAreaRow.setText("");
					txtAreaColunm.setText("");
					if(listAnswer4x4.get(_locationRow).getDetail() != null){
						if(listAnswer4x4.get(_locationRow).getDetail().length()>50){
							txtAreaRow.append(
							listAnswer4x4.get(_locationRow).getDetail().substring(0, 50)+"\n"+
							listAnswer4x4.get(_locationRow).getDetail().substring(50, listAnswer4x4.get(_locationRow).getDetail().length())+
							" ("+checkLengthAnswer(_locationRow)+")");
						}else{
							txtAreaRow.append(listAnswer4x4.get(_locationRow).getDetail()+" ("+checkLengthAnswer(_locationRow)+")");
						}
					}
					if(listAnswer4x4.get(_locationColunm).getDetail() != null){
						if(listAnswer4x4.get(_locationColunm).getDetail().length()>50){
							txtAreaColunm.append(
							listAnswer4x4.get(_locationColunm).getDetail().substring(0, 50)+"\n"+
							listAnswer4x4.get(_locationColunm).getDetail().substring(50, listAnswer4x4.get(_locationColunm).getDetail().length())+
							" ("+checkLengthAnswer(_locationColunm)+")");
						}else{
							txtAreaColunm.append(listAnswer4x4.get(_locationColunm).getDetail()+" ("+checkLengthAnswer(_locationColunm)+")");
						}
					}
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {}});
		}
	}
	public void mapOneData2(JTextField _textField, final int _locationRow, final int _locationColunm ) {
		if(listAnswer4x4.get(_locationRow).getValue2().equals("*")){
			_textField.setText(listAnswer4x4.get(_locationRow).getValue2());
			_textField.setEditable(false);
		}else{
			_textField.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					txtAreaRow.setText("");
					txtAreaColunm.setText("");
					if(listAnswer4x4.get(_locationRow).getDetail() != null){
						if(listAnswer4x4.get(_locationRow).getDetail().length()>50){
							txtAreaRow.append(
							listAnswer4x4.get(_locationRow).getDetail().substring(0, 50)+"\n"+
							listAnswer4x4.get(_locationRow).getDetail().substring(50, listAnswer4x4.get(_locationRow).getDetail().length())+
							" ("+checkLengthAnswer(_locationRow)+")");
						}else{
							txtAreaRow.append(listAnswer4x4.get(_locationRow).getDetail()+" ("+checkLengthAnswer(_locationRow)+")");
						}
					}
					if(listAnswer4x4.get(_locationColunm).getDetail() != null){
						if(listAnswer4x4.get(_locationColunm).getDetail().length()>50){
							txtAreaColunm.append(
							listAnswer4x4.get(_locationColunm).getDetail().substring(0, 50)+"\n"+
							listAnswer4x4.get(_locationColunm).getDetail().substring(50, listAnswer4x4.get(_locationColunm).getDetail().length())+
							" ("+checkLengthAnswer(_locationColunm)+")");
						}else{
							txtAreaColunm.append(listAnswer4x4.get(_locationColunm).getDetail()+" ("+checkLengthAnswer(_locationColunm)+")");
						}
					}
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {}
			});
		}
	}
	public void mapOneData3(JTextField _textField, final int _locationRow, final int _locationColunm ) {
		if(listAnswer4x4.get(_locationRow).getValue3().equals("*")){
			_textField.setText(listAnswer4x4.get(_locationRow).getValue3());
			_textField.setEditable(false);
		}else{
			_textField.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					txtAreaRow.setText("");
					txtAreaColunm.setText("");
					if(listAnswer4x4.get(_locationRow).getDetail() != null){
						if(listAnswer4x4.get(_locationRow).getDetail().length()>50){
							txtAreaRow.append(
							listAnswer4x4.get(_locationRow).getDetail().substring(0, 50)+"\n"+
							listAnswer4x4.get(_locationRow).getDetail().substring(50, listAnswer4x4.get(_locationRow).getDetail().length())+
							" ("+checkLengthAnswer(_locationRow)+")");
						}else{
							txtAreaRow.append(listAnswer4x4.get(_locationRow).getDetail()+" ("+checkLengthAnswer(_locationRow)+")");
						}
					}
					if(listAnswer4x4.get(_locationColunm).getDetail() != null){
						if(listAnswer4x4.get(_locationColunm).getDetail().length()>50){
							txtAreaColunm.append(
							listAnswer4x4.get(_locationColunm).getDetail().substring(0, 50)+"\n"+
							listAnswer4x4.get(_locationColunm).getDetail().substring(50, listAnswer4x4.get(_locationColunm).getDetail().length())+
							" ("+checkLengthAnswer(_locationColunm)+")");
						}else{
							txtAreaColunm.append(listAnswer4x4.get(_locationColunm).getDetail()+" ("+checkLengthAnswer(_locationColunm)+")");
						}
					}
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {}
			});
		}
	}
	public void mapOneData4(JTextField _textField, final int _locationRow, final int _locationColunm ) {
		if(listAnswer4x4.get(_locationRow).getValue4().equals("*")){
			_textField.setText(listAnswer4x4.get(_locationRow).getValue4());
			_textField.setEditable(false);
		}else{
			_textField.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					txtAreaRow.setText("");
					txtAreaColunm.setText("");
					if(listAnswer4x4.get(_locationRow).getDetail() != null){
						if(listAnswer4x4.get(_locationRow).getDetail().length()>50){
							txtAreaRow.append(
							listAnswer4x4.get(_locationRow).getDetail().substring(0, 50)+"\n"+
							listAnswer4x4.get(_locationRow).getDetail().substring(50, listAnswer4x4.get(_locationRow).getDetail().length())+
							" ("+checkLengthAnswer(_locationRow)+")");
						}else{
							txtAreaRow.append(listAnswer4x4.get(_locationRow).getDetail()+" ("+checkLengthAnswer(_locationRow)+")");
						}
					}
					if(listAnswer4x4.get(_locationColunm).getDetail() != null){
						if(listAnswer4x4.get(_locationColunm).getDetail().length()>50){
							txtAreaColunm.append(
							listAnswer4x4.get(_locationColunm).getDetail().substring(0, 50)+"\n"+
							listAnswer4x4.get(_locationColunm).getDetail().substring(50, listAnswer4x4.get(_locationColunm).getDetail().length())+
							" ("+checkLengthAnswer(_locationColunm)+")");
						}else{
							txtAreaColunm.append(listAnswer4x4.get(_locationColunm).getDetail()+" ("+checkLengthAnswer(_locationColunm)+")");
						}
					}
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {}
			});
		}
	}
	public String randomPuzzleID() {
		puzzleID = GameDao.randomPuzzleID4x4();
		return puzzleID;
	}
}
