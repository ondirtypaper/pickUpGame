package subPage3;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CourtDetailImageLabel extends JLabel {

	public CourtDetailImageLabel(String str) {
		
		setSize(600, 337);
		ImageIcon icon2 = new ImageIcon("res/CourtDetailImage2_600x337.png");
		ImageIcon icon3 = new ImageIcon("res/CourtDetailImage3_600x337.png");
		ImageIcon icon4 = new ImageIcon("res/CourtDetailImage4_600x337.png");
		ImageIcon icon5 = new ImageIcon("res/CourtDetailImage5_600x337.png");
		ImageIcon icon6 = new ImageIcon("res/CourtDetailImage6_600x337.png");
		ImageIcon icon7 = new ImageIcon("res/CourtDetailImage7_600x337.png");

		String str1=str;
		if (str1.equals("이미지2")) {
			setIcon(icon2);
		} else if (str1.equals("이미지3")) {
			setIcon(icon3);
		} else if (str1.equals("이미지4")) {
			setIcon(icon4);
		} else if (str1.equals("이미지5")) {
			setIcon(icon5);
		} else if (str1.equals("이미지6")) {
			setIcon(icon6);
		} else if (str1.equals("이미지7")) {
			setIcon(icon7);
		}
		
		JButton leftArrow = new JButton();
		leftArrow.setSize(30, 100);
		leftArrow.setLocation(550, 170);
		leftArrow.setBackground(Color.white);
		
		leftArrow.setVisible(false);

		add(leftArrow);
		
		JButton rightArrow = new JButton();
		rightArrow.setSize(30, 100);
		rightArrow.setLocation(5, 170);
		rightArrow.setBackground(Color.white);
		rightArrow.setVisible(false);
		add(rightArrow);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				rightArrow.setVisible(false);
				leftArrow.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				rightArrow.setVisible(true);
				leftArrow.setVisible(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

		
}
