package admin;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

public class ManageGameView extends JFrame {
	public static final long serialVersionUID = 1L;
	public JPanel jContentPane = null;
	public JTabbedPane tpMain = null;
	public JPanel pnCreatePuzzle4x4 = null;
	public JPanel pnCreatePuzzle6x6 = null;
	public JPanel pnEditPuzzle = null;
	public JPanel pnAcount = null;
	public JPanel pnHighScores = null;
	public JLabel lbManageGame = null;
	
	
	public JTextField txt_0_0 = new JTextField();
	public JTextField txt_0_1 = new JTextField();
	public JTextField txt_0_2 = new JTextField();
	public JTextField txt_0_3 = new JTextField();
	public JTextField txt_1_0 = new JTextField();
	public JTextField txt_1_1 = new JTextField();
	public JTextField txt_1_2 = new JTextField();
	public JTextField txt_1_3 = new JTextField();
	public JTextField txt_2_0 = new JTextField();
	public JTextField txt_2_1 = new JTextField();
	public JTextField txt_2_2 = new JTextField();
	public JTextField txt_2_3 = new JTextField();
	public JTextField txt_3_0 = new JTextField();
	public JTextField txt_3_1 = new JTextField();
	public JTextField txt_3_2 = new JTextField();
	public JTextField txt_3_3 = new JTextField();
	
	public JPanel pnHome;
	public JPanel pnAnswers = new JPanel();
	public JPanel pnQuestion = new JPanel();
	public JPanel pnButton = new JPanel();
	
	public JLabel lbRow = new JLabel();
	public JLabel lbColunm = new JLabel();
	public JLabel lbInputAnswers = new JLabel();
	public JLabel lbInputQuestion = new JLabel();
	
	public JLabel lbAdmin = new JLabel();

	private JTextField txtPuzzleName = new JTextField();
	private JTextField txtQuestion1 = new JTextField();
	private JTextField txtQuestion2 = new JTextField();
	private JTextField txtQuestion3 = new JTextField();
	private JTextField txtQuestion4 = new JTextField();
	private JTextField txtQuestion5 = new JTextField();
	private JTextField txtQuestion6 = new JTextField();
	private JTextField txtQuestion7 = new JTextField();
	private JTextField txtQuestion8 = new JTextField();
	
	//pnEdit
	JScrollPane scpPuzzle = new JScrollPane();
	private JPanel pnSearch = new JPanel();
	private JPanel pnDisplay = new JPanel();
	private JPanel pnButtonEdit = new JPanel();

	
	private JTextField txtPuzzleNameEdit = new JTextField();
	private JTextField txtPuzzleIdEdit = new JTextField();
	
	private JTable tbPuzzle = null;
	private String[][] dataPuzzle={{"1","Puzzle 1"},
								   {"2","Puzzle 2"},
								   {"3","Puzzle 3"},
								   {"4","Puzzle 4"},
								   {"5","Puzzle 5"},
								   {"6","Puzzle 6"},
								   {"7","Puzzle 7"},
								   {"8","Puzzle 8"},
								   {"9","Puzzle 9"},
								   {"10","Puzzle 10"},
								   {"11","Puzzle 11"},
								   {"12","Puzzle 12"},
								   {"13","Puzzle 13"},
								   {"14","Puzzle 14"},
								   {"15","Puzzle 15"}
	};
	private String[] columnNamePuzzle ={"Puzzle ID","Puzzle Name"};
	
	private JButton btEdit = new JButton();
	private JButton btDelete = new JButton();
	private JButton btSearch = new JButton();
	private JButton btUpdate = new JButton();
	//pnEdit
	//PnAccount
	JPanel pnLogin = new JPanel();
	JTextField txtOldPassword = new JTextField();
	JTextField txtNewPassword = new JTextField();
	JTextField txtConfirmPassword = new JTextField();
	private JButton btSaveAccount = new JButton();
	
	//pnHighScore
	JScrollPane scpHighScores = new JScrollPane();
	private JTable tbHighScores = null;
	private String[][] dataHighScores={
			{"1","sonld","20000","2:30"},
			{"2","longnh","20000","2:30"},
			{"3","phucvv","20000","2:30"},
			{"4","kietpa","20000","2:30"},
			{"5","peteo","15000","2:30"},
			{"6","geminus","10000","2:30"},
			{"7","homines","10000","2:30"},
			{"8","start","9000","2:30"},
			{"9","sun","7000","2:30"},
			{"10","shine","5000","2:30"}};
	private String[] columnNameHighScores ={"I/O","Player Name","Score","Time"};
	JPanel pnDisplayHighScores = new JPanel();
	
	public JButton btFinish = new JButton();
	
	String username;
	public ManageGameView(String user) {
		this.username = user;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialize();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initialize() {
		this.setSize(900, 600);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-900)/2, (screenSize.height-600)/2);
		this.setContentPane(getJContentPane());
		this.setTitle("Manage Game");
		this.setResizable(false);
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.setPreferredSize(new Dimension(850, 530));
			jContentPane.setBackground(Color.white);
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			jContentPane.add(getPnHome(), constraints);
			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			jContentPane.add(getTpMain(), constraints);
		}
		return jContentPane;
	}
	public JPanel  getPnHome() {
		if(pnHome == null){
			pnHome = new JPanel();
			pnHome.setPreferredSize(new Dimension(850, 60));
			pnHome.setBackground(Color.white);
			pnHome.setLayout(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			pnHome.add(getLbManageGame(),constraints);

			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(10, 0, 0, 0);
			lbAdmin.setText(username);
			pnHome.add(lbAdmin,constraints);
			
		}
		return pnHome;
		
	}
	private JLabel getLbManageGame(){
		if(lbManageGame == null){
			lbManageGame = new JLabel();
			lbManageGame.setText("Manage Game");
			lbManageGame.setFont(new Font("Arial", NORMAL, 20));
		}
		return lbManageGame;
	}
	private JTabbedPane getTpMain() {
		if (tpMain == null) {
			tpMain = new JTabbedPane();
			tpMain.setPreferredSize(new Dimension(850, 500));
			tpMain.setBorder(BorderFactory.createTitledBorder("Proccess"));
			tpMain.setTabPlacement(JTabbedPane.TOP);
			tpMain.addTab("Generate Puzzle 4x4",new ImageIcon("images/user-info-icon.png"),getCreatePuzzle4x4());
			tpMain.addTab("Generate Puzzle 6x6",new ImageIcon("images/user-info-icon.png"),getCreatePuzzle6x6());
			tpMain.addTab("Edit Puzzle",new ImageIcon("images/Clients-icon.png"),getEditPuzzle());
			tpMain.addTab("Acount Setting",new ImageIcon("images/Clients-icon.png"),getAcountSetting());
			tpMain.addTab("High Scores",new ImageIcon("images/Clients-icon.png"),getHighScores());
		}
		return tpMain;
	}
	private JPanel getCreatePuzzle4x4() {
		if (pnCreatePuzzle4x4 == null) {
			pnCreatePuzzle4x4 = new JPanel();
			pnCreatePuzzle4x4.setLayout(new GridBagLayout());
			pnCreatePuzzle4x4.setPreferredSize(new Dimension(700, 500));
			pnCreatePuzzle4x4.setBackground(Color.white);
			GridBagConstraints bagConstraints = new GridBagConstraints();
			//Day la noi chua cau tra loi
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 0;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(10, 10, 0, 0);
			lbInputAnswers.setText("Input Answers");
			pnCreatePuzzle4x4.add(lbInputAnswers,bagConstraints);

			bagConstraints.gridx = 0;
			bagConstraints.gridy = 1;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(20, 0, 0, 0);
			pnAnswers.setPreferredSize(new Dimension(280, 280));
			pnAnswers.setLayout(new GridBagLayout());
			pnAnswers.setBackground(Color.black);
			pnCreatePuzzle4x4.add(pnAnswers,bagConstraints);
			//Dua cac thanh phan vao pnAnswers
			//4 o dau
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 0;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_0_0.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_0_0,bagConstraints);
			
			bagConstraints.gridx = 1;
			bagConstraints.gridy = 0;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_0_1.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_0_1,bagConstraints);

			bagConstraints.gridx = 2;
			bagConstraints.gridy = 0;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_0_2.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_0_2,bagConstraints);

			bagConstraints.gridx = 3;
			bagConstraints.gridy = 0;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_0_3.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_0_3,bagConstraints);
			
			//4 o thu 2

			bagConstraints.gridx = 0;
			bagConstraints.gridy = 1;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_1_0.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_1_0,bagConstraints);
			
			bagConstraints.gridx = 1;
			bagConstraints.gridy = 1;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_1_1.setPreferredSize(new Dimension(70,70));
			txt_1_1.setFont(new Font("Arial", 0, 15));
			txt_1_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txt_1_1.setText("*");
			pnAnswers.add(txt_1_1,bagConstraints);

			bagConstraints.gridx = 2;
			bagConstraints.gridy = 1;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_1_2.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_1_2,bagConstraints);

			bagConstraints.gridx = 3;
			bagConstraints.gridy = 1;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_1_3.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_1_3,bagConstraints);
			//4 o thu 3
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 2;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_2_0.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_2_0,bagConstraints);
			
			bagConstraints.gridx = 1;
			bagConstraints.gridy = 2;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_2_1.setPreferredSize(new Dimension(70,70));
			txt_2_1.setFont(new Font("Arial", 0, 15));
			txt_2_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			pnAnswers.add(txt_2_1,bagConstraints);

			bagConstraints.gridx = 2;
			bagConstraints.gridy = 2;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_2_2.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_2_2,bagConstraints);

			bagConstraints.gridx = 3;
			bagConstraints.gridy = 2;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_2_3.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_2_3,bagConstraints);
			
			//4 o tu 4
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 3;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_3_0.setPreferredSize(new Dimension(70,70));
			pnAnswers.add(txt_3_0,bagConstraints);
			
			bagConstraints.gridx = 1;
			bagConstraints.gridy = 3;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_3_1.setPreferredSize(new Dimension(70,70));
			txt_3_1.setFont(new Font("Arial", 0, 15));
			txt_3_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txt_3_1.setText("*");
			pnAnswers.add(txt_3_1,bagConstraints);

			bagConstraints.gridx = 2;
			bagConstraints.gridy = 3;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_3_2.setPreferredSize(new Dimension(70,70));
			txt_3_2.setFont(new Font("Arial", 0, 15));
			txt_3_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txt_3_2.setText("*");
			pnAnswers.add(txt_3_2,bagConstraints);

			bagConstraints.gridx = 3;
			bagConstraints.gridy = 3;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txt_3_3.setPreferredSize(new Dimension(70,70));
			txt_3_3.setFont(new Font("Arial", 0, 15));
			txt_3_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			pnAnswers.add(txt_3_3,bagConstraints);
			
			//Day la noi chua cac button

			bagConstraints.gridx = 0;
			bagConstraints.gridy = 2;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			pnButton.setPreferredSize(new Dimension(280, 40));
			pnButton.setBackground(Color.white);
			pnButton.setLayout(new GridBagLayout());
			pnCreatePuzzle4x4.add(pnButton,bagConstraints);
			
			//Dua ca thanh phan vao pnButton
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 0;
			bagConstraints.gridwidth = 1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			btFinish.setPreferredSize(new Dimension(280, 40));
			btFinish.setText("Save Puzzle");
			pnButton.add(btFinish,bagConstraints);
			
			//Day la noi chua cac cau hoi
			bagConstraints.gridx = 1;
			bagConstraints.gridy = 0;
			bagConstraints.gridwidth = 1;
			bagConstraints.gridheight = 3;
			bagConstraints.insets = new Insets(0,50, 0, 0);
			pnQuestion.setPreferredSize(new Dimension(460, 440));
			pnQuestion.setBackground(Color.white);
			pnCreatePuzzle4x4.add(pnQuestion,bagConstraints);
			

			bagConstraints.gridx = 0;
			bagConstraints.gridy = 0;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtPuzzleName.setPreferredSize(new Dimension(450, 44));
			txtPuzzleName.setBorder(BorderFactory.createTitledBorder("Puzzle Name:"));
			pnQuestion.add(txtPuzzleName,bagConstraints);
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 1;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtQuestion1.setPreferredSize(new Dimension(450, 44));
			txtQuestion1.setBorder(BorderFactory.createTitledBorder("Question row 1:"));
			pnQuestion.add(txtQuestion1,bagConstraints);
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 2;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtQuestion2.setPreferredSize(new Dimension(450, 44));
			txtQuestion2.setBorder(BorderFactory.createTitledBorder("Question row 2:"));
			pnQuestion.add(txtQuestion2,bagConstraints);
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 3;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtQuestion3.setPreferredSize(new Dimension(450, 44));
			txtQuestion3.setBorder(BorderFactory.createTitledBorder("Question row 3:"));
			pnQuestion.add(txtQuestion3,bagConstraints);
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 4;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtQuestion4.setPreferredSize(new Dimension(450, 44));
			txtQuestion4.setBorder(BorderFactory.createTitledBorder("Question row 4:"));
			pnQuestion.add(txtQuestion4,bagConstraints);
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 5;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtQuestion5.setPreferredSize(new Dimension(450, 44));
			txtQuestion5.setBorder(BorderFactory.createTitledBorder("Question colunm 1:"));
			pnQuestion.add(txtQuestion5,bagConstraints);
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 6;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtQuestion6.setPreferredSize(new Dimension(450, 44));
			txtQuestion6.setBorder(BorderFactory.createTitledBorder("Question colunm 2:"));
			pnQuestion.add(txtQuestion6,bagConstraints);
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 7;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtQuestion7.setPreferredSize(new Dimension(450, 44));
			txtQuestion7.setBorder(BorderFactory.createTitledBorder("Question colunm 3:"));
			pnQuestion.add(txtQuestion7,bagConstraints);
			
			bagConstraints.gridx = 0;
			bagConstraints.gridy = 8;
			bagConstraints.gridwidth =1;
			bagConstraints.insets = new Insets(0, 0, 0, 0);
			txtQuestion8.setPreferredSize(new Dimension(450, 44));
			txtQuestion8.setBorder(BorderFactory.createTitledBorder("Question colunm 4"));
			pnQuestion.add(txtQuestion8,bagConstraints);
		}
		return pnCreatePuzzle4x4;
	}
	private JPanel getCreatePuzzle6x6() {
		if (pnCreatePuzzle6x6 == null) {
			pnCreatePuzzle6x6 = new JPanel();
			pnCreatePuzzle6x6.setLayout(new GridBagLayout());
			pnCreatePuzzle6x6.setBackground(Color.white);
		}
		return pnCreatePuzzle6x6;
	}
	private JPanel getEditPuzzle() {
		if (pnEditPuzzle == null) {
			pnEditPuzzle = new JPanel();
			pnEditPuzzle.setLayout(new GridBagLayout());
			pnEditPuzzle.setBackground(Color.white);
			
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			pnSearch.setPreferredSize(new Dimension(800, 100));
			pnSearch.setBackground(Color.white);
			pnSearch.setLayout(new GridBagLayout());
			pnSearch.setBorder(BorderFactory.createTitledBorder("Search"));
			pnEditPuzzle.add(pnSearch,constraints);
			
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			txtPuzzleIdEdit.setFont(new Font("Arial", NORMAL, 12));
			txtPuzzleIdEdit.setPreferredSize(new Dimension(300, 45));
			txtPuzzleIdEdit.setBorder(BorderFactory.createTitledBorder("Puzzle ID"));
			pnSearch.add(txtPuzzleIdEdit);
			
			constraints.gridx = 1;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			txtPuzzleNameEdit.setFont(new Font("Arial", NORMAL, 12));
			txtPuzzleNameEdit.setPreferredSize(new Dimension(300, 45));
			txtPuzzleNameEdit.setBorder(BorderFactory.createTitledBorder("Puzzle Name"));
			pnSearch.add(txtPuzzleNameEdit);
			
			constraints.gridx = 2;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(5, 0, 0, 0);
			btSearch.setText("Search");
			btSearch.setPreferredSize(new Dimension(150, 35));
			btSearch.setIcon(new ImageIcon("src/view/images/search.png") );
			pnSearch.add(btSearch,constraints);
			
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
			pnEditPuzzle.add(pnDisplay,constraints);
			
			tbPuzzle = new JTable(dataPuzzle,columnNamePuzzle);
			scpPuzzle.setViewportView(tbPuzzle);
			pnDisplay.add(scpPuzzle);
			
			//Pnbutton
			constraints.gridx = 0;
			constraints.gridy = 2;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			pnButtonEdit.setPreferredSize(new Dimension(800, 100));
			pnButtonEdit.setBorder(BorderFactory.createTitledBorder("Choose"));
			pnButtonEdit.setBackground(Color.white);
			pnButtonEdit.setLayout(new GridBagLayout());
			pnEditPuzzle.add(pnButtonEdit,constraints);
			
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			btEdit.setFont(new Font("Arial", NORMAL, 12));
			btEdit.setText("Edit");
			btEdit.setPreferredSize(new Dimension(150, 40));
			pnButtonEdit.add(btEdit);

			constraints.gridx = 1;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			btDelete.setFont(new Font("Arial", NORMAL, 12));
			btDelete.setText("Delete");
			btDelete.setPreferredSize(new Dimension(150, 40));
			pnButtonEdit.add(btDelete);

			constraints.gridx = 2;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			btUpdate.setFont(new Font("Arial", NORMAL, 12));
			btUpdate.setText("Update");
			btUpdate.setPreferredSize(new Dimension(150, 40));
			pnButtonEdit.add(btUpdate);

			
		}
		return pnEditPuzzle;
	}
	private JPanel getAcountSetting() {
		if (pnAcount == null) {
			pnAcount = new JPanel();
			pnAcount.setLayout(new GridBagLayout());
			pnAcount.setBackground(Color.white);
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth =1;
			constraints.insets = new Insets(0, 0, 0, 0);
			pnLogin.setPreferredSize(new Dimension(400, 400));
			pnLogin.setLayout(new GridBagLayout());
			pnLogin.setBackground(Color.white);
			pnLogin.setBorder(BorderFactory.createTitledBorder("Login Form"));
			pnAcount.add(pnLogin,constraints);

			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth =2;
			constraints.insets = new Insets(10, 0, 0, 0);
			txtOldPassword.setPreferredSize(new Dimension(300, 50));
			txtOldPassword.setBorder(BorderFactory.createTitledBorder("Old Password:"));
			pnLogin.add(txtOldPassword,constraints);

			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth =2;
			constraints.insets = new Insets(10, 0, 0, 0);
			txtNewPassword.setPreferredSize(new Dimension(300, 50));
			txtNewPassword.setBorder(BorderFactory.createTitledBorder("New Password:"));
			pnLogin.add(txtNewPassword,constraints);

			constraints.gridx = 0;
			constraints.gridy = 2;
			constraints.gridwidth =2;
			constraints.insets = new Insets(10, 0, 0, 0);
			txtConfirmPassword.setPreferredSize(new Dimension(300, 50));
			txtConfirmPassword.setBorder(BorderFactory.createTitledBorder("Confirm Password:"));
			pnLogin.add(txtConfirmPassword,constraints);

			constraints.gridx = 0;
			constraints.gridy = 3;
			constraints.gridwidth =2;
			constraints.insets = new Insets(20, 0, 0, 0);
			btSaveAccount.setPreferredSize(new Dimension(200, 40));
			btSaveAccount.setText("Save Account");
			pnLogin.add(btSaveAccount,constraints);
		}
		return pnAcount;
	}
	private JPanel getHighScores() {
		if (pnHighScores == null) {
			pnHighScores = new JPanel();
			pnHighScores.setLayout(new GridBagLayout());
			pnHighScores.setBackground(Color.white);
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth = 1;
			constraints.insets = new Insets(0, 0, 0, 0);
			scpHighScores.setPreferredSize(new Dimension(750, 200));
			scpHighScores.setBorder(BorderFactory.createEtchedBorder());
			pnDisplayHighScores.setPreferredSize(new Dimension(800, 230));
			pnDisplayHighScores.setBackground(Color.white);
			pnDisplayHighScores.setLayout(new GridBagLayout());
			pnDisplayHighScores.setBorder(BorderFactory.createTitledBorder("High Score"));
			pnHighScores.add(pnDisplayHighScores,constraints);
			
			tbHighScores = new JTable(dataHighScores,columnNameHighScores);
			scpHighScores.setViewportView(tbHighScores);
			scpHighScores.getViewport().setBackground(Color.white);
			pnDisplayHighScores.add(scpHighScores);
		}
		return pnHighScores;
	}
}  //  @jve:decl-index=0:visual-constraint="80,77"
