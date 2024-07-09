package subPage3;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPlaceFrame extends JFrame {

	public MyPlaceFrame() {
		Toolkit tk=getToolkit(); 
		setSize(100, 100);
		setLayout(null);
		setBackground(Color.white);
		
		JTextField name=new JTextField(SubPage3MainPanel.MyPlaceName);
		name.setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight());
		name.setLayout(null);
		name.setVisible(true);
		add(name);
		setVisible(true);
		
		
	}
	
}
