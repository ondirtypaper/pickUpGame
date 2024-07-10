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

public class CourtDetailImagePanel extends JPanel {

	public static CourtDetailImagePanel moreImg;
	public static CourtDetailImageLabel cuLa=new CourtDetailImageLabel("이미지2");
	
	public static void labelChange(ImageIcon icon) {
		
		cuLa.setIcon(icon);
		
	}
	

	public CourtDetailImagePanel() {
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
		
		
		this.add(innerPanel);
		// Control panel 추가 by 성배
		ControlPanel controlPanel = new ControlPanel();
		controlPanel.setBackground(RootFrame.MAIN_RED);
		controlPanel.setSize(600,100);
		controlPanel.setLocation(0,800);
		
		
		this.add(controlPanel);
	}

}
