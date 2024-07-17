package subPage3;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dataManager.MyPlace;
import dataManager.Position;
import frame.RootFrame;

//나만의 장소 버튼
public class MyPlaceButton extends JButton implements ActionListener {
	int placeId; // 버튼 고유 ID
	Position p; // 버튼 좌표 저장해줄 position
	String name; // 입력한 장소 이름 저장해줄 String
	

	public int getPlaceId() {
		return placeId;
	}

	public MyPlaceButton(int placeId, Position p,String name) {
		this.placeId=placeId;
		this.p=p;
		this.name=name;

		// 나만의 장소 버튼 디자인
		ImageIcon icon = new ImageIcon("res/subPage3Img/MyLocateButton_4040.png");
		setIcon(icon);
		setSize(40, 40);
		setLayout(null);
		setLocation((int) p.getX(), (int) p.getY());
		setVisible(true);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);

		// 마우스 올렸을때 커지기
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스 떼면 다시 아이콘 작아짐
				setSize(40, 40);
				setIcon(icon);
				setLocation((int) p.getX(), (int) p.getY());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스 올리면 아이콘 커짐
				setLocation((int) p.getX() - 10, (int) p.getY() - 10);
				setSize(60, 60);
				setIcon(new ImageIcon("res/subPage3Img/MyLocateButton_6060.png"));

			}

		});

		addActionListener(this);
			

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MyPlaceFrame(placeId, p, name);
		
	}
	
	

}
