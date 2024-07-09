package subPage3;

import java.awt.Color;


import javax.swing.*;


//임시 프레임 테스트용 실행 메인도 이 페이지에 있음
public class SubPage3Frame extends JFrame {

	public static SubPage3Frame temp;
	public SubPage3MainPanel mainPanel=null;
	public MoreImgPanel moreImg=null;
	
	
	public SubPage3Frame() {
		setTitle("pickupgame");
		setBounds(700, 50, 600, 900);
		setLayout(null);
		getContentPane().setBackground(Color.orange);// 나중에 버튼 달면 없애주기(프레임 배경색)
		setVisible(true);


		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	//패널 바꿔주는 메서드
//	public void panelChange(String panelName) {
//		if (panelName.equals("MainPanel")) {
//			
//			temp.getContentPane().removeAll();
//			temp.getContentPane().add(new SubPage3MainPanel());
//			temp.revalidate();
//			temp.repaint();
//		} else if (panelName.equals("moreImg")) {
//			temp.getContentPane().removeAll();
//			temp.getContentPane().add(new MoreImgPanel(temp));
//			temp.revalidate();
//			temp.repaint();
//		}

	//}

	// 메인 실행
//	public static void main(String[] args) {
//
//		temp=new SubPage3Frame();
//		temp.panelChange("MainPanel");
//		
//
//	}

}
