package thread;

import javax.swing.JLabel;
public class CountTime implements Runnable{

	public int minutes = 0;
	public int seconds = 0;
	public String countTime;
	public boolean flag = true;
	public JLabel lbDisplayTime;
	public CountTime(JLabel _lbDisplayTime) {
		// TODO Auto-generated constructor stub
		this.lbDisplayTime = _lbDisplayTime;
	}
	public void run() {
		// TODO Auto-generated method stub
		
		while(flag){
			try {
				seconds++;
				Thread.sleep(1000);
				if(seconds==60){
					minutes++;
					seconds = 0;
				}
				if(seconds<10 && minutes>9){
					countTime = minutes+":0"+seconds;
				}else if(minutes<10 && seconds>9){
					countTime = "0"+minutes+":"+seconds;
				}else if(seconds<10 && minutes<10){
					countTime = "0"+minutes+":0"+seconds;
				}else{
					countTime = minutes+":"+seconds;
				}
				this.lbDisplayTime.setText(countTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
