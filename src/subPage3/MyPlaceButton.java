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

public class MyPlaceButton extends JButton {
	public static boolean MyPlaceFrameSwitch;
	boolean registerWhether;
	String name;
	public MyPlaceButton(Point p) {
		MyPlaceFrameSwitch = true;
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
		addMouseListener(new MouseAdapter() {
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
			// 한번만 실행되게 만들기
			@Override
			public void actionPerformed(ActionEvent e) {

				if (MyPlaceFrameSwitch == true) {

					// 처음에 등록할때만 나오게 할 프레임
					JFrame myPlaceAddFrame = new JFrame();
					Toolkit tk = getToolkit();
					myPlaceAddFrame.setSize(400, 200);
					myPlaceAddFrame.setLayout(null);
					myPlaceAddFrame.setBackground(Color.white);
					myPlaceAddFrame.setLocation(p);
					myPlaceAddFrame.setVisible(true);

					if (registerWhether = true) {

						JLabel inputName = new JLabel();
						inputName.setLocation(50, 0);
						inputName.setSize(300, 25);
						inputName.setText("나만의 장소의 이름을 알려주세요!");
						inputName.setHorizontalAlignment(SwingConstants.CENTER);
						inputName.setVerticalAlignment(SwingConstants.TOP);
						inputName.setHorizontalTextPosition(SwingConstants.CENTER);
						inputName.setVisible(true);
						myPlaceAddFrame.add(inputName);

						JTextField placeName = new JTextField();
						placeName.setLocation(50, 50);
						placeName.setSize(300, 25);
						placeName.setText("장소 이름");
						placeName.setHorizontalAlignment(SwingConstants.LEFT);
						placeName.setToolTipText("20글자 이하여야 돼요!");
						placeName.setEditable(false);
						placeName.addMouseListener(new MouseListener() {

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
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub

							}
						});
						placeName.addFocusListener(new FocusListener() {

							@Override
							public void focusLost(FocusEvent e) {
								if (placeName.getText().equals(""))
									placeName.setText("장소 이름");

							}

							@Override
							public void focusGained(FocusEvent e) {
								placeName.setEditable(true);
								if (placeName.getText().equals("장소 이름")) {
									placeName.setText("");
								}
							}
						});
						placeName.setVisible(true);

						myPlaceAddFrame.add(placeName);

						JButton regiButton = new JButton();
						regiButton.setText("등록");
						regiButton.setBounds(0, 100, 100, 50);
						regiButton.setVisible(true);
						regiButton.setBackground(Color.orange);
						regiButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								name=placeName.getText();
								myPlaceAddFrame.dispose();
								JOptionPane.showMessageDialog(regiButton, "등록이 완료되었습니다.");
								registerWhether = false;
								MyPlaceButton.MyPlaceFrameSwitch = false;
							}
						});

						JButton cancelButton = new JButton();
						cancelButton.setText("취소");
						cancelButton.setBounds(200, 100, 100, 50);
						cancelButton.setVisible(true);
						cancelButton.setBackground(Color.orange);
						cancelButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								myPlaceAddFrame.dispose();

							}
						});

						myPlaceAddFrame.add(regiButton);
						myPlaceAddFrame.add(cancelButton);

					}

				}

				else if (MyPlaceFrameSwitch == false) {
					
					new MyPlaceFrame(p, name);

				}
			}
		});

		//

	}

}
