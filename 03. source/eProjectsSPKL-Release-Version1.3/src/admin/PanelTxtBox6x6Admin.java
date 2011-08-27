package admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import util.DocumentUtil;

public class PanelTxtBox6x6Admin extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txt_0_0 = new JTextField();
	public JTextField txt_0_1 = new JTextField();
	public JTextField txt_0_2 = new JTextField();
	public JTextField txt_0_3 = new JTextField();
	public JTextField txt_0_4 = new JTextField();
	public JTextField txt_0_5 = new JTextField();
	
	public JTextField txt_1_0 = new JTextField();
	public JTextField txt_1_1 = new JTextField();
	public JTextField txt_1_2 = new JTextField();
	public JTextField txt_1_3 = new JTextField();
	public JTextField txt_1_4 = new JTextField();
	public JTextField txt_1_5 = new JTextField();

	public JTextField txt_2_0 = new JTextField();
	public JTextField txt_2_1 = new JTextField();
	public JTextField txt_2_2 = new JTextField();
	public JTextField txt_2_3 = new JTextField();
	public JTextField txt_2_4 = new JTextField();
	public JTextField txt_2_5 = new JTextField();
	
	public JTextField txt_3_0 = new JTextField();
	public JTextField txt_3_1 = new JTextField();
	public JTextField txt_3_2 = new JTextField();
	public JTextField txt_3_3 = new JTextField();
	public JTextField txt_3_4 = new JTextField();
	public JTextField txt_3_5 = new JTextField();
	
	public JTextField txt_4_0 = new JTextField();
	public JTextField txt_4_1 = new JTextField();
	public JTextField txt_4_2 = new JTextField();
	public JTextField txt_4_3 = new JTextField();
	public JTextField txt_4_4 = new JTextField();
	public JTextField txt_4_5 = new JTextField();
	
	public JTextField txt_5_0 = new JTextField();
	public JTextField txt_5_1 = new JTextField();
	public JTextField txt_5_2 = new JTextField();
	public JTextField txt_5_3 = new JTextField();
	public JTextField txt_5_4 = new JTextField();
	public JTextField txt_5_5 = new JTextField();
	
	public PanelTxtBox6x6Admin() {
		this.setPreferredSize(new Dimension(390, 390));
		this.setLayout(new GridBagLayout());
		this.initComponent();
	}
	private void initComponent() {
		createTextBox(txt_0_0, 0, 0);
		createTextBox(txt_0_1, 1, 0);
		createTextBox(txt_0_2, 2, 0);
		createTextBox(txt_0_3, 3, 0);
		createTextBox(txt_0_4, 4, 0);
		createTextBox(txt_0_5, 5, 0);

		createTextBox(txt_1_0, 0, 1);
		createTextBox(txt_1_1, 1, 1);
		createTextBox(txt_1_2, 2, 1);
		createTextBox(txt_1_3, 3, 1);
		createTextBox(txt_1_4, 4, 1);
		createTextBox(txt_1_5, 5, 1);

		createTextBox(txt_2_0, 0, 2);
		createTextBox(txt_2_1, 1, 2);
		createTextBox(txt_2_2, 2, 2);
		createTextBox(txt_2_3, 3, 2);
		createTextBox(txt_2_4, 4, 2);
		createTextBox(txt_2_5, 5, 2);

		createTextBox(txt_3_0, 0, 3);
		createTextBox(txt_3_1, 1, 3);
		createTextBox(txt_3_2, 2, 3);
		createTextBox(txt_3_3, 3, 3);
		createTextBox(txt_3_4, 4, 3);
		createTextBox(txt_3_5, 5, 3);

		createTextBox(txt_4_0, 0, 4);
		createTextBox(txt_4_1, 1, 4);
		createTextBox(txt_4_2, 2, 4);
		createTextBox(txt_4_3, 3, 4);
		createTextBox(txt_4_4, 4, 4);
		createTextBox(txt_4_5, 5, 4);

		createTextBox(txt_5_0, 0, 5);
		createTextBox(txt_5_1, 1, 5);
		createTextBox(txt_5_2, 2, 5);
		createTextBox(txt_5_3, 3, 5);
		createTextBox(txt_5_4, 4, 5);
		createTextBox(txt_5_5, 5, 5);
	}
	//Create textfield
	public void createTextBox(final JTextField _txtField, int _locationX, int _locationY) {
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = _locationX;
		bagConstraints.gridy = _locationY;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		_txtField.setPreferredSize(new Dimension(65,65));
		_txtField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		_txtField.setForeground(Color.blue);
		_txtField.setDocument(DocumentUtil.getPlainDocument(1, "[a-z A-Z ' *]"));
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
		this.add(_txtField,bagConstraints);
	}
}
