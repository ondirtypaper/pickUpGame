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

	

	

	public SubPage3MainPanel(){

	//public SubPage3MainPanel(SubPage3Frame temp) {

		//SubPage3Frame.temp = temp;
		// 메인 패널 디자인
		setBounds(0, 0, 600, 900);
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);
		
		add(new SubPage3MainPanel_Top());
		

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
