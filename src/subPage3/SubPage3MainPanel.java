package subPage3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dataManager.ActiveCourt;
import dataManager.MyPlace;
import dataManager.Position;
import frame.ControlPanel;
import frame.RootFrame;

//할거 정리 
//1.디테일이미지 버튼 선택된 이미지 버튼 테두리에 표시 해주기
//2. 별점 연결
//3. 마이플레이스 db만들면 연결
//4. 리뷰 페이지 가는거 연결
//5. 마이플레이스 수정 버튼 생성 및 gui조정
//6. 현재 삭제 적용 안됨
//7. 디테일이미지 버튼이랑 위 라벨영역 구분해주면 좋을듯
//8.코트 인포 프레임 배경색 하나 있으면 좋을듯 하얀색이라도

//제일 아래에 있는 메인 패널
//지도가 그려져 있는 탑패널과 컨트롤패널이 붙어있음
//코트 데이터 리스트도 가지고 있음
public class SubPage3MainPanel extends JPanel {

	public static ArrayList<ActiveCourt> cList; // 코트 데이터 리스트(메인에서 불러오고 data폴더에 저장)

	public SubPage3MainPanel() {
		// 실행 시 코트 데이터 불러오고 clist에 저장
		RootFrame.updateActiveCourt();
		cList = RootFrame.aroundC;

		// 메인 패널 디자인
		setBounds(0, 0, 600, 900);
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);

		// toppanel 추가
		add(SubPage3MainPanel_Top.topPanel);

		// 컨트롤 패널
		ControlPanel controlPanel = new ControlPanel();
		controlPanel.setBackground(RootFrame.MAIN_RED);
		controlPanel.setSize(600, 100);
		controlPanel.setLocation(0, 800);
		this.add(controlPanel);
	}

}

//메인패널 바로 위에 들어갈 패널
//해결할 문제 id와 플레이스네임

class SubPage3MainPanel_Top extends JPanel {
	public static SubPage3MainPanel_Top topPanel = new SubPage3MainPanel_Top();

	int myPlaceId; // 내 장소 등록할때 넣어줄 id 등록 클릭시 1씩 늘어남
	String name;

	// 내 장소 버튼 링크드리스트
	public ArrayList<MyPlaceButton> ButtonList = new ArrayList<>();
	public static ArrayList<MyPlace> mpList;
	// 탑패널에 있는 myplacebutton 삭제 메서드를 참조하기 위한 스태틱 개체

	@Override // 패널 배경 지도 그리기
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Dimension mapD = getSize(); // 패널 사이즈 불러오기
		ImageIcon mapimg = new ImageIcon("res/subPage3Img/지도1.png");
		g.drawImage(mapimg.getImage(), 0, 0, mapD.width, mapD.height, null);

	}

	public void setMyPlaceId(int myPlaceId) {
		this.myPlaceId = myPlaceId;
	}

	public int getMyPlaceId() {
		return myPlaceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 내장소버튼 리스트에 추가하는 메서드
	public void addButtonList(int id, Position p, String name) {
		MyPlaceButton button = new MyPlaceButton(id, p, name); // 추가 할때 마다 새 myPlacebutton 객체 생성
		ButtonList.add(button);
		add(button);

	}

	public void addMyPlace(String userEmail, int id, String name, Position p) {
		MyPlace myplace = new MyPlace(userEmail, id, name, p);
		RootFrame.data.addMyPlace(myplace);
		RootFrame.updateMyPlace();
		mpList.add(myplace);
		addButtonList(id, p, name);

		revalidate();
		repaint();

	}

//		MPNList.add(button);//리스트에 버튼 추가
//		add(button); //패널에 버튼 추가

	// 다시 그리기

	// 프로그램 실행시 초기화하고 내장소 버튼 불러오는 메서드
	private void init() {
		System.out.println("init 시작");
		RootFrame.updateMyPlace();
		mpList = RootFrame.myPlaces;

		if (!mpList.isEmpty()) {
			try {
				System.out.println("mplist 값 :" + mpList);
				for (MyPlace myplace : mpList) {
					addButtonList(myplace.getId(), myplace.getP(), myplace.getName());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("mplist가 비어있거나 없음");
		}

		if (!mpList.isEmpty()) {
			int lastIndex = mpList.size() - 1;
			if (lastIndex >= 0) {
				myPlaceId = mpList.get(lastIndex).getId() + 1;
			} else {
				myPlaceId = 0; // AllmpList가 비어있는 경우 초기값 설정
			}
		} else {
			myPlaceId = 0; // mpList가 비어있는 경우 초기값 설정
		}

		revalidate();
		repaint();
		System.out.println("init 끝");
	}

	// 리스트 순회하면서 id와 MyPlaceButton의 MPI가 일치하면 리스트와 패널에서 버튼을 삭제하는 메서드
	public void removeMyPlace(int id, String email) {
		try {
			if (!ButtonList.isEmpty()) {
				Iterator<MyPlaceButton> it = ButtonList.iterator();
				while (it.hasNext()) {
					MyPlaceButton MPB = it.next();
					if (MPB.getPlaceId() == id) {
						it.remove();
						remove(MPB);
						revalidate();
						repaint();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (!mpList.isEmpty()) {
				Iterator<MyPlace> it = mpList.iterator();
				while (it.hasNext()) {
					MyPlace myplace = it.next();
					if (myplace.getId() == id && myplace.getUserEmail().equals(email)) {
						it.remove();
						RootFrame.updateMyPlace();
						revalidate();
						repaint();
						break;
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 메인 탑 패널(컨트롤패널을 제외한 윗부분) 생성자
	public SubPage3MainPanel_Top() {
		init();
		// 탑패널 디자인
		setBounds(0, 0, 600, 800);
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);

		add(new locationRegistration());

		// 코트 데이터에 있는 위치에 코트 장소 버튼 추가
		add(new CourtPlaceButton(SubPage3MainPanel.cList.get(0).getP(), SubPage3MainPanel.cList.get(0).getId()));
		add(new CourtPlaceButton(SubPage3MainPanel.cList.get(1).getP(), SubPage3MainPanel.cList.get(1).getId()));
		add(new CourtPlaceButton(SubPage3MainPanel.cList.get(2).getP(), SubPage3MainPanel.cList.get(2).getId()));
		add(new CourtPlaceButton(SubPage3MainPanel.cList.get(3).getP(), SubPage3MainPanel.cList.get(3).getId()));

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Position p = new Position(e.getX() - 19, e.getY() - 37);
				int myPlaceId = topPanel.getMyPlaceId();
				String email = RootFrame.cUser.getEmail();
				String name = topPanel.getName();
				// 버튼 리스트에 추가하고 패널에다 버튼 생성하는 메서드 호출
				if (locationRegistration.myPlaceResiFlag) {
					SubPage3MainPanel_Top.topPanel.addMyPlace(email, myPlaceId, name, p);

					SubPage3MainPanel_Top.topPanel.myPlaceId++;

					// 등록이 끝나면 false
					locationRegistration.myPlaceResiFlag = false;
				}

			}

		});

	}

}

//등록 버튼
class locationRegistration extends JButton {
	Position regiBtnLocate = new Position(480, 20); // 등록 버튼 위치 좌표
	static boolean myPlaceResiFlag; // 내 장소 등록버튼 클릭시 한번만 등록하게 해줄 변수

	// 마이 플레이스 등록 버튼

	public locationRegistration() {
		setText("내 장소 등록");
		setFont(CourtInfoFrame.font);
		setLocation((int) regiBtnLocate.getX(), (int) regiBtnLocate.getY());
		setSize(80, 40);
		setBackground(Color.ORANGE);
		setBorder(BorderFactory.createBevelBorder(ABORT));

		// 마이플레이스 등록버튼 액션리스너
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 등록 버튼 클릭시 플래그 true
				myPlaceResiFlag = true;

				String name = JOptionPane.showInputDialog("등록할 나만의 장소명을 입력해주세요.");
				if (name == null) {
					myPlaceResiFlag = false;

				} else if (name.trim().isEmpty()) {
					myPlaceResiFlag = false;
					JOptionPane.showMessageDialog(null, "최소 1자이상 입력하셔야 합니다.");

				} else if (name != null && !name.trim().isEmpty()) {
					SubPage3MainPanel_Top.topPanel.setName(name);

					JOptionPane.showMessageDialog(null, "등록할 나만의 장소의 위치를 클릭해주세요");
				} else {
					myPlaceResiFlag = false;
				}

			}
		});
	}

}

//처음에 등록할때만 나오게 할 프레임
class nameInputFrame extends JFrame {
	String name = ""; // 장소 이름

	public nameInputFrame() {

		Toolkit tk = getToolkit();
		setSize(400, 200);
		setLayout(null);
		setBackground(Color.white);

		// 화면 중앙에 띄우고, 사이즈 조절 불가능하게 만드는 설정
		setLocationRelativeTo(null);
		setResizable(false);

		setVisible(true);

		// 장소 이름 입력 안내
		JLabel inputName = new JLabel();
		inputName.setLocation(50, 0);
		inputName.setSize(300, 25);
		inputName.setText("나만의 장소의 이름을 알려주세요!");
		inputName.setHorizontalAlignment(SwingConstants.CENTER);
		inputName.setVerticalAlignment(SwingConstants.TOP);
		inputName.setHorizontalTextPosition(SwingConstants.CENTER);
		inputName.setVisible(true);
		add(inputName);

		// 장소 이름 입력할 칸
		JTextField placeName = new JTextField();
		placeName.setLocation(50, 50);
		placeName.setSize(300, 25);
		placeName.setText("장소 이름");
		placeName.setHorizontalAlignment(SwingConstants.LEFT);
		placeName.setToolTipText("20글자 이하여야 돼요!");
		placeName.setEditable(false);
		placeName.addFocusListener(new FocusListener() {

			// 장소 이름 입력 힌트 넣기(미구현)
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

		add(placeName);

		// 이름 입력 후 등록 버튼
		JButton regiButton = new JButton();
		regiButton.setText("등록");
		regiButton.setBounds(0, 100, 100, 50);
		regiButton.setVisible(true);
		regiButton.setBackground(Color.orange);

		// 등록 버튼 클릭시 name에다가 입력한 장소 이름 저장
		regiButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name = placeName.getText();
				dispose();
			}
		});

		// 취소 버튼
		JButton cancelButton = new JButton();
		cancelButton.setText("취소");
		cancelButton.setBounds(200, 100, 100, 50);
		cancelButton.setVisible(true);
		cancelButton.setBackground(Color.orange);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		add(regiButton);
		add(cancelButton);

	}

	public String getName() {
		return name;
	}

}