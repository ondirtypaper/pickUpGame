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

import dataManager.Position;

//나만의 장소 버튼
public class MyPlaceButton extends JButton {
	String name; //입력한 장소 이름 저장해줄 String
	Position p; //버튼 좌표 저장해줄 position

	int MPI; //버튼 고유 ID
	private boolean MyPlaceFrameSwitch; //이름 등록 전 띄울 프레임과 등록 후 띄울 프레임을 구분해줄 스위치 

	public MyPlaceButton(int placeId, Position p) {
		MPI = placeId; 
		MyPlaceFrameSwitch = true;
		
		//나만의 장소 버튼 디자인
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
					
					//화면 중앙에 띄우고, 사이즈 조절 불가능하게 만드는 설정
					myPlaceAddFrame.setLocationRelativeTo(null);
					myPlaceAddFrame.setResizable(false);
					
					myPlaceAddFrame.setVisible(true);
					

						//장소 이름 입력 안내
						JLabel inputName = new JLabel();
						inputName.setLocation(50, 0);
						inputName.setSize(300, 25);
						inputName.setText("나만의 장소의 이름을 알려주세요!");
						inputName.setHorizontalAlignment(SwingConstants.CENTER);
						inputName.setVerticalAlignment(SwingConstants.TOP);
						inputName.setHorizontalTextPosition(SwingConstants.CENTER);
						inputName.setVisible(true);
						myPlaceAddFrame.add(inputName);

						//장소 이름 입력할 칸
						JTextField placeName = new JTextField();
						placeName.setLocation(50, 50);
						placeName.setSize(300, 25);
						placeName.setText("장소 이름");
						placeName.setHorizontalAlignment(SwingConstants.LEFT);
						placeName.setToolTipText("20글자 이하여야 돼요!");
						placeName.setEditable(false);
						placeName.addFocusListener(new FocusListener() {

							
						//장소 이름 입력 힌트 넣기(미구현)
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
						
						//이름 입력 후 등록 버튼
						JButton regiButton = new JButton();
						regiButton.setText("등록");
						regiButton.setBounds(0, 100, 100, 50);
						regiButton.setVisible(true);
						regiButton.setBackground(Color.orange);
						
						//등록 버튼 클릭시 name에다가 입력한 장소 이름 저장
						regiButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								name = placeName.getText();
								myPlaceAddFrame.dispose();
								JOptionPane.showMessageDialog(regiButton, "등록이 완료되었습니다.");
								//등록 완료했으니 등록 버튼 누르기 전까지는 지도를 클릭해도 새로 등록이 안되게 플래그 false값
								MyPlaceFrameSwitch = false;
								//id 1씩 증가시켜서 중복 x되게
								SubPage3MainPanel_Top.myPlaceId++;
							}
						});
						
						//취소 버튼
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

				else if (MyPlaceFrameSwitch == false) {

					new MyPlaceFrame(placeId, p, name);

				}
			}
		});

		//

	}

	public int getMPI() {
		return MPI;
	}

}
