package subPage3;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CourtDetailmageButton extends JButton {

	public CourtDetailmageButton(ImageIcon icon,String str) {
		setIcon(icon);
		setSize(75, 42);
		setMargin(new Insets(3, 3, 3, 3));
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setVisible(true);
		
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ImageIcon icon2 = new ImageIcon("res/CourtDetailImage2_600x337.png");
				ImageIcon icon3 = new ImageIcon("res/CourtDetailImage3_600x337.png");
				ImageIcon icon4 = new ImageIcon("res/CourtDetailImage4_600x337.png");
				ImageIcon icon5 = new ImageIcon("res/CourtDetailImage5_600x337.png");
				ImageIcon icon6 = new ImageIcon("res/CourtDetailImage6_600x337.png");
				ImageIcon icon7 = new ImageIcon("res/CourtDetailImage7_600x337.png");
				if (str.equals("이미지2")) {
					CourtDetailImagePanel.labelChange(icon2);
				} else if (str.equals("이미지3")) {
					CourtDetailImagePanel.labelChange(icon3);
				} else if (str.equals("이미지4")) {
					CourtDetailImagePanel.labelChange(icon4);
				} else if (str.equals("이미지5")) {
					CourtDetailImagePanel.labelChange(icon5);
				} else if (str.equals("이미지6")) {
					CourtDetailImagePanel.labelChange(icon6);
				} else if (str.equals("이미지7")) {
					CourtDetailImagePanel.labelChange(icon7);
				}
				
				
			}
		});
	}
	
}
