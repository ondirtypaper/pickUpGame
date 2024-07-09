package frame;

import javax.swing.JProgressBar;

public class FirstProBar extends JProgressBar implements Runnable{
	private int value;
	
	@Override
	public void run() {
		
		for (int i = 0; i <=100; i++) {
			try {
				Thread.sleep(50);
			} catch(InterruptedException e) {		
			}
			this.setValue(i);
			value = i;
		}
	}

	FirstProBar(){
		super(JProgressBar.HORIZONTAL, 0, 100);
		this.setLocation(180,125);
		this.setSize(200,40);
		
		new Thread(this).start();
	}
}
