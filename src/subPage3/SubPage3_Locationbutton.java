package subPage3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SubPage3_Locationbutton extends JButton {
	//위치 버튼
	//클릭시 사이즈 살짝 늘어나면 좋을듯
	public SubPage3_Locationbutton(Point p, ImageIcon b) {
		setIcon(b);
		setSize(40, 40);
		setLayout(null);
		setLocation(p);
		setVisible(true);
		setBorder(null);
		setOpaque(false);

		
			
			
		

	}

}
