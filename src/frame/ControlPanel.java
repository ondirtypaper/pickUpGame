package frame;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControlPanel(){
		this.setLayout(null);
		JButton btn1 = new JButton();
		btn1.setSize(100,50);
		btn1.setText(" Page 1 ");
		btn1.setLocation(40,5);
		
		JButton btn2 = new JButton();
		btn2.setSize(100,50);
		btn2.setText(" Page 2 ");
		btn2.setLocation(145,5);
		
		JButton btn3 = new JButton();
		btn3.setSize(100,50);
		btn3.setText(" Pick Up ");
		btn3.setLocation(250,5);
		
		JButton btn4 = new JButton();
		btn4.setSize(100,50);
		btn4.setText(" Page 3 ");
		btn4.setLocation(355,5);
		
		JButton btn5 = new JButton();
		btn5.setSize(100,50);
		btn5.setText(" Page 4 ");
		btn5.setLocation(460,5);
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
	}
}
