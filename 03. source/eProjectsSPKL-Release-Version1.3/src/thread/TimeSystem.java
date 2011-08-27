package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class TimeSystem implements Runnable {
	JLabel lbTimeDate = new JLabel();
	public void run() {
		while(true){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date dateSystem = new Date(System.currentTimeMillis()); 
				lbTimeDate.setText(sdf.format(dateSystem.getTime()));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public TimeSystem(JLabel lbTime) {
		this.lbTimeDate = lbTime;
	}
}
