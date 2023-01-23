package snake;

import java.util.TimerTask;

public class TimeHelper extends TimerTask {
 public int i=0;
	
	@Override
	public void run() {
		
		System.out.println("Timer" + i++);
		
	}

}
