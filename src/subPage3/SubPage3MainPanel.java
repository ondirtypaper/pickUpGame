package subPage3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import frame.ControlPanel;
import frame.RootFrame;

public class SubPage3MainPanel extends JPanel {

	public static int x, y; // 등록버튼 클릭시 좌표 입력해줄 변수
	public static String MyPlaceName;
	boolean click;

	@Override // 패널 지도
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Dimension mapD = getSize();
		ImageIcon mapimg = new ImageIcon("res/지도1.png");
		g.drawImage(mapimg.getImage(), 0, 0, mapD.width, mapD.height, null);

	}

	public SubPage3MainPanel(){

	//public SubPage3MainPanel(SubPage3Frame temp) {

		//SubPage3Frame.temp = temp;
		// 메인 패널 디자인
		setBounds(0, 0, 600, 900);
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);

		// 등록 버튼(나중에 마우스 클릭하고
		JButton locationRegistration = new JButton();
		Point btnloc = new Point(480, 20); // 등록 버튼 위치 좌표
		locationRegistration.setText("내 장소 등록");

		locationRegistration.setFont(PickupGameBase.tempfont);
		locationRegistration.setLocation(btnloc);
		locationRegistration.setSize(80, 40);
		locationRegistration.setBackground(Color.ORANGE);
		locationRegistration.setBorder(BorderFactory.createBevelBorder(ABORT));
		add(locationRegistration);
		//미해결 - 한번만 등록되게 하기
		locationRegistration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "등록할 나만의 장소의 위치를 클릭해주세요");
				// 새로 패널 띄우고 거기다 클릭하면 좌표표시 이후 그 좌표에 등록하면 새 위치 생성
				addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						x = e.getX();
						y = e.getY();
						Point point = new Point(x - 19, y - 37);
						add(new MyPlaceButton(point));
					}

				});// 클릭 마우스 어댑터
				
				

			}

		});
		
		// 위치 버튼 불러오기
		PickupGameBase base = new PickupGameBase();// 좌표 불러오기용
		add(new SubPage3_Locationbutton(base.getPointCourt1Hong()));
		add(new SubPage3_Locationbutton(base.getPointCourt2Sung()));
		add(new SubPage3_Locationbutton(base.getPointCourt3dong()));
		add(new SubPage3_Locationbutton(base.getPointCourt4Catholic()));

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
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		// 위치 클릭시 들어갈 패널

		// 농구장 위치 좌표찍기용
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			System.out.println("x : "+e.getX()+"y : "+e.getY());
//			}
//		});
		
		ControlPanel controlPanel = new ControlPanel();
		controlPanel.setBackground(RootFrame.MAIN_RED);
		controlPanel.setSize(600,100);
		controlPanel.setLocation(0,800);
		
		
		this.add(controlPanel);
	}

}
