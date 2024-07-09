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

public class MoreImgPanel extends JPanel {

	public static MoreImgPanel moreImg;
	public static CourtDetailImageLabel cuLa=new CourtDetailImageLabel("이미지2");
	
	public static void labelChange(ImageIcon icon) {
		
		cuLa.setIcon(icon);
		
	}
	

	public MoreImgPanel() {
		//SubPage3Frame.temp = temp;
		setLayout(null);
		setSize(600,900);
		JPanel innerPanel = new JPanel();
		
		
		innerPanel.setSize(600, 800);
		innerPanel.setLocation(0, 0);
		innerPanel.setBackground(Color.darkGray);
		innerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 200));
		innerPanel.setVisible(true);
		// 위에 크게 사진 띄우고 아래에 작은 사진들로 전환버튼 클릭시 효과있으면 좋을듯
		String[] courtImg= {"res/CourtDetailImage2_75x42.png",
				"res/CourtDetailImage3_75x42.png","res/CourtDetailImage4_75x42.png","res/CourtDetailImage5_75x42.png",
				"res/CourtDetailImage6_75x42.png","res/CourtDetailImage7_75x42.png"};
		ImageIcon[] courtImgIcon = new ImageIcon[6];
		for (int i = 0; i < courtImgIcon.length; i++) {
			courtImgIcon[i]=new ImageIcon(courtImg[i]);
		}
		innerPanel.add(cuLa);
		
		
		
		innerPanel.add(new CourtDetailmageButton(courtImgIcon[0],"이미지2"));
		innerPanel.add(new CourtDetailmageButton(courtImgIcon[1],"이미지3"));
		innerPanel.add(new CourtDetailmageButton(courtImgIcon[2],"이미지4"));
		innerPanel.add(new CourtDetailmageButton(courtImgIcon[3],"이미지5"));
		innerPanel.add(new CourtDetailmageButton(courtImgIcon[4],"이미지6"));
		innerPanel.add(new CourtDetailmageButton(courtImgIcon[5],"이미지7"));
		
//		JButton courtDetailImg2 = new JButton(courImg2);
//		
//		JButton courtDetailImg3 = new JButton(courImg3);
//		courtDetailImg3.setSize(75, 42);
//		courtDetailImg3.setBorderPainted(false);
//		courtDetailImg3.setContentAreaFilled(false);
//		courtDetailImg3.setFocusPainted(false);
//		courtDetailImg3.setMargin(new Insets(3, 3, 3, 5));
//		JButton courtDetailImg4 = new JButton(courImg4);
//		courtDetailImg4.setSize(75, 42);
//		courtDetailImg4.setBorderPainted(false);
//		courtDetailImg4.setContentAreaFilled(false);
//		courtDetailImg4.setFocusPainted(false);
//		courtDetailImg4.setMargin(new Insets(3, 5, 3, 5));
//		JButton courtDetailImg5 = new JButton(courImg5);
//		courtDetailImg5.setSize(75, 42);
//		courtDetailImg5.setBorderPainted(false);
//		courtDetailImg5.setContentAreaFilled(false);
//		courtDetailImg5.setFocusPainted(false);
//		courtDetailImg5.setMargin(new Insets(3, 5, 3, 5));
//		JButton courtDetailImg6 = new JButton(courImg6);
//		courtDetailImg6.setSize(75, 42);
//		courtDetailImg6.setBorderPainted(false);
//		courtDetailImg6.setContentAreaFilled(false);
//		courtDetailImg6.setFocusPainted(false);
//		courtDetailImg6.setMargin(new Insets(3, 5, 3, 5));
//		JButton courtDetailImg7 = new JButton(courImg7);
//		courtDetailImg7.setSize(75, 42);
//		courtDetailImg7.setBorderPainted(false);
//		courtDetailImg7.setContentAreaFilled(false);
//		courtDetailImg7.setFocusPainted(false);
//		courtDetailImg7.setMargin(new Insets(3, 5, 3, 5));
//

//		add(courtDetailImg2);
//		add(courtDetailImg3);
//		add(courtDetailImg4);
//		add(courtDetailImg5);
//		add(courtDetailImg6);
//		add(courtDetailImg7);
		
		this.add(innerPanel);
		// Control panel 추가 by 성배
		ControlPanel controlPanel = new ControlPanel();
		controlPanel.setBackground(RootFrame.MAIN_RED);
		controlPanel.setSize(600,100);
		controlPanel.setLocation(0,800);
		
		
		this.add(controlPanel);
	}

}
