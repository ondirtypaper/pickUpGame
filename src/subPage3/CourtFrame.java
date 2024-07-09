package subPage3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;

import org.w3c.dom.Text;

import frame.RootFrame;

import javax.swing.*;

public class CourtFrame extends JFrame {

	public static boolean push; // courtFrame 보였다 안보였다 하기위해 boolean에 넣고 setvisible에 가져다씀
	float reviewPointavg = 4.43f; // 별점 들어오면 평균 저장하는 변수
	int nowcourtNum; // 현재 코트 인원 수
	
	
	public CourtFrame(SubPage3Frame temp,int x,int y) {
		SubPage3Frame.temp=temp;
		
		setLocation(x, y);
		setSize(400, 200);
		setLayout(null);
		setBackground(Color.black);
		setVisible(true);
		// 프레임 사이즈 고정 해주고 이동 불가 하기
		// 클릭 전에는 안보이게 할 예정(push로 구현)

		// 왼쪽 사진 추가,몇명 있는지 갈 예정인지 버튼(시간추가되면 좋음) 간략한 코트 textarea 더보기 리뷰정보
		// 야간 불 켜주는지 정보

		// 코트 이름 정보
		JLabel courtName = new JLabel("성균관대학교 인문사회과학 캠퍼스 농구장 ★" + reviewPointavg); // 별점 폰트 따로 하려면 새로 jlabel 달아줘야함
		courtName.setFont(new Font("Serif", Font.BOLD, 12));
		courtName.setLocation(10, 0);
		courtName.setSize(400, 20);
		courtName.setHorizontalAlignment(JLabel.LEFT);
		courtName.setBackground(Color.blue);
		add(courtName, BorderLayout.NORTH);

		// 코트 사진 이미지 버튼
		ImageIcon cImg = new ImageIcon("res/CourtDetailImage1_150x112.png");
		JButton courtImg = new JButton();
		courtImg.setIcon(cImg);
		courtImg.setSize(150, 112);
		courtImg.setLocation(10, 25);
		courtImg.setVerticalTextPosition(JButton.BOTTOM);
		courtImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 사진 더보기 구현
				dispose();
				RootFrame.setFrameFor(new MoreImgPanel());
			}
		});
		add(courtImg);

		// 사진 더보기 버튼
		JButton moreImg = new JButton("사진 더 보기");
		moreImg.setFont(PickupGameBase.tempfont);
		moreImg.setSize(60, 20);
		moreImg.setBorder(null);
		moreImg.setOpaque(false);
		moreImg.setLocation(90, 140);
		moreImg.setBackground(Color.green);

		moreImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 사진 더보기 구현
				dispose(); //코트프레임 꺼지기
				RootFrame.setFrameFor(new MoreImgPanel());
			}
		});

		add(moreImg);

		// 우측 정보
		JPanel courtInfoText = new JPanel();
		courtInfoText.setLayout(new FlowLayout());
		courtInfoText.setBounds(170, 25, 200, 113);
		courtInfoText.setBackground(Color.cyan);
		// 코트 정보 내용
		String str1 = "우레탄";
		String str2 = "가능";
		String str3 = "있음";
		int str4 = 2;
		JLabel texture = new JLabel("코트 재질 " + str1);
		JLabel parking = new JLabel("주차 여부 " + str2);
		JLabel night = new JLabel("야간 조명 " + str3);
		JLabel ring = new JLabel("골대 수 " + str4);
		// 현재 인원수 추가 코트 도착시 누를 수 있게 도착버튼 추가하기
		courtInfoText.add(ring);
		courtInfoText.add(texture);
		courtInfoText.add(parking);
		courtInfoText.add(night);
		add(courtInfoText);
		// 리뷰보기 버튼
		JButton moreReview = new JButton("이 코트 리뷰 보러가기");
		moreReview.setFont(PickupGameBase.tempfont);
		moreReview.setSize(120, 20);
		moreReview.setBorder(null);
		moreReview.setOpaque(false);
		moreReview.setLocation(255, 140);
		moreReview.setBackground(Color.green);
		moreReview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 리뷰 더보기 구현 (페이지를 옮겨줄지, 새 창을 띄울지 고민중)

			}
		});
		add(moreReview);

	}

}
