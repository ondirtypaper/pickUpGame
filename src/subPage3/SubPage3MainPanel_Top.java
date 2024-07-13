package subPage3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import dataManager.Position;

//메인패널 바로 위에 들어갈 패널

public class SubPage3MainPanel_Top extends JPanel {

	boolean myPlaceResiFlag; // 내 장소 등록버튼 클릭시 한번만 등록하게 해줄 변수
	public static Position myPlaceLocation; // 등록버튼 좌표 찍어줄 position객체
	static int myPlaceId = 0; // 내 장소 등록할때 넣어줄 id 등록 클릭시 1씩 늘어남
	
	// 내 장소 버튼 링크드리스트
	public static LinkedList<MyPlaceButton> MPNList = new LinkedList<MyPlaceButton>();
	// 탑패널에 있는 myplacebutton 삭제 메서드를 참조하기 위한 스태틱 개체 
	public static SubPage3MainPanel_Top topPanel = new SubPage3MainPanel_Top();
	

	@Override // 패널 배경 지도 그리기
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Dimension mapD = getSize(); //패널 사이즈 불러오기
		ImageIcon mapimg = new ImageIcon("res/subPage3Img/지도1.png");
		g.drawImage(mapimg.getImage(), 0, 0, mapD.width, mapD.height, null);

	}

	// 내장소버튼 리스트에 추가하는 메서드
	public void addmyPlaceButtonList(int id, Position p) {
		MyPlaceButton button = new MyPlaceButton(id, p); //추가 할때 마다 새 myPlacebutton 객체 생성
 		MPNList.add(button);//리스트에 버튼 추가
		add(button); //패널에 버튼 추가
		
		//다시 그리기
		revalidate();
		repaint();
	}

	// 프로그램 실행시 초기화하고 내장소 버튼 불러오는 메서드
	private void init() {
		for (int i = 0; i < MPNList.size(); i++) {
			add(MPNList.get(i));
		}
	}
	
	//리스트 순회하면서 id와 MyPlaceButton의 MPI가 일치하면 리스트와 패널에서 버튼을 삭제하는 메서드
	public void removeMyPlace(int id) {
		try {
			Iterator<MyPlaceButton> it = MPNList.iterator();
			while (it.hasNext()) {
				MyPlaceButton MPB = it.next();
				if (MPB.getMPI() == id) {
					it.remove();
					remove(MPB);
					revalidate();
					repaint();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//메인 탑 패널(컨트롤패널을 제외한 윗부분) 생성자
	public SubPage3MainPanel_Top() {
		//탑패널 디자인
		setBounds(0, 0, 600, 800);
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);
		
		//등록버튼 실행할 수 있게 패널 생성 시 플래그 초기화

		// 등록 버튼
		JButton locationRegistration = new JButton();
		Position regiBtnLocate = new Position(480, 20); // 등록 버튼 위치 좌표
		
		//마이 플레이스 등록 버튼
		locationRegistration.setText("내 장소 등록");
		locationRegistration.setLocation((int)regiBtnLocate.getX(),(int)regiBtnLocate.getY());
		locationRegistration.setSize(80, 40);
		locationRegistration.setBackground(Color.ORANGE);
		locationRegistration.setBorder(BorderFactory.createBevelBorder(ABORT));
		add(locationRegistration);
		
		//마이플레이스 등록버튼 액션리스너
		locationRegistration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//등록 버튼 클릭시 플래그 true
				myPlaceResiFlag = true;
				
				//등록 버튼 클릭 시 좌표 표시 할 수 있도록 안내해주는 메세지다이얼로그
				JOptionPane.showMessageDialog(null, "등록할 나만의 장소의 위치를 클릭해주세요");
				
				// 새로 패널 띄우고 거기다 클릭하면 좌표표시 이후 그 좌표에 등록하면 새 위치 생성
				addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (myPlaceResiFlag == true) {
							
							//왜 setlocation재정의 한걸로는 오류가 나고 new position에다 넣어주면 안날까?
							myPlaceLocation=new Position(e.getX() - 19, e.getY() - 37); 
							
							//버튼 리스트에 추가하고 패널에다 버튼 생성하는 메서드 호출
							addmyPlaceButtonList(myPlaceId, myPlaceLocation);
							
							//등록이 끝나면 false
							myPlaceResiFlag = false;
						}
					}

				});// 클릭 마우스 어댑터

			}
		});

		//코트 데이터에 있는 위치에 코트 장소 버튼 추가
		add(new CourtPlaceButton(SubPage3MainPanel.cList.get(0).getP()));
		add(new CourtPlaceButton(SubPage3MainPanel.cList.get(1).getP()));
		add(new CourtPlaceButton(SubPage3MainPanel.cList.get(2).getP()));
		add(new CourtPlaceButton(SubPage3MainPanel.cList.get(3).getP()));

	}

}
