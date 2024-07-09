package subPage3;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyPlaceButton extends JButton {

	
	public MyPlaceButton(Point p) {
		ImageIcon icon = new ImageIcon("res/MyLocateButton_4040.png");
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
				setIcon(new ImageIcon("res/MyLocateButton_6060.png"));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

		addActionListener(new ActionListener() {
			//한번만 실행되게 만들기
			@Override
			public void actionPerformed(ActionEvent e) {
				new MyPlaceFrame();
			}
		});
		// 
		
		

	}
		
		
		
	
	
	
}
