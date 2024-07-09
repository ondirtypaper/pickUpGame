package subPage3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;

public class SubPage3_Locationbutton extends JButton {

	Point click = new Point();// xy담는 포인트 좌표
	// 위치 버튼 생성자

	public SubPage3_Locationbutton(Point p) {
		ImageIcon icon = new ImageIcon("res/locationbutton_4040.png");
		setIcon(icon);
		setSize(40, 40);
		setLayout(null);
		setLocation(p);
		setVisible(true);

		// 이 3개로 버튼 테두리 없앰
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);

		// 마우스 올렸을때 커지기
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
				// 마우스 떼면 다시 아이콘 작아짐
				setSize(40, 40);
				setIcon(icon);
				setLocation(p);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스 올리면 아이콘 커짐
				setLocation((int) p.getX() - 10, (int) p.getY() - 10);
				setSize(60, 60);
				setIcon(new ImageIcon("res/locationbutton_6060.png"));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				new CourtInfoFrame(SubPage3Frame.temp, e.getX(), e.getY());
				System.out.println(SubPage3MainPanel.x);
			}
		});

//		// 위치버튼 클릭시 코트정보 나오는 액션리스너
//		addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new CourtFrame(SubPage3Frame.temp, x, y);
//
//			}
//		});
		

	}

}
