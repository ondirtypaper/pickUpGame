package subPage3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CourtDetailImageLabel extends JLabel {

	// 0709 메모 해줄것들 : label에 나온 이미지에 해당하는 버튼 테두리 생기기
	// 화살표 버튼 꾸미기

	int changeLabelImg = 2;

	public CourtDetailImageLabel(String str) {

		setSize(600, 337);
		ImageIcon icon2 = new ImageIcon("res/CourtDetailImage2_600x337.png");
		ImageIcon icon3 = new ImageIcon("res/CourtDetailImage3_600x337.png");
		ImageIcon icon4 = new ImageIcon("res/CourtDetailImage4_600x337.png");
		ImageIcon icon5 = new ImageIcon("res/CourtDetailImage5_600x337.png");
		ImageIcon icon6 = new ImageIcon("res/CourtDetailImage6_600x337.png");
		ImageIcon icon7 = new ImageIcon("res/CourtDetailImage7_600x337.png");

		String str1 = str;
		if (str1.equals("이미지2")) {
			setIcon(icon2);
			changeLabelImg = 2;
		} else if (str1.equals("이미지3")) {
			setIcon(icon3);
			changeLabelImg = 3;
		} else if (str1.equals("이미지4")) {
			setIcon(icon4);
			changeLabelImg = 4;
		} else if (str1.equals("이미지5")) {
			setIcon(icon5);
			changeLabelImg = 5;
		} else if (str1.equals("이미지6")) {
			setIcon(icon6);
			changeLabelImg = 6;
		} else if (str1.equals("이미지7")) {
			setIcon(icon7);
			changeLabelImg = 7;
		}

		JButton leftArrow = new JButton();
		leftArrow.setSize(30, 100);
		leftArrow.setLocation(5, 170);
		leftArrow.setBackground(Color.white);
		leftArrow.setVisible(false);
		leftArrow.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				leftArrow.setVisible(true);

			}

		});
		leftArrow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (changeLabelImg == 2) {
					setIcon(icon7);
					changeLabelImg = 7;
				} else if (changeLabelImg == 3) {
					setIcon(icon2);
					changeLabelImg = 2;
				} else if (changeLabelImg == 4) {
					setIcon(icon3);
					changeLabelImg = 3;
				} else if (changeLabelImg == 5) {
					setIcon(icon4);
					changeLabelImg = 4;
				} else if (changeLabelImg == 6) {
					setIcon(icon5);
					changeLabelImg = 5;
				} else if (changeLabelImg == 7) {
					setIcon(icon6);
					changeLabelImg = 6;
				}
			}
		});
		add(leftArrow);

		JButton rightArrow = new JButton();
		rightArrow.setSize(30, 100);
		rightArrow.setLocation(550, 170);
		rightArrow.setBackground(Color.white);
		rightArrow.setVisible(false);

		rightArrow.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				rightArrow.setVisible(true);
				;
				leftArrow.setVisible(true);

			}

		});

		rightArrow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (changeLabelImg == 2) {
					setIcon(icon3);
					changeLabelImg = 3;
				} else if (changeLabelImg == 3) {
					setIcon(icon4);
					changeLabelImg = 4;
				} else if (changeLabelImg == 4) {
					setIcon(icon5);
					changeLabelImg = 5;
				} else if (changeLabelImg == 5) {
					setIcon(icon6);
					changeLabelImg = 6;
				} else if (changeLabelImg == 6) {
					setIcon(icon7);
					changeLabelImg = 7;
				} else if (changeLabelImg == 7) {
					setIcon(icon2);
					changeLabelImg = 2;
				}

			}
		});
		add(rightArrow);

		addMouseListener(new MouseAdapter() {

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
		});
	}

}
