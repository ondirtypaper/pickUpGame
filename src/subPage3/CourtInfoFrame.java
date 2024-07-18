package subPage3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.border.Border;
import javax.swing.text.StyledEditorKit.FontSizeAction;

import org.w3c.dom.Text;

import community.ReviewBegin;
import dataManager.ActiveCourt;
import dataManager.Court;
import dataManager.Position;
import frame.RootFrame;

import javax.swing.*;

//코트 장소 버튼 클릭시 간략한 코트 정보가 담긴 프레임
public class CourtInfoFrame extends JFrame {

	// 아직 추가 안된 기능들
	float reviewPointavg = 4.43f; // 별점 들어오면 평균 저장하는 변수
	int nowcourtNum; // 현재 코트 인원 수
	int s=7; int h=3; int d=16; int c=0;
	public static Font font=new Font("맑은 고딕", Font.PLAIN, 12);

	// 생성자
	public CourtInfoFrame(Position p, int id) {

		Court court = new Court(id, getName(), p);
		// 프레임 디자인
		setSize(400, 200);
		Point point = new Point();
		point.setLocation(p.getX() + 675, p.getY() + 110);
		setLocation(point);
		setLayout(null);
		setBackground(RootFrame.MAIN_ORANGE);
		// 창 크기 고정
		setResizable(false);
		// 프레임 위치 이동 불가능하게 하는거 찾아보기(미해결)
		setVisible(true);

		try {
			Iterator<ActiveCourt> it = SubPage3MainPanel.cList.iterator();
			while (it.hasNext()) {
				ActiveCourt activeCourt = (ActiveCourt) it.next();
				if (activeCourt.getId() == id) {
					court = activeCourt;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		JLabel courtName = new JLabel(court.getName() + " ★" + reviewPointavg); // 별점 폰트 따로 하려면 새로 jlabel 달아줘야함
		courtName.setFont(new Font("맑은고딕", Font.BOLD, 15));
		courtName.setLocation(10, 0);
		courtName.setSize(400, 20);
		courtName.setHorizontalAlignment(JLabel.LEFT);
		add(courtName, BorderLayout.NORTH);

		// 코트 사진 이미지 버튼
		// 코트에서 가지고 있어야 할듯
		ImageIcon sImg = new ImageIcon("res/subPage3Img/CourtDetailImage1_150x112.png");
		ImageIcon hImg = new ImageIcon("res/subPage3Img/courtinfo2.png");
		ImageIcon dImg = new ImageIcon("res/subPage3Img/courtinfo3.png");
		ImageIcon cImg = new ImageIcon("res/subPage3Img/courtinfo4.png");
		
		
		
		JButton courtImg = new JButton();
		
		// 이미지와 버튼 사이의 여백
		courtImg.setMargin(new Insets(0, 0, 0, 0));
		courtImg.setSize(150, 112);
		courtImg.setLocation(10, 25);
		
		resizeImageIcon(courtImg, sImg);
		resizeImageIcon(courtImg, hImg);
		resizeImageIcon(courtImg, dImg);
		resizeImageIcon(courtImg, cImg);
		
		switch (id) {
		case 1:
			courtImg.setIcon(sImg);
			break;
		case 2:
			courtImg.setIcon(hImg);
			break;
		case 3:
			courtImg.setIcon(dImg);
			break;
		case 4:
			courtImg.setIcon(cImg);
			break;

		default:
			break;
		}

		// ??뭔지 모르겠음
		courtImg.setVerticalTextPosition(JButton.BOTTOM);

		courtImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 사진 더보기 구현
				dispose();
				RootFrame.setFrameFor(new CourtDetailImagePanel());
			}
		});
		add(courtImg);

		// 이미지 버튼 아래 달린 사진 더보기 버튼
		JButton moreImg = new JButton("사진 더 보기");
		moreImg.setSize(80, 20);
		moreImg.setBorder(null);
		moreImg.setOpaque(false);
		moreImg.setLocation(85, 140);

		moreImg.setBorderPainted(false);
		moreImg.setContentAreaFilled(false);
		moreImg.setFocusPainted(false);

		moreImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moreImg.setFont(new Font("맑은고딕", Font.BOLD, 12));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				moreImg.setFont(new Font("맑은고딕", Font.PLAIN, 12));
			}
		});

		moreImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 사진 더보기 구현
				dispose();

				// 패널에 디테일 이미지 패널 새로 그리기
				RootFrame.setFrameFor(new CourtDetailImagePanel());
			}
		});

		add(moreImg);

		// 우측에 있는 코트 텍스트 정보 담을 패널
		JPanel courtInfoText = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(flowLayout.LEFT);
		courtInfoText.setBackground(Color.orange);
		courtInfoText.setLayout(flowLayout);
		courtInfoText.setBounds(175, 25, 200, 113);

		// 코트 정보 텍스트
		String haspark;
		String haslight;
		String hastoilet;
		if (court.isHasParking()) {
			haspark = "가능";
		} else
			haspark = "불가능";
		if (court.isHasLight()) {
			haslight = "있음";
		} else
			haslight = "없음";
		if (court.isHasToilet()) {
			hastoilet = "있음";
		} else
			hastoilet = "없음";

		JLabel texture = new JLabel("코트 재질 : " + court.getTexture());
		texture.setFont(font);
		JLabel ring = new JLabel("골대 수 : " + court.getRingNum());
		ring.setFont(font);
		JLabel night = new JLabel("야간 조명 : " + haslight);
		night.setFont(font);
		JLabel parking = new JLabel("주차 여부 : " + haspark+"    ");
		parking.setFont(font);
		JLabel toilet = new JLabel("근처 화장실 여부 : " + hastoilet);
		toilet.setFont(font);
		int playerNum=0;
		switch (court.getId()) {
		case 1:
			playerNum=s;
			break;
		case 2:
			playerNum=h;
			break;
		case 3:
			playerNum=d;
			break;
		case 4:
			playerNum=c;
			break;

		default:
			break;
		}
		JLabel playPeopleNum = new JLabel("코트에서 플레이중인 인원 : " + playerNum + "명");
		playPeopleNum.setFont(font);

		// 현재 인원수 추가 코트 도착시 누를 수 있게 도착버튼 추가하기
		courtInfoText.add(texture);
		courtInfoText.add(ring);
		courtInfoText.add(parking);
		courtInfoText.add(night);
		courtInfoText.add(toilet);
		courtInfoText.add(playPeopleNum);
		add(courtInfoText);

		// 리뷰보기 버튼
		JButton moreReview = new JButton("이 코트 리뷰 보러가기");
		moreReview.setSize(130, 20);
		moreReview.setBorder(null);
		moreReview.setOpaque(false);
		moreReview.setLocation(245, 140);

		moreReview.setBorderPainted(false);
		moreReview.setContentAreaFilled(false);
		moreReview.setFocusPainted(false);

		moreReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moreReview.setFont(new Font("맑은고딕", Font.BOLD, 12));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				moreReview.setFont(new Font("맑은고딕", Font.PLAIN, 12));
			}
		});

		moreReview.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 리뷰 더보기 구현 페이지 옮겨주는걸로 확정
				dispose();
				RootFrame.setFrameFor(new ReviewBegin());
			}
		});

		Button button = new Button();
		button.setBounds(200, 200, 200, 100);
		button.addActionListener(e -> RootFrame.setFrameFor(new GameRoomPanel()));

		add(button);
		add(moreReview);

	}
	
	private static void resizeImageIcon(JButton button, ImageIcon originalIcon) {
        int buttonWidth = button.getPreferredSize().width;
        int buttonHeight = button.getPreferredSize().height;

        // 이미지 아이콘 크기 조정
        Image scaledImage = originalIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // 버튼에 아이콘 설정
        button.setIcon(scaledIcon);
    }

}
