package subPage3;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyPlaceFrame extends JFrame {

	
	public MyPlaceFrame(Point p,String str) {
		
		setSize(400, 200);
		setLayout(null);
		setBackground(Color.white);
		setLocation(p);
		setVisible(true);
		
		JLabel outputName=new JLabel();
		outputName.setLocation(50, 0);
		outputName.setSize(300,25);
		outputName.setText(str);
		outputName.setHorizontalAlignment(SwingConstants.CENTER);
		outputName.setVerticalAlignment(SwingConstants.TOP);
		outputName.setHorizontalTextPosition(SwingConstants.CENTER);
		outputName.setVisible(true);
		add(outputName);
		
		
		
		
	}
	
}
