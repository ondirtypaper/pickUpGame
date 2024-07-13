package subPage3;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
