package subPage3;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//CourtDetailImagePanel 아래에 붙어있는 사진버튼
//현재 선택 되어 있는 사진에 외곽선 생기면 좋을듯

public class CourtDetailmageButton extends JButton {

	public CourtDetailmageButton(int imgButtonNum) {
		
		setSize(75, 42);
		setMargin(new Insets(3, 3, 3, 3));
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setVisible(true);
		
		//버튼에 넣을 이미지 주소 넣은 string 배열
		String[] courtImg = { "res/subPage3Img/CourtDetailImage2_75x42.png",
				"res/subPage3Img/CourtDetailImage3_75x42.png", "res/subPage3Img/CourtDetailImage4_75x42.png",
				"res/subPage3Img/CourtDetailImage5_75x42.png", "res/subPage3Img/CourtDetailImage6_75x42.png",
				"res/subPage3Img/CourtDetailImage7_75x42.png" };

		//이미지 아이콘에 주소 넣어서 생성
		ImageIcon[] courtImgIconBtn = new ImageIcon[6];
		for (int i = 0; i < courtImgIconBtn.length; i++) {
			courtImgIconBtn[i] = new ImageIcon(courtImg[i]);
		}
		
		//key 받아와서 어떤 사진 넣을지 설정
		switch (imgButtonNum) {
		case 0:
			setIcon(courtImgIconBtn[0]);
			break;
		case 1:
			setIcon(courtImgIconBtn[1]);
			break;
		case 2:
			setIcon(courtImgIconBtn[2]);
			break;
		case 3:
			setIcon(courtImgIconBtn[3]);
			break;
		case 4:
			setIcon(courtImgIconBtn[4]);
			break;
		case 5:
			setIcon(courtImgIconBtn[5]);
			break;

		default:
			break;
		}

		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//클릭시 라벨 이미지 변경하는 액션리스너
				switch (imgButtonNum) {
				case 0:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(0);
					break;
				case 1:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(1);
					break;
				case 2:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(2);
					break;
				case 3:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(3);
					break;
				case 4:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(4);
					break;
				case 5:
					CourtDetailImagePanel_Top.DetailImgLabel.labelChange(5);
					break;
				default:
					break;
				}

			}
		});
	}

}
