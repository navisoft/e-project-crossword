package admin;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Answer4x4Model;
import model.Answer6x6Model;
import dao.AdminDao;
import dao.GameDao;
import thread.CheckEmpty4x4;
import thread.CheckEmpty6x6;
import thread.TimeSystem;
import util.StringUtil;
import view.AboutView;
import view.GameMainView;
import view.LoginForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ManageGameView extends JFrame {
	public static final long serialVersionUID = 1L;
	public JPanel pnMain = null;
	public JTabbedPane tpMain = null;
	public JPanel pnHighScores = null;
	public JLabel lbManageGame = null;
	
	public PanelCreatePuzzle4x4	panelCreatePuzzle4x4	= 	new PanelCreatePuzzle4x4();
	public PanelCreatePuzzle6x6	panelCreatePuzzle6x6	= 	new PanelCreatePuzzle6x6();
	public PanelEditPuzzle		panelEditPuzzle			= 	new PanelEditPuzzle();
	public PanelAccountSetting	panelAccountSetting		=	new PanelAccountSetting();
	public PanelHighScores		panelHighScores			= 	new PanelHighScores();
	
	public AboutView aboutView = new AboutView();
	public JMenuBar menuBar = new JMenuBar();
	public JMenu menuSystem = new JMenu();
	public JMenuItem menuFileExit = new JMenuItem();
	public JMenuItem menuSysMainMenu = new JMenuItem();
	
	public JMenu menuHelp = new JMenu();
	public JMenuItem menuHelpHelp = new JMenuItem();
	public JMenuItem menuHelpAbout = new JMenuItem();
	
	public ArrayList<Answer4x4Model> listAnswer4x4 = new ArrayList<Answer4x4Model>();
	public ArrayList<Answer6x6Model> listAnswer6x6 = new ArrayList<Answer6x6Model>();
	
	String puzzleIDEdit;
	String puzzleName;
	String typeEdit;
	public JPanel pnHome;
	
	public JLabel lbTime = new JLabel();
	
	String username;
	
	public ManageGameView(String user) {
		this.username = user;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setSize(1000, 650);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-1000)/2, (screenSize.height-650)/2);
		this.setTitle("Manage Game");
    	ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/images/administrator.png"));
        Image img = image.getImage();
        this.setIconImage(img);
		this.setResizable(false);
		initComponent();
	}
	private void initComponent() {
		menuSystem.setText("System");
		menuSystem.setPreferredSize(new Dimension(100, 20));
		menuSystem.setIcon(new ImageIcon(getClass().getResource("/images/system.png")));
		
		menuSysMainMenu.setText("Main Menu");
		menuSysMainMenu.setIcon(new ImageIcon(getClass().getResource("/images/mainmenu20.png")));
		menuSystem.add(menuSysMainMenu);
		//Return to Main menu
		menuSysMainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new GameMainView().setVisible(true);
				aboutView.dispose();
				dispose();
			}
		});
		menuSystem.addSeparator();
		menuFileExit.setText("Exit");
		menuFileExit.setIcon(new ImageIcon(getClass().getResource("/images/quit20.png")));
		//Exit manage form to return to login form
		menuFileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure exit program?");
				if(result == 0){
					new LoginForm("no").setVisible(true);
					aboutView.dispose();
					dispose();
				}
			}
		});
		menuSystem.add(menuFileExit);
		
		menuBar.add(menuSystem);
		
		menuHelp.setText("Help");
		menuHelp.setPreferredSize(new Dimension(100, 20));
		menuHelp.setIcon(new ImageIcon(getClass().getResource("/images/help_admin.png")));
		
		menuHelpHelp.setText("Help Content");
		menuHelpHelp.setIcon(new ImageIcon(getClass().getResource("/images/help_admin.png")));
		menuHelp.add(menuHelpHelp);
		//Open help file
		menuHelpHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
		            Desktop.getDesktop().open(new File("help/help.chm"));
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
			}
		});
		menuHelp.addSeparator();
		menuHelpAbout.setText("About Crossword");
		menuHelpAbout.setIcon(new ImageIcon(getClass().getResource("/images/about.png")));
		menuHelpAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				aboutView.setVisible(true);
			}
		});
		menuHelp.add(menuHelpAbout);
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				aboutView.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		menuBar.add(menuHelp);
		this.setJMenuBar(menuBar);
		
		pnMain = new JPanel();
		pnMain.setLayout(new GridBagLayout());
		pnMain.setPreferredSize(new Dimension(1000, 560));
		pnMain.setBackground(new Color(30, 69, 70));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		pnHome = new JPanel();
		pnHome.setPreferredSize(new Dimension(900, 60));
		pnHome.setBackground(new Color(30, 69, 70));
		pnHome.setLayout(new BorderLayout());
		pnMain.add(pnHome, constraints);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);

		lbManageGame = new JLabel(new ImageIcon(getClass().getResource("/images/welcome.png")));
		lbManageGame.setText("Welcome "+username);
		lbManageGame.setForeground(Color.white);
		lbManageGame.setFont(new Font("Arial", NORMAL, 20));
		pnHome.add(lbManageGame,BorderLayout.NORTH);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 50);
		
		lbTime.setPreferredSize(new Dimension(100, 30));
		TimeSystem timeSystem = new TimeSystem(lbTime);
		lbTime.setForeground(Color.BLUE);
		lbTime.setFont(new Font("Arial", 0, 15));
		Thread time = new Thread(timeSystem);
		time.start();
		pnHome.add(lbTime, BorderLayout.SOUTH);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10, 0, 0, 0);
		
		tpMain = new JTabbedPane();
		tpMain.setPreferredSize(new Dimension(980, 520));
		tpMain.setTabPlacement(JTabbedPane.TOP);
		tpMain.addTab("Generate Puzzle 4x4",new ImageIcon(getClass().getResource("/images/generate.png")),panelCreatePuzzle4x4);
		/*-------------------------------------------------------------------------------*/
		//Code for panelCreatePuzzle4x4
		/*-------------------------------------------------------------------------------*/
		CheckEmpty4x4 empty4x4 = new CheckEmpty4x4(panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_0, 
				panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_2, 
				panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_3, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_0, 
				panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_2, 
				panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_3, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_0, 
				panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_2, 
				panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_3, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_0, 
				panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_2, 
				panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_3, panelCreatePuzzle4x4.btSavePuzzle, true);
		Thread threadEmpty4x4 = new Thread(empty4x4);
		threadEmpty4x4.start();
		//Create a puzzle
		panelCreatePuzzle4x4.btSavePuzzle.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panelCreatePuzzle4x4.btSavePuzzle.getToolTipText().equals("Save")){
					String puzzleName = panelCreatePuzzle4x4.txtPuzzleName.getText().trim();
					if(puzzleName.equals("")){
						JOptionPane.showMessageDialog(null, "Puzzle name not be empty. Try again!");
					}else{
						String puzzleID = GameDao.insertPuzzle(puzzleName);
						if(
							insertDataPuzzle4x4(panelCreatePuzzle4x4.txtQuestion1.getText().trim(), puzzleID, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_0.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_1.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_2.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_3.getText())&&
							insertDataPuzzle4x4(panelCreatePuzzle4x4.txtQuestion2.getText().trim(), puzzleID, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_0.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_1.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_2.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_3.getText())&&
							insertDataPuzzle4x4(panelCreatePuzzle4x4.txtQuestion3.getText().trim(), puzzleID, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_0.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_1.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_2.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_3.getText())&&
							insertDataPuzzle4x4(panelCreatePuzzle4x4.txtQuestion4.getText().trim(), puzzleID, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_0.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_1.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_2.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_3.getText())&&
							insertDataPuzzle4x4(panelCreatePuzzle4x4.txtQuestion5.getText().trim(), puzzleID, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_0.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_0.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_0.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_0.getText())&&
							insertDataPuzzle4x4(panelCreatePuzzle4x4.txtQuestion6.getText().trim(), puzzleID, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_1.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_1.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_1.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_1.getText())	&&
							insertDataPuzzle4x4(panelCreatePuzzle4x4.txtQuestion7.getText().trim(), puzzleID, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_2.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_2.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_2.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_2.getText())	&&
							insertDataPuzzle4x4(panelCreatePuzzle4x4.txtQuestion8.getText().trim(), puzzleID, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_3.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_3.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_3.getText(), 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_3.getText())									
						){
							JOptionPane.showMessageDialog(null, "Save puzzle successfully!");
						}
					}
				}else{
					//Update data puzzle
					if(panelCreatePuzzle4x4.txtPuzzleName.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Puzzle not be empty. Try again!");
					}else{
						boolean result = GameDao.updatePuzzleTable(puzzleIDEdit, panelCreatePuzzle4x4.txtPuzzleName.getText());
						if(result){
							setData4x4(0, panelCreatePuzzle4x4.txtQuestion1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_0,panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_1, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_2, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_3);
							setData4x4(1, panelCreatePuzzle4x4.txtQuestion2, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_0,panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_1, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_2, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_3);
							setData4x4(2, panelCreatePuzzle4x4.txtQuestion3, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_0,panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_1, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_2, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_3);
							setData4x4(3, panelCreatePuzzle4x4.txtQuestion4, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_0,panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_1, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_2, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_3);

							setData4x4(4, panelCreatePuzzle4x4.txtQuestion5, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_0,panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_0, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_0, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_0);
							setData4x4(5, panelCreatePuzzle4x4.txtQuestion6, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_1,panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_1, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_1);
							setData4x4(6, panelCreatePuzzle4x4.txtQuestion7, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_2,panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_2, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_2, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_2);
							setData4x4(7, panelCreatePuzzle4x4.txtQuestion8, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_3,panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_3, 
									panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_3, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_3);
							int countResult = 0;
							for(Answer4x4Model model: listAnswer4x4){
								countResult ++;
								GameDao.updateAnswerAndQuestion4x4(model.getQuestionID(), model.getDetail(), model.getValue1(), model.getValue2(), model.getValue3(), model.getValue4());
							}
							if(countResult == 8){
								JOptionPane.showMessageDialog(null, "Update successfully!");
								panelCreatePuzzle4x4.btSavePuzzle.setToolTipText("Save");
								panelEditPuzzle.loadData("", "", "4");
								panelEditPuzzle.createTablePuzzle();
								tpMain.setSelectedIndex(2);
								tpMain.setTitleAt(0, "Generate puzzle 4x4");
								tpMain.setIconAt(0, new ImageIcon(getClass().getResource("/images/generate.png")));
								emptyTxtBox4x4();
							}
						}else{
							JOptionPane.showMessageDialog( null, "Update fail!");
						}
					}
				}
			}
		});
		//Clear all data on form
		panelCreatePuzzle4x4.btEmpty.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				emptyTxtBox4x4();
			}
		});
		//Create new puzzle
		panelCreatePuzzle4x4.btNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				emptyTxtBox4x4();
				tpMain.setTitleAt(0, "Generate Puzzle 4x4");
				tpMain.setIconAt(0, new ImageIcon(getClass().getResource("/images/generate.png")));
				panelCreatePuzzle4x4.btSavePuzzle.setToolTipText("Save");
			}
		});
		/*-------------------------------------------------------------------------------*/
		//#END:Code for panelCreatePuzzle4x4
		/*-------------------------------------------------------------------------------*/
		tpMain.addTab("Generate Puzzle 6x6",new ImageIcon(getClass().getResource("/images/generate.png")),panelCreatePuzzle6x6);//Add panelCreatePuzzle6x6 into tab panel
		/*-------------------------------------------------------------------------------*/
		//Code for panelCreatePuzzle6x6
		/*-------------------------------------------------------------------------------*/
		CheckEmpty6x6 empty6x6 = new CheckEmpty6x6(
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_1, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_3, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_5, 
				
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_1, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_3, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_5,

				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_1, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_3, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_5,

				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_1, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_3, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_5,

				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_1, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_3, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_5,

				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_1, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_3, 
				panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_5,
				panelCreatePuzzle6x6.btSavePuzzle, true);
		Thread threadEmpty6x6 = new Thread(empty6x6);
		threadEmpty6x6.start();
		//Create puzzle
		panelCreatePuzzle6x6.btSavePuzzle.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panelCreatePuzzle6x6.btSavePuzzle.getToolTipText().equals("Save")){
					String puzzleName = panelCreatePuzzle6x6.txtPuzzleName.getText().trim();
					if(puzzleName.equals("")){
						JOptionPane.showMessageDialog(null, "Puzzle name not be empty. Try again!");
					}else{
						String puzzleID = GameDao.insertPuzzle(puzzleName);
						if(
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion1.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_5.getText())&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion2.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_5.getText())&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion3.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_2.getText(),  
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_4.getText(),
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_5.getText())&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion4.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_5.getText())&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion4.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_5.getText())&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion4.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_2.getText(), 										panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_5.getText())&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion5.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_0.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_0.getText())&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion6.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_1.getText(),
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_1.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_1.getText())	&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion7.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_2.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_2.getText())	&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion8.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_3.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_3.getText())	&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion8.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_4.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_4.getText())	&&
							insertDataPuzzle6x6(panelCreatePuzzle6x6.txtQuestion8.getText().trim(), puzzleID, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_5.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_5.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_5.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_5.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_5.getText(), 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_5.getText())							
						){
							JOptionPane.showMessageDialog(null, "Save puzzle successfully!");
						}
					}
				}else{
					//Update data puzzle
					if(panelCreatePuzzle6x6.txtPuzzleName.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Puzzle not be empty. Try again!");
					}else{
						boolean result = GameDao.updatePuzzleTable(puzzleIDEdit, panelCreatePuzzle6x6.txtPuzzleName.getText());
						if(result){
							setData6x6(0, panelCreatePuzzle6x6.txtQuestion1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_1, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_3,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_5);
							setData6x6(1, panelCreatePuzzle6x6.txtQuestion2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_1, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_3,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_5);
							setData6x6(2, panelCreatePuzzle6x6.txtQuestion3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_1, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_3,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_5);
							setData6x6(3, panelCreatePuzzle6x6.txtQuestion4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_1, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_3,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_5);
							setData6x6(4, panelCreatePuzzle6x6.txtQuestion5, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_1, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_3,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_5);
							setData6x6(5, panelCreatePuzzle6x6.txtQuestion6, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_1, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_3,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_5);

							setData6x6(6, panelCreatePuzzle6x6.txtQuestion7, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_0, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_0,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_0);
							setData6x6(7, panelCreatePuzzle6x6.txtQuestion8, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_1,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_1, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_1,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_1);
							setData6x6(8, panelCreatePuzzle6x6.txtQuestion9, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_2,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_2, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_2,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_2, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_2);
							setData6x6(9, panelCreatePuzzle6x6.txtQuestion10, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_3,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_3, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_3,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_3);
							setData6x6(10, panelCreatePuzzle6x6.txtQuestion11, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_4,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_4, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_4,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_4);
							setData6x6(11, panelCreatePuzzle6x6.txtQuestion12, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_5,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_5, 
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_5, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_5,
									panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_5, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_5);
							int countResult = 0;
							for(Answer6x6Model model: listAnswer6x6){
								countResult ++;
								GameDao.updateAnswerAndQuestion6x6(model.getQuestionID(), model.getDetail(), model.getValue1(), model.getValue2(), model.getValue3(), model.getValue4(), model.getValue5(), model.getValue6());
							}
							if(countResult == 12){
								JOptionPane.showMessageDialog(null, "Update successfully!");
								panelCreatePuzzle6x6.btSavePuzzle.setToolTipText("Save");
								panelEditPuzzle.loadData("", "", "6");
								panelEditPuzzle.createTablePuzzle();
								tpMain.setSelectedIndex(2);
								tpMain.setTitleAt(1, "Generate puzzle 6x6");
								tpMain.setIconAt(1, new ImageIcon(getClass().getResource("/images/generate.png")));
								emptyTxtBox6x6();
							}
						}else{
							JOptionPane.showMessageDialog( null, "Update fail!");
						}
					}
				}
			}
		});
		//Clear all data on form
		panelCreatePuzzle6x6.btEmpty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				emptyTxtBox6x6();
			}
		});
		//Create new puzzle
		panelCreatePuzzle6x6.btNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				emptyTxtBox4x4();
				tpMain.setTitleAt(1, "Generate Puzzle 6x6");
				tpMain.setIconAt(1, new ImageIcon(getClass().getResource("/images/generate.png")));
				panelCreatePuzzle6x6.btSavePuzzle.setToolTipText("Save");
			}
		});
		/*-------------------------------------------------------------------------------*/
		//#END Code for panelCreatePuzzle6x6
		/*-------------------------------------------------------------------------------*/
		tpMain.addTab("Edit Puzzle",new ImageIcon(getClass().getResource("/images/edit_puzzle.png")),panelEditPuzzle);//Add panelEditPuzzle into tab panel
		/*-------------------------------------------------------------------------------*/
		//Code for panelEditPuzzle
		/*-------------------------------------------------------------------------------*/
		//Load data puzzle with type game, puzzle ID, puzzle Name
		panelEditPuzzle.comboBoxType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelEditPuzzle.loadData(panelEditPuzzle.txtPuzzleIdEdit.getText(), panelEditPuzzle.txtPuzzleNameEdit.getText(), (String)panelEditPuzzle.comboBoxType.getSelectedItem());
				panelEditPuzzle.createTablePuzzle();
			}
		});
		panelEditPuzzle.txtPuzzleIdEdit.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				panelEditPuzzle.loadData(panelEditPuzzle.txtPuzzleIdEdit.getText(), panelEditPuzzle.txtPuzzleNameEdit.getText(), (String)panelEditPuzzle.comboBoxType.getSelectedItem());
				panelEditPuzzle.createTablePuzzle();
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		panelEditPuzzle.txtPuzzleNameEdit.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				panelEditPuzzle.loadData(panelEditPuzzle.txtPuzzleIdEdit.getText(), panelEditPuzzle.txtPuzzleNameEdit.getText(), (String)panelEditPuzzle.comboBoxType.getSelectedItem());
				panelEditPuzzle.createTablePuzzle();
			}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		//Edit a puzzle
		panelEditPuzzle.btEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					puzzleIDEdit = panelEditPuzzle.tbPuzzle.getValueAt(panelEditPuzzle.tbPuzzle.getSelectedRow(), 0).toString();
					puzzleName =panelEditPuzzle.tbPuzzle.getValueAt(panelEditPuzzle.tbPuzzle.getSelectedRow(), 1).toString();
					typeEdit = (String)panelEditPuzzle.comboBoxType.getSelectedItem();
					if(typeEdit.equals("4")){
						tpMain.setTitleAt(0, "Edit puzzle 4 x 4");
						tpMain.setIconAt(0, new ImageIcon(getClass().getResource("/images/edit_puzzle.png")));
						tpMain.setSelectedIndex(0);
						panelCreatePuzzle4x4.btSavePuzzle.setToolTipText("Update");
						panelCreatePuzzle4x4.txtPuzzleName.setText(puzzleName);
						listAnswer4x4 = GameDao.getData4x4(puzzleIDEdit);
						mapData4x4(0, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_0, 
						panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_2, 
						panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_3);
						
						mapData4x4(1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_0, 
						panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_2, 
						panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_3);
						
						mapData4x4(2,  panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_0, 
						panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_2, 
						panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_3);
						
						mapData4x4(3,  panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_0, 
						panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_1, panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_2, 
						panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_3);
						
						mapQuestion4x4(0, panelCreatePuzzle4x4.txtQuestion1);
						mapQuestion4x4(1, panelCreatePuzzle4x4.txtQuestion2);
						mapQuestion4x4(2, panelCreatePuzzle4x4.txtQuestion3);
						mapQuestion4x4(3, panelCreatePuzzle4x4.txtQuestion4);
						mapQuestion4x4(4, panelCreatePuzzle4x4.txtQuestion5);
						mapQuestion4x4(5, panelCreatePuzzle4x4.txtQuestion6);
						mapQuestion4x4(6, panelCreatePuzzle4x4.txtQuestion7);
						mapQuestion4x4(7, panelCreatePuzzle4x4.txtQuestion8);
						
					}else if(typeEdit.equals("6")){
						tpMain.setTitleAt(1, "Edit puzzle 6 x 6");
						tpMain.setIconAt(1, new ImageIcon(getClass().getResource("/images/edit_puzzle.png")));
						tpMain.setSelectedIndex(1);
						panelCreatePuzzle6x6.btSavePuzzle.setToolTipText("Update");
						panelCreatePuzzle6x6.txtPuzzleName.setText(puzzleName);
						listAnswer6x6 = GameDao.getData6x6(puzzleIDEdit);
						mapData6x6(0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_2, 
						panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_5 );
						
						mapData6x6(1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_2, 
						panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_5);
						
						mapData6x6(2,  panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_0, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_2, 
						panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_5);
						
						mapData6x6(3,  panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_2, 
						panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_5);

						mapData6x6(4,  panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_2, 
						panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_5);

						mapData6x6(5,  panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_0,panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_1, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_2, 
						panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_3, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_4, panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_5);
						
						mapQuestion6x6(0, panelCreatePuzzle6x6.txtQuestion1);
						mapQuestion6x6(1, panelCreatePuzzle6x6.txtQuestion2);
						mapQuestion6x6(2, panelCreatePuzzle6x6.txtQuestion3);
						mapQuestion6x6(3, panelCreatePuzzle6x6.txtQuestion4);
						mapQuestion6x6(4, panelCreatePuzzle6x6.txtQuestion5);
						mapQuestion6x6(5, panelCreatePuzzle6x6.txtQuestion6);
						mapQuestion6x6(6, panelCreatePuzzle6x6.txtQuestion7);
						mapQuestion6x6(7, panelCreatePuzzle6x6.txtQuestion8);
						mapQuestion6x6(8, panelCreatePuzzle6x6.txtQuestion9);
						mapQuestion6x6(9, panelCreatePuzzle6x6.txtQuestion10);
						mapQuestion6x6(10, panelCreatePuzzle6x6.txtQuestion11);
						mapQuestion6x6(11, panelCreatePuzzle6x6.txtQuestion12);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please choose a puzzle to edit.");
				}
				
			}
		});
		//Delete all data of a puzzle 
		panelEditPuzzle.btDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					puzzleIDEdit = panelEditPuzzle.tbPuzzle.getValueAt(panelEditPuzzle.tbPuzzle.getSelectedRow(), 0).toString();
					typeEdit = (String)panelEditPuzzle.comboBoxType.getSelectedItem();
					if(typeEdit.equals("4")){

						listAnswer4x4 = GameDao.getData4x4(puzzleIDEdit);
						for(Answer4x4Model model: listAnswer4x4){
							GameDao.deleteQuestion(model.getQuestionID());
						}
					}
					if(typeEdit.equals("6")){

						listAnswer6x6 = GameDao.getData6x6(puzzleIDEdit);
						for(Answer6x6Model model: listAnswer6x6){
							GameDao.deleteQuestion(model.getQuestionID());
						}
					}
					boolean result = GameDao.deletePuzzle(puzzleIDEdit, typeEdit);
					if(result){
						panelEditPuzzle.loadData("", "", typeEdit);
						panelEditPuzzle.createTablePuzzle();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please choose a puzzle to delete.");
				}
			}
		});
		//Update puzzle name
		panelEditPuzzle.btUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					puzzleIDEdit = panelEditPuzzle.tbPuzzle.getValueAt(panelEditPuzzle.tbPuzzle.getSelectedRow(), 0).toString();
					puzzleName =panelEditPuzzle.tbPuzzle.getValueAt(panelEditPuzzle.tbPuzzle.getSelectedRow(), 1).toString();
					typeEdit = (String)panelEditPuzzle.comboBoxType.getSelectedItem();
					if(GameDao.updatePuzzleTable(puzzleIDEdit, puzzleName)){
						JOptionPane.showMessageDialog(null, "Update successfully!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please choose a puzzle to update.");
				}
			}
		});
		/*-------------------------------------------------------------------------------*/
		//#END:Code for panelEditPuzzle
		/*-------------------------------------------------------------------------------*/
		tpMain.addTab("Acount Setting",new ImageIcon(getClass().getResource("/images/account_setting.png")),panelAccountSetting);
		/*-------------------------------------------------------------------------------*/
		//Code for panelAccountSetting
		/*-------------------------------------------------------------------------------*/
		panelAccountSetting.btSaveAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				char[] password = panelAccountSetting.txtOldPassword.getPassword();
				String oldPassword = new String(password);
				password = panelAccountSetting.txtNewPassword.getPassword();
				String newPassword = new String(password);
				password = panelAccountSetting.txtConfirmPassword.getPassword();
				String confirmPassword = new String(password);
				if(oldPassword.equals("") || newPassword.equals("") || confirmPassword.equals("")){
					JOptionPane.showMessageDialog(null, "All field not be empty! Try again!");
				}else{
					if(newPassword.length() < 6 || oldPassword.length() < 6){
						JOptionPane.showMessageDialog(null, "Password length must be greater than or equal to 6. Try again!");
					}else{
						boolean result = AdminDao.checkRightPassword(StringUtil.encriptString(username), StringUtil.encriptString(oldPassword));
						if(result){
							if(newPassword.equals(confirmPassword)){
								result = AdminDao.updateAccount(StringUtil.encriptString(newPassword));
								if(result){
									JOptionPane.showMessageDialog(null, "Password successfully changed!");
								}else{
									JOptionPane.showMessageDialog(null, "Password fail changed!");
								}
							}else{
								JOptionPane.showMessageDialog(null, "Confirm password is not same password. Try again!");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Old password not right. Try again!");
						}
					}
				}
			}
		});
		/*-------------------------------------------------------------------------------*/
		//#END:Code for panelAccountSetting
		/*-------------------------------------------------------------------------------*/
		tpMain.addTab("High Scores",new ImageIcon(getClass().getResource("/images/high_edit.png")),panelHighScores);
		/*-------------------------------------------------------------------------------*/
		//Code for panelHighScores
		/*-------------------------------------------------------------------------------*/
		//Display scores with type game
		panelHighScores.comboBoxType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panelHighScores.comboBoxType.getSelectedItem().equals("6")){
					panelHighScores.comboBoxUpperLimit.setSelectedIndex(15);
				}else{
					panelHighScores.comboBoxUpperLimit.setSelectedIndex(10);
				}
				panelHighScores.getDataHighScores((String)panelHighScores.comboBoxType.getSelectedItem(), (String)panelHighScores.comboBoxLowerLimit.getSelectedItem(), (String)panelHighScores.comboBoxUpperLimit.getSelectedItem());
				panelHighScores.getTableHighScores();
			}
		});
		//Display scores with type lower limit
		panelHighScores.comboBoxLowerLimit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelHighScores.getDataHighScores((String)panelHighScores.comboBoxType.getSelectedItem(), (String)panelHighScores.comboBoxLowerLimit.getSelectedItem(), (String)panelHighScores.comboBoxUpperLimit.getSelectedItem());
				panelHighScores.getTableHighScores();
			}
		});
		//Display scores with type upper limit
		panelHighScores.comboBoxUpperLimit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelHighScores.getDataHighScores((String)panelHighScores.comboBoxType.getSelectedItem(), (String)panelHighScores.comboBoxLowerLimit.getSelectedItem(), (String)panelHighScores.comboBoxUpperLimit.getSelectedItem());
				panelHighScores.getTableHighScores();
			}
		});
		//Delete scores
		panelHighScores.itemPopupDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String scoreID = null;
				try {
					scoreID = panelHighScores.tbHighScores.getValueAt(panelHighScores.tbHighScores.getSelectedRow(), 0).toString();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please choose an element to delete.");
				}
				if(GameDao.deleteHighScore(scoreID)){
					panelHighScores.getDataHighScores((String)panelHighScores.comboBoxType.getSelectedItem(),(String)panelHighScores.comboBoxLowerLimit.getSelectedItem(),(String)panelHighScores.comboBoxUpperLimit.getSelectedItem());
					panelHighScores.getTableHighScores();
				}else{
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		/*-------------------------------------------------------------------------------*/
		//#END:Code for panelHighScores
		/*-------------------------------------------------------------------------------*/
		//Reload data on table scores
		tpMain.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(tpMain.getSelectedIndex() == 2){
					panelEditPuzzle.loadData("", "", (String)panelEditPuzzle.comboBoxType.getSelectedItem());
					panelEditPuzzle.createTablePuzzle();
				}
			}
		});
		pnMain.add(tpMain, constraints);
		this.getContentPane().add(pnMain);
	}
	/*-------------------------------------------------------------------------------*/
	//Insert all data for a puzzle
	/*-------------------------------------------------------------------------------*/
	//Insert data into Question table and Answer4x4 table
	public boolean insertDataPuzzle4x4(String detail, String puzzleID, String value1, String value2, String value3, String value4) {
		boolean result = false;
		String questionID_result = GameDao.insertDataQuestions(detail);
		result = GameDao.insertDataAnswer4x4(puzzleID, questionID_result, value1, value2, value3, value4);
		return result;
	}
	//Insert data into Question table and Answer6x6 table
	public boolean insertDataPuzzle6x6(String detail, String puzzleID, String value1, String value2, String value3, String value4, String value5, String value6) {
		boolean result = false;
		String questionID_result = GameDao.insertDataQuestions(detail);
		result = GameDao.insertDataAnswer6x6(puzzleID, questionID_result, value1, value2, value3, value4, value5, value6);
		return result;
	}
	//Map data from list into textfield of puzzle 4 x 4
	public void mapData4x4(int _location, JTextField _txt1, JTextField _txt2, JTextField _txt3, JTextField _txt4) {
		_txt1.setText(listAnswer4x4.get(_location).getValue1());
		_txt2.setText(listAnswer4x4.get(_location).getValue2());
		_txt3.setText(listAnswer4x4.get(_location).getValue3());
		_txt4.setText(listAnswer4x4.get(_location).getValue4());
	}
	//Map data from list into textfield of puzzle 6 x 6
	public void mapData6x6(int _location, JTextField _txt1, JTextField _txt2, JTextField _txt3, JTextField _txt4, JTextField _txt5, JTextField _txt6) {
		_txt1.setText(listAnswer6x6.get(_location).getValue1());
		_txt2.setText(listAnswer6x6.get(_location).getValue2());
		_txt3.setText(listAnswer6x6.get(_location).getValue3());
		_txt4.setText(listAnswer6x6.get(_location).getValue4());
		_txt5.setText(listAnswer6x6.get(_location).getValue5());
		_txt6.setText(listAnswer6x6.get(_location).getValue6());
	}
	//Map data from list into textfield of puzzle 4 x 4
	public void mapQuestion4x4(int _location, JTextField _txtQuestion) {
		_txtQuestion.setText(listAnswer4x4.get(_location).getDetail());
	}
	//Map data from list into textfield of puzzle 6 x 6
	public void mapQuestion6x6(int _location, JTextField _txtQuestion) {
		_txtQuestion.setText(listAnswer6x6.get(_location).getDetail());
	}
	//set data from textfield 4 x 4 into list
	public void setData4x4(int _location, JTextField _txtQuestion, JTextField _txt1, JTextField _txt2, JTextField _txt3, JTextField _txt4) {
		listAnswer4x4.get(_location).setDetail(_txtQuestion.getText());
		listAnswer4x4.get(_location).setValue1(_txt1.getText());
		listAnswer4x4.get(_location).setValue2(_txt2.getText());
		listAnswer4x4.get(_location).setValue3(_txt3.getText());
		listAnswer4x4.get(_location).setValue4(_txt4.getText());
	}
	//set data from textfield 6 x 6 into list
	public void setData6x6(int _location, JTextField _txtQuestion, JTextField _txt1, JTextField _txt2, JTextField _txt3, JTextField _txt4, JTextField _txt5, JTextField _txt6) {
		listAnswer6x6.get(_location).setDetail(_txtQuestion.getText());
		listAnswer6x6.get(_location).setValue1(_txt1.getText());
		listAnswer6x6.get(_location).setValue2(_txt2.getText());
		listAnswer6x6.get(_location).setValue3(_txt3.getText());
		listAnswer6x6.get(_location).setValue4(_txt4.getText());
		listAnswer6x6.get(_location).setValue5(_txt5.getText());
		listAnswer6x6.get(_location).setValue6(_txt6.getText());
	}
	//set text = null for textbox
	public void emptyTxtBox4x4() {
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_0.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_1.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_2.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_0_3.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_0.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_1.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_2.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_1_3.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_0.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_1.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_2.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_2_3.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_0.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_1.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_2.setText("");
		panelCreatePuzzle4x4.panelTxtBox4x4Admin.txt_3_3.setText("");
		panelCreatePuzzle4x4.txtPuzzleName.setText("");
		panelCreatePuzzle4x4.txtQuestion1.setText("");
		panelCreatePuzzle4x4.txtQuestion2.setText("");
		panelCreatePuzzle4x4.txtQuestion3.setText("");
		panelCreatePuzzle4x4.txtQuestion4.setText("");
		panelCreatePuzzle4x4.txtQuestion5.setText("");
		panelCreatePuzzle4x4.txtQuestion6.setText("");
		panelCreatePuzzle4x4.txtQuestion7.setText("");
		panelCreatePuzzle4x4.txtQuestion8.setText("");
	}
	public void emptyTxtBox6x6() {
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_0.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_1.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_2.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_3.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_4.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_0_5.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_0.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_1.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_2.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_3.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_4.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_1_5.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_0.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_1.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_2.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_3.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_4.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_2_5.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_0.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_1.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_2.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_3.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_4.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_3_5.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_0.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_1.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_2.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_3.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_4.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_4_5.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_0.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_1.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_2.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_3.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_4.setText("");
		panelCreatePuzzle6x6.panelTxtBox6x6Admin.txt_5_5.setText("");
		panelCreatePuzzle6x6.txtPuzzleName.setText("");
		panelCreatePuzzle6x6.txtQuestion1.setText("");
		panelCreatePuzzle6x6.txtQuestion2.setText("");
		panelCreatePuzzle6x6.txtQuestion3.setText("");
		panelCreatePuzzle6x6.txtQuestion4.setText("");
		panelCreatePuzzle6x6.txtQuestion5.setText("");
		panelCreatePuzzle6x6.txtQuestion6.setText("");
		panelCreatePuzzle6x6.txtQuestion7.setText("");
		panelCreatePuzzle6x6.txtQuestion8.setText("");
		panelCreatePuzzle6x6.txtQuestion9.setText("");
		panelCreatePuzzle6x6.txtQuestion10.setText("");
		panelCreatePuzzle6x6.txtQuestion11.setText("");
		panelCreatePuzzle6x6.txtQuestion12.setText("");
	}
}  
