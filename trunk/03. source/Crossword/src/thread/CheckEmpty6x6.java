package thread;

import javax.swing.JButton;
import javax.swing.JTextField;
public class CheckEmpty6x6 implements Runnable{
	
	public JTextField txt_0_0;
	public JTextField txt_0_1;
	public JTextField txt_0_2;
	public JTextField txt_0_3;
	public JTextField txt_0_4;
	public JTextField txt_0_5;

	public JTextField txt_1_0;
	public JTextField txt_1_1;
	public JTextField txt_1_2;
	public JTextField txt_1_3;
	public JTextField txt_1_4;
	public JTextField txt_1_5;

	public JTextField txt_2_0;
	public JTextField txt_2_1;
	public JTextField txt_2_2;
	public JTextField txt_2_3;
	public JTextField txt_2_4;
	public JTextField txt_2_5;

	public JTextField txt_3_0;
	public JTextField txt_3_1;
	public JTextField txt_3_2;
	public JTextField txt_3_3;
	public JTextField txt_3_4;
	public JTextField txt_3_5;

	public JTextField txt_4_0;
	public JTextField txt_4_1;
	public JTextField txt_4_2;
	public JTextField txt_4_3;
	public JTextField txt_4_4;
	public JTextField txt_4_5;

	public JTextField txt_5_0;
	public JTextField txt_5_1;
	public JTextField txt_5_2;
	public JTextField txt_5_3;
	public JTextField txt_5_4;
	public JTextField txt_5_5;
	public boolean flag;
	public JButton btFinish;
	
	public CheckEmpty6x6(
			 JTextField txt_0_0,JTextField txt_0_1,JTextField txt_0_2,JTextField txt_0_3,JTextField txt_0_4,JTextField txt_0_5,
		
			 JTextField txt_1_0,JTextField txt_1_1,JTextField txt_1_2,JTextField txt_1_3,JTextField txt_1_4,JTextField txt_1_5,
		
			 JTextField txt_2_0,JTextField txt_2_1,JTextField txt_2_2,JTextField txt_2_3,JTextField txt_2_4,JTextField txt_2_5,
		
			 JTextField txt_3_0,JTextField txt_3_1,JTextField txt_3_2,JTextField txt_3_3,JTextField txt_3_4,JTextField txt_3_5,
		
			 JTextField txt_4_0,JTextField txt_4_1,JTextField txt_4_2,JTextField txt_4_3,JTextField txt_4_4,JTextField txt_4_5,
		
			 JTextField txt_5_0,JTextField txt_5_1,JTextField txt_5_2,JTextField txt_5_3,JTextField txt_5_4,JTextField txt_5_5,

			 JButton btFinish,
			 boolean flag
	){
		this.txt_0_0 = txt_0_0;this.txt_0_1 = txt_0_1;this.txt_0_2 = txt_0_2;this.txt_0_3 = txt_0_3;this.txt_0_4 = txt_0_4;this.txt_0_5 = txt_0_5;
		
		this.txt_1_0 = txt_1_0;this.txt_1_1 = txt_1_1;this.txt_1_2 = txt_1_2;this.txt_1_3 = txt_1_3;this.txt_1_4 = txt_1_4;this.txt_1_5 = txt_1_5;
		
		this.txt_2_0 = txt_2_0;this.txt_2_1 = txt_2_1;this.txt_2_2 = txt_2_2;this.txt_2_3 = txt_2_3;this.txt_2_4 = txt_2_4;this.txt_2_5 = txt_2_5;

		this.txt_3_0 = txt_3_0;this.txt_3_1 = txt_3_1;this.txt_3_2 = txt_3_2;this.txt_3_3 = txt_3_3;this.txt_3_4 = txt_3_4;this.txt_3_5 = txt_3_5;

		this.txt_4_0 = txt_4_0;this.txt_4_1 = txt_4_1;this.txt_4_2 = txt_4_2;this.txt_4_3 = txt_4_3;this.txt_4_4 = txt_4_4;this.txt_4_5 = txt_4_5;
		
		this.txt_5_0 = txt_5_0;this.txt_5_1 = txt_5_1;this.txt_5_2 = txt_5_2;this.txt_5_3 = txt_5_3;this.txt_5_4 = txt_5_4;this.txt_5_5 = txt_5_5;
		
		this.btFinish = btFinish;
		this.flag = flag;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			try {
			if(txt_0_0.getText().equals("") || txt_0_1.getText().equals("") || txt_0_2.getText().equals("") 
			|| txt_0_3.getText().equals("") || txt_0_4.getText().equals("") || txt_0_5.getText().equals("")
			|| txt_1_0.getText().equals("") || txt_1_1.getText().equals("") || txt_1_2.getText().equals("") 
			|| txt_1_3.getText().equals("") || txt_1_4.getText().equals("") || txt_1_5.getText().equals("")
			|| txt_2_0.getText().equals("") || txt_2_1.getText().equals("") || txt_2_2.getText().equals("") 
			|| txt_2_3.getText().equals("")	|| txt_2_4.getText().equals("") || txt_2_5.getText().equals("")
			|| txt_3_0.getText().equals("") || txt_3_1.getText().equals("") || txt_3_2.getText().equals("") 
			|| txt_3_3.getText().equals("")	|| txt_3_4.getText().equals("") || txt_3_5.getText().equals("")
			|| txt_4_0.getText().equals("") || txt_4_1.getText().equals("") || txt_4_2.getText().equals("") 
			|| txt_4_3.getText().equals("")	|| txt_4_4.getText().equals("") || txt_4_5.getText().equals("")
			|| txt_5_0.getText().equals("") || txt_5_1.getText().equals("") || txt_5_2.getText().equals("") 
			|| txt_5_3.getText().equals("")	|| txt_5_4.getText().equals("") || txt_5_5.getText().equals("")
			){
				btFinish.setEnabled(false);
			}else{
				btFinish.setEnabled(true);
			}
			Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
