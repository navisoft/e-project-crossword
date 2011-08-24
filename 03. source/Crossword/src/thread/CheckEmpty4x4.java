package thread;

import javax.swing.JButton;
import javax.swing.JTextField;
public class CheckEmpty4x4 implements Runnable{
	
	public JTextField txt_0_0;
	public JTextField txt_0_1;
	public JTextField txt_0_2;
	public JTextField txt_0_3;

	public JTextField txt_1_0;
	public JTextField txt_1_1;
	public JTextField txt_1_2;
	public JTextField txt_1_3;

	public JTextField txt_2_0;
	public JTextField txt_2_1;
	public JTextField txt_2_2;
	public JTextField txt_2_3;

	public JTextField txt_3_0;
	public JTextField txt_3_1;
	public JTextField txt_3_2;
	public JTextField txt_3_3;
	public boolean flag;
	public JButton btFinish;
	
	public CheckEmpty4x4(
			 JTextField txt_0_0,
			 JTextField txt_0_1,
			 JTextField txt_0_2,
			 JTextField txt_0_3,
		
			 JTextField txt_1_0,
			 JTextField txt_1_1,
			 JTextField txt_1_2,
			 JTextField txt_1_3,
		
			 JTextField txt_2_0,
			 JTextField txt_2_1,
			 JTextField txt_2_2,
			 JTextField txt_2_3,
		
			 JTextField txt_3_0,
			 JTextField txt_3_1,
			 JTextField txt_3_2,
			 JTextField txt_3_3,
			 
			 JButton btFinish,
			 boolean flag
	){
		this.txt_0_0 = txt_0_0;
		this.txt_0_1 = txt_0_1;
		this.txt_0_2 = txt_0_2;
		this.txt_0_3 = txt_0_3;
		
		this.txt_1_0 = txt_1_0;
		this.txt_1_1 = txt_1_1;
		this.txt_1_2 = txt_1_2;
		this.txt_1_3 = txt_1_3;
		
		this.txt_2_0 = txt_2_0;
		this.txt_2_1 = txt_2_1;
		this.txt_2_2 = txt_2_2;
		this.txt_2_3 = txt_2_3;

		this.txt_3_0 = txt_3_0;
		this.txt_3_1 = txt_3_1;
		this.txt_3_2 = txt_3_2;
		this.txt_3_3 = txt_3_3;
		
		this.btFinish = btFinish;
		this.flag = flag;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			try {
			if(txt_0_0.getText().equals("") || txt_0_1.getText().equals("")
			|| txt_0_2.getText().equals("") || txt_0_3.getText().equals("")
			|| txt_1_0.getText().equals("") || txt_1_1.getText().equals("")
			|| txt_1_2.getText().equals("") || txt_1_3.getText().equals("")
			|| txt_2_0.getText().equals("") || txt_2_1.getText().equals("")
			|| txt_2_2.getText().equals("") || txt_2_3.getText().equals("")
			|| txt_3_0.getText().equals("") || txt_3_1.getText().equals("")
			|| txt_3_2.getText().equals("") || txt_3_3.getText().equals("")
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
