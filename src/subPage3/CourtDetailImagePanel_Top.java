package subPage3;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CourtDetailImagePanel_Top extends JPanel {
	
	//라벨 이미지를 바꿔주기 위한 라벨 객체 (기본은 이미지2로 설정)
		public static CourtDetailImageLabel DetailImgLabel=new CourtDetailImageLabel();
		
	public CourtDetailImagePanel_Top() {
		//패널 디자인
		setSize(600, 800);
		setLocation(0, 0);
		setBackground(Color.darkGray);
		setLayout(new FlowLayout(FlowLayout.CENTER, 7, 200));
		setVisible(true);
		
		//이미지 라벨 추가
		this.add(DetailImgLabel);
		
		
		//아래에 붙어있는 이미지 버튼 추가(생성자 int는 사진 구분 해줄 키)
		//선택된 이미지 버튼 테두리에 달아주고싶은데 아직 구현 못했음
		for (int i = 0; i < 6; i++) {
			CourtDetailmageButton button=new CourtDetailmageButton(i);
			if(CourtDetailImageLabel.changeLabelImg==i) {
				button.setBorder(new LineBorder(Color.BLACK, 2));
				button.setBorderPainted(true);
			}
			add(button);
		}
	}
}
