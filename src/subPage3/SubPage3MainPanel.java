package subPage3;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import dataManager.ActiveCourt;
import frame.ControlPanel;
import frame.RootFrame;

//할 거 정리 
//1.디테일이미지 버튼 선택된 이미지 버튼 테두리에 표시 해주기
//2. 별점 연결
//3. 마이플레이스 db만들면 연결
//4. 리뷰 페이지 가는거 연결
//5. 마이플레이스 수정 버튼 생성 및 gui조정





//제일 아래에 있는 메인 패널
//지도가 그려져 있는 탑패널과 컨트롤패널이 붙어있음
//코트 데이터 리스트도 가지고 있음
public class SubPage3MainPanel extends JPanel {

	public static ArrayList<ActiveCourt> cList; // 코트 데이터 리스트(메인에서 불러오고 data폴더에 저장)

	public SubPage3MainPanel() {
		//실행 시 코트 데이터 불러오고 clist에 저장
		RootFrame.updateActiveCourt();
		cList = RootFrame.aroundC;
		
		// 메인 패널 디자인
		setBounds(0, 0, 600, 900);
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);
		
		//toppanel 추가
		add(SubPage3MainPanel_Top.topPanel);
		

		// 컨트롤 패널
		ControlPanel controlPanel = new ControlPanel();
		controlPanel.setBackground(RootFrame.MAIN_RED);
		controlPanel.setSize(600, 100);
		controlPanel.setLocation(0, 800);
		this.add(controlPanel);
	}

}
