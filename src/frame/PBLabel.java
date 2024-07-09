package frame;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class PBLabel extends JLabel implements Runnable{

	JProgressBar pb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	private static int barValue;
	
	PBLabel(){
		pb.setString("Pick Up Game");
		pb.setStringPainted(true);
		barValue = 0;
		new Thread(this).start();
		setVisible(true);
		setSize(300,150);
		this.setText("where am i");
		pb.setLocation(0,0);
		add(pb);
		//run();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(barValue==100){
			barValue=0;
		}
		for(int i=barValue;i<=100;i++){
			
			try{
				Thread.sleep(50);
			} catch(InterruptedException ee){}
				pb.setValue(i);
				barValue=i;
				//pb.setString(i+"%");	
		}

	}

}
