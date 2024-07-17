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

import dataManager.Position;

//코트 장소 버튼
public class CourtPlaceButton extends JButton {

	// 생성자
	public CourtPlaceButton(Position p,int id) {
		//버튼 디자인
		ImageIcon icon = new ImageIcon("res/subPage3Img/locationbutton_4040.png");
		setIcon(icon);
		setSize(40, 40);
		setLayout(null);
		setLocation((int)p.getX(),(int)p.getY());
		setVisible(true);

		// 이 3개로 버튼 테두리 없앰
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);

		//버튼 마우스 리스너
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스 떼면 다시 아이콘 작아짐
				setSize(40, 40);
				setIcon(icon);
				setLocation((int)p.getX(),(int)p.getY());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스 올리면 아이콘 커짐
				setLocation((int) p.getX() - 10, (int) p.getY() - 10);
				setSize(60, 60);
				setIcon(new ImageIcon("res/subPage3Img/locationbutton_6060.png"));

			}
		});

		// 위치버튼 클릭시 코트정보 나오는 액션리스너
		addActionListener(e->new CourtInfoFrame(p,id)); 

			
		
	}
	

}
