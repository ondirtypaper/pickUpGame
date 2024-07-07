package subPage3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Highlighter.Highlight;

import frame.ControlPanel;
import frame.RootFrame;

public class SubPage3Panel extends JPanel{
//	@Override //패널 지도
//	public void paint(Graphics g) {
//		Dimension mapD=getSize();
//		ImageIcon mapimg=new ImageIcon("./pickupGame_image/지도1.png");
//		g.drawImage(mapimg.getImage(), 0, 0, mapD.width, mapD.height,null);
//	}
	
//	코트 패널 집어넣는 메서드
	public void addcourtpanel() {
		
		JPanel couPan=new JPanel();
		
		couPan.setLocation(getMousePosition());
		couPan.setSize(160, 90);
		couPan.setLayout(null);
		couPan.setBackground(Color.black);
		couPan.setVisible(true);
		add(couPan);
	}
	
	public SubPage3Panel() {
		//패널 디자인
		setBounds(0, 0, 600, 900);
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);
		
		
		
		//등록버튼
		JButton locationregistration=new JButton();
		Point btnloc=new Point(480,20); //등록 버튼 위치 좌표
		locationregistration.setText("내 장소 등록");
		
		locationregistration.setFont(PickupGameBase.tempfont);
		locationregistration.setLocation(btnloc);
		locationregistration.setSize(80,40);
		locationregistration.setBackground(Color.ORANGE);
		locationregistration.setBorder(BorderFactory.createBevelBorder(ABORT));
		add(locationregistration);
		
		//위치 버튼
		PickupGameBase base = new PickupGameBase();// 좌표 불러오기용
		add(new SubPage3_Locationbutton(base.getPointCourt1Hong(),new ImageIcon("res/locationbutton_S.png")));
		add(new SubPage3_Locationbutton(base.getPointCourt2Sung(),new ImageIcon("res/locationbutton_S.png")));
		add(new SubPage3_Locationbutton(base.getPointCourt3dong(),new ImageIcon("res/locationbutton_S.png")));
		add(new SubPage3_Locationbutton(base.getPointCourt4Catholic(),new ImageIcon("res/locationbutton_S.png")));
		
		//위치 클릭시 들어갈 패널
		add(new CourtPanel(base.pointCourt1Hong));
		
		
		//controlPanel 삽입 by 성배
		ControlPanel controlPanel = new ControlPanel();
		controlPanel.setBackground(RootFrame.MAIN_RED);
		controlPanel.setSize(600,100);
		controlPanel.setLocation(0,800);
		add(controlPanel);
		
		
		
		
		
		//농구장 위치 좌표찍기용
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			System.out.println("x : "+e.getX()+"y : "+e.getY());
			}
		});
		
		
	}
	
	
	
	
	
}


