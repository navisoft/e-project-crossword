package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDisplayAnswer4x4 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public PanelDisplayAnswer4x4() {
		this.setPreferredSize(new Dimension(280, 280));
		this.setLayout(new GridBagLayout());
		this.initComponent();
	}
	private void initComponent() {
		createTextBox(txt_0_0, 0, 0);
		createTextBox(txt_0_1, 1, 0);
		createTextBox(txt_0_2, 2, 0);
		createTextBox(txt_0_3, 3, 0);

		createTextBox(txt_1_0, 0, 1);
		createTextBox(txt_1_1, 1, 1);
		createTextBox(txt_1_2, 2, 1);
		createTextBox(txt_1_3, 3, 1);

		createTextBox(txt_2_0, 0, 2);
		createTextBox(txt_2_1, 1, 2);
		createTextBox(txt_2_2, 2, 2);
		createTextBox(txt_2_3, 3, 2);

		createTextBox(txt_3_0, 0, 3);
		createTextBox(txt_3_1, 1, 3);
		createTextBox(txt_3_2, 2, 3);
		createTextBox(txt_3_3, 3, 3);
	}
	public void createTextBox(final JTextField _txtField, int _locationX, int _locationY) {
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = _locationX;
		bagConstraints.gridy = _locationY;
		bagConstraints.gridwidth = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		_txtField.setPreferredSize(new Dimension(70,70));
		_txtField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		_txtField.setForeground(Color.blue);
		_txtField.setFont(new Font("Arial", 0, 25));
		_txtField.setEditable(false);
		this.add(_txtField,bagConstraints);
	}
}
