package subPage3;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import frame.ControlPanel;
import frame.RootFrame;

//mainpanel과 같은 문제가 생겨서 같은 방법으로 임시 해결함(toppanel따로 만들어서 붙이는 방식)

//사진 더보기를 클릭하면 전환되는 세부 이미지 패널
public class CourtDetailImagePanel extends JPanel {

	// 생성자
	public CourtDetailImagePanel() {
		// 패널 디자인
		setSize(600, 900);
		setLayout(null);
		setVisible(true);
		add(new CourtDetailImagePanel_Top());

		// Control panel 추가 by 성배
		ControlPanel controlPanel = new ControlPanel();
		controlPanel.setBackground(RootFrame.MAIN_RED);
		controlPanel.setSize(600, 100);
		controlPanel.setLocation(0, 800);

		this.add(controlPanel);
	}

}

class CourtDetailImagePanel_Top extends JPanel {
	
	//라벨 이미지를 바꿔주기 위한 라벨 객체 (기본은 이미지2로 설정)
		public static CourtDetailImageLabel DetailImgLabel=new CourtDetailImageLabel();
		
	public CourtDetailImagePanel_Top() {
		//패널 디자인
		setSize(600, 800);
		setLocation(0, 0);
		setBackground(Color.darkGray);
		setLayout(new FlowLayout(FlowLayout.CENTER, 7, 200));
		setVisible(true);
		
		//이미지 라벨 추가
		this.add(DetailImgLabel);
		
		
		//아래에 붙어있는 이미지 버튼 추가(생성자 int는 사진 구분 해줄 키)
		//선택된 이미지 버튼 테두리에 달아주고싶은데 아직 구현 못했음
		for (int i = 0; i < 6; i++) {
			CourtDetailmageButton button=new CourtDetailmageButton(i);
			if(CourtDetailImageLabel.changeLabelImg==i) {
				button.setBorder(new LineBorder(Color.BLACK, 2));
				button.setBorderPainted(true);
			}
			add(button);
		}
	}
}


//좌우 화살표 버튼 작은게 이쁜듯. 잘 보이게 색깔 수정 고민필요

//courtDetailImagePanel 가운데에 나오는 이미지 라벨
class CourtDetailImageLabel extends JLabel {

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

//CourtDetailImagePanel 아래에 붙어있는 사진버튼
//현재 선택 되어 있는 사진에 외곽선 생기면 좋을듯

class CourtDetailmageButton extends JButton {

	public CourtDetailmageButton(int imgButtonNum) {
		
		setSize(75, 42);
		setMargin(new Insets(3, 3, 3, 3));
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setVisible(true);
		
		//버튼에 넣을 이미지 주소 넣은 string 배열
		String[] courtImg = { "res/subPage3Img/CourtDetailImage2_75x42.png",
				"res/subPage3Img/CourtDetailImage3_75x42.png", "res/subPage3Img/CourtDetailImage4_75x42.png",
				"res/subPage3Img/CourtDetailImage5_75x42.png", "res/subPage3Img/CourtDetailImage6_75x42.png",
				"res/subPage3Img/CourtDetailImage7_75x42.png" };

		//이미지 아이콘에 주소 넣어서 생성
		ImageIcon[] courtImgIconBtn = new ImageIcon[6];
		for (int i = 0; i < courtImgIconBtn.length; i++) {
			courtImgIconBtn[i] = new ImageIcon(courtImg[i]);
		}
		
		//key 받아와서 어떤 사진 넣을지 설정
		switch (imgButtonNum) {
		case 0:
			setIcon(courtImgIconBtn[0]);
			break;
		case 1:
			setIcon(courtImgIconBtn[1]);
			break;
		case 2:
			setIcon(courtImgIconBtn[2]);
			break;
		case 3:
			setIcon(courtImgIconBtn[3]);
			break;
		case 4:
			setIcon(courtImgIconBtn[4]);
			break;
		case 5:
			setIcon(courtImgIconBtn[5]);
			break;

		default:
			break;
		}

		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//클릭시 라벨 이미지 변경하는 액션리스너
				switch (imgButtonNum) {
				case 0:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(0);
					break;
				case 1:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(1);
					break;
				case 2:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(2);
					break;
				case 3:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(3);
					break;
				case 4:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(4);
					break;
				case 5:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(5);
					break;
				default:
					break;
				}

			}
		});
	}

}

