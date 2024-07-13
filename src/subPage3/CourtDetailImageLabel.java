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

//좌우 화살표 버튼 작은게 이쁜듯. 잘 보이게 색깔 수정 고민필요

//courtDetailImagePanel 가운데에 나오는 이미지 라벨
public class CourtDetailImageLabel extends JLabel {

	// 현재 라벨에 무슨 이미지가 붙어있는지 알려줄 int (좌우 버튼을 눌렀을 때 무슨 이미지를 뽑아와야 할지 알려주기 위해 필요)
	public static int changeLabelImg;

	// 이미지 주소 넣은 스트링 배열
	String[] courtImg = { "res/subPage3Img/CourtDetailImage2_600x337.png",
			"res/subPage3Img/CourtDetailImage3_600x337.png", "res/subPage3Img/CourtDetailImage4_600x337.png",
			"res/subPage3Img/CourtDetailImage5_600x337.png", "res/subPage3Img/CourtDetailImage6_600x337.png",
			"res/subPage3Img/CourtDetailImage7_600x337.png" };

	// 이미지 아이콘 생성 (labelchange 메서드 때문에 밖으로 뺌)
	ImageIcon[] courtImgIconlabel = new ImageIcon[6];

	// 생성자
	public CourtDetailImageLabel() {
		for (int i = 0; i < courtImgIconlabel.length; i++) {
			courtImgIconlabel[i] = new ImageIcon(courtImg[i]);
		}

		// 실행시 나올 디폴트 이미지 지정
		setIcon(courtImgIconlabel[0]);
		setSize(600, 337);

		// 왼쪽 화살표 버튼
		JButton leftArrow = new JButton();
		ImageIcon leftArw = new ImageIcon("res/subPage3Img/DetailImgLeftArrowButton_20x32.png");
		leftArrow.setIcon(leftArw);
		leftArrow.setSize(50, 337);
		leftArrow.setLocation(5, 0);
		leftArrow.setBorderPainted(false);
		leftArrow.setContentAreaFilled(false);
		leftArrow.setFocusPainted(false);
		leftArrow.setVisible(false);
		//버튼 액션리스너
		leftArrow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (changeLabelImg) {
				case 0:
					setIcon(courtImgIconlabel[5]);
					changeLabelImg = 5;
					break;
				case 1:
					setIcon(courtImgIconlabel[0]);
					changeLabelImg = 0;
					break;
				case 2:
					setIcon(courtImgIconlabel[1]);
					changeLabelImg = 1;
					break;
				case 3:
					setIcon(courtImgIconlabel[2]);
					changeLabelImg = 2;
					break;
				case 4:
					setIcon(courtImgIconlabel[3]);
					changeLabelImg = 3;
					break;
				case 5:
					setIcon(courtImgIconlabel[4]);
					changeLabelImg = 4;
					break;

				default:
					break;
				}
			}
		});

		// 오른쪽 화살표 버튼
		JButton rightArrow = new JButton();
		ImageIcon rightArw = new ImageIcon("res/subPage3Img/DetailImgRightArrowButton_20x32.png");
		rightArrow.setIcon(rightArw);
		rightArrow.setSize(50, 337);
		rightArrow.setLayout(null);
		rightArrow.setLocation(530, 0);
		rightArrow.setBorderPainted(false);
		rightArrow.setContentAreaFilled(false);
		rightArrow.setFocusPainted(false);
		rightArrow.setVisible(false);
		//버튼 액션리스너
		rightArrow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (changeLabelImg) {
				case 0:
					setIcon(courtImgIconlabel[1]);
					changeLabelImg = 1;
					break;
				case 1:
					setIcon(courtImgIconlabel[2]);
					changeLabelImg = 2;
					break;
				case 2:
					setIcon(courtImgIconlabel[3]);
					changeLabelImg = 3;
					break;
				case 3:
					setIcon(courtImgIconlabel[4]);
					changeLabelImg = 4;
					break;
				case 4:
					setIcon(courtImgIconlabel[5]);
					changeLabelImg = 5;
					break;
				case 5:
					setIcon(courtImgIconlabel[0]);
					changeLabelImg = 0;
					break;

				default:
					break;
				}

			}
		});

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
		// 버튼에 마우스 올리면 버튼 표시 되게 하는 액션리스너
		rightArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightArrow.setVisible(true);
				leftArrow.setVisible(true);

			}

		});
		// 버튼에 마우스 올리면 버튼 표시 되게 하는 액션리스너
		leftArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightArrow.setVisible(true);
				leftArrow.setVisible(true);
			}
		});

		add(leftArrow);
		add(rightArrow);
	}
	
	//버튼 클릭시 라벨 이미지 바꿔줄 메서드(int 받아와서 이미지 구분)
	public void labelChange(int imgLabelNum) {
		CourtDetailImagePanel_Top.DetailImgLabel.setIcon(courtImgIconlabel[imgLabelNum]);
		changeLabelImg=imgLabelNum; //버튼 클릭시에도 현재 무슨 라벨인지 알려주게 int 지정

	}

}
