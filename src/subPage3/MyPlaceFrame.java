package subPage3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dataManager.Position;
import frame.RootFrame;

//내 장소 이름 등록 뒤에 나오게 할 프레임(장소명 출력,삭제버튼,수정버튼(미구현),위치 정해주기(미구현))
public class MyPlaceFrame extends JFrame {

	
	public MyPlaceFrame(int id,Position p,String name) {
		setSize(300, 100);
		BorderLayout borderLayout=new BorderLayout();
		setLayout(borderLayout);
		setBackground(Color.white);
		setLocation((int)p.getX()+675,(int)p.getY()+110);
		
		//프레임이 화면 가운데에 뜨게 하기()안에는 컴포넌트,사이즈 고정
		setResizable(false);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//장소 이름
		JLabel outputName=new JLabel("");
		outputName.setFont(new Font("맑은고딕",Font.BOLD , 18));
		outputName.setLocation(50, 0);
		outputName.setSize(280,80);
		outputName.setText(name);
		outputName.setHorizontalAlignment(SwingConstants.CENTER);
		outputName.setVerticalAlignment(SwingConstants.CENTER);
		outputName.setHorizontalTextPosition(SwingConstants.CENTER);
		outputName.setVisible(true);
		
		add(outputName,BorderLayout.CENTER);
		
		//삭제 버튼
		JButton delete=new JButton("장소 삭제");
		delete.setSize(20,20);
//		delete.setBounds(250, 0, 100, 50);
		delete.setBackground(Color.orange);
		delete.setVisible(true);
		
		//삭제 액션리스너
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SubPage3MainPanel_Top.topPanel.removeMyPlace(id,RootFrame.cUser.getEmail());
				dispose();
				
			}
		});
		add(delete,BorderLayout.EAST);
		
		
		
	}
	
}
