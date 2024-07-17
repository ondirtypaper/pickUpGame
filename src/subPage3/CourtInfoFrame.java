package subPage3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.border.Border;

import org.w3c.dom.Text;

import dataManager.ActiveCourt;
import dataManager.Court;
import dataManager.Position;
import frame.RootFrame;

import javax.swing.*;

//코트 장소 버튼 클릭시 간략한 코트 정보가 담긴 프레임
public class CourtInfoFrame extends JFrame {

	//아직 추가 안된 기능들
	float reviewPointavg = 4.43f; // 별점 들어오면 평균 저장하는 변수
	int nowcourtNum; // 현재 코트 인원 수
	
	//생성자
	public CourtInfoFrame(Position p,int id) {
		
		Court court=new Court(id, getName(), p);
		//프레임 디자인
		setSize(400, 200);
		Point point=new Point();
		point.setLocation(p.getX()+675, p.getY()+110);
		setLocation(point);
		setLayout(null);
		setBackground(Color.black);
		//창 크기 고정
		setResizable(false);
		//프레임 위치 이동 불가능하게 하는거 찾아보기(미해결)
		setVisible(true);
		
		try {
			Iterator<ActiveCourt> it=SubPage3MainPanel.cList.iterator();
			while (it.hasNext()) {
				ActiveCourt activeCourt = (ActiveCourt) it.next();
				if (activeCourt.getId()==id) {
					court=activeCourt;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JLabel courtName = new JLabel(court.getName() + reviewPointavg); // 별점 폰트 따로 하려면 새로 jlabel 달아줘야함
		courtName.setFont(new Font("Serif", Font.BOLD, 12));
		courtName.setLocation(10, 0);
		courtName.setSize(400, 20);
		courtName.setHorizontalAlignment(JLabel.LEFT);
		courtName.setBackground(Color.blue);
		add(courtName, BorderLayout.NORTH);

		// 코트 사진 이미지 버튼
		//코트에서 가지고 있어야 할듯
		ImageIcon cImg = new ImageIcon("res/subPage3Img/CourtDetailImage1_150x112.png");
		JButton courtImg = new JButton();
		courtImg.setIcon(cImg);
		//이미지와 버튼 사이의 여백
		courtImg.setMargin(new Insets(0, 0, 0, 0));
		courtImg.setSize(150, 112);
		courtImg.setLocation(10, 25);
		
		//??뭔지 모르겠음
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
		moreImg.setSize(60, 20);
		moreImg.setBorder(null);
		moreImg.setOpaque(false);
		moreImg.setLocation(90, 140);
		moreImg.setBackground(Color.green);

		moreImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 사진 더보기 구현
				dispose();
				
				//패널에 디테일 이미지 패널 새로 그리기
				RootFrame.setFrameFor(new CourtDetailImagePanel());
			}
		});

		add(moreImg);

		// 우측에 있는 코트 텍스트 정보 담을 패널
		JPanel courtInfoText = new JPanel();
		courtInfoText.setLayout(new FlowLayout());
		courtInfoText.setBounds(170, 25, 200, 113);
		courtInfoText.setBackground(Color.cyan);
		
		
		//코트 정보 텍스트
		JLabel texture = new JLabel();
		texture.setText("코트 재질 : "+court.getTexture());
		JLabel parking = new JLabel("주차 여부 : " + court.isHasParking());
		JLabel night = new JLabel("야간 조명 : " + court.isHasLight());
		JLabel ring = new JLabel("골대 수 : " + court.getRingNum());
		JLabel toilet = new JLabel("근처 화장실 여부 : " + court.isHasToilet());
		
		// 현재 인원수 추가 코트 도착시 누를 수 있게 도착버튼 추가하기
		courtInfoText.add(ring);
		courtInfoText.add(texture);
		courtInfoText.add(parking);
		courtInfoText.add(night);
		add(courtInfoText);
		
		// 리뷰보기 버튼
		JButton moreReview = new JButton("이 코트 리뷰 보러가기");
		moreReview.setSize(120, 20);
		moreReview.setBorder(null);
		moreReview.setOpaque(false);
		moreReview.setLocation(255, 140);
		moreReview.setBackground(Color.green);
		moreReview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 리뷰 더보기 구현 페이지 옮겨주는걸로 확정

			}
		});
		
		Button button = new Button();
		button.setBounds(200, 200, 200, 100);
		button.addActionListener(e -> RootFrame.setFrameFor(new GameRoomPanel()));

		add(button);
		add(moreReview);

	}

}
