package subPage3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;

import javax.swing.border.Border;
import javax.swing.*;
public class CourtPanel extends JPanel {

	boolean push;
	
	
	public CourtPanel(Point p) {
		setLocation(p);
		setSize(200, 200);
		setLayout(null);
		setBackground(Color.white);
		//클릭 전에는 안보이게 할 예정
		push=true;
		setVisible(push);
		
		//왼쪽 사진 추가,몇명 있는지 갈 예정인지 버튼(시간추가되면 좋음) 간략한 코트 textarea 더보기 리뷰정보
		//야간 불 켜주는지 정보
		JLabel courtName=new JLabel("<html><body>홍익대학교 사범대학<br>부속고등학교 농구장</body></html>");
		courtName.setFont(new Font("Serif",Font.BOLD,12));
		courtName.setSize(150,50);
		courtName.setLocation(30,0);
		courtName.setHorizontalAlignment(JLabel.RIGHT);
		add(courtName);
		
		ImageIcon courtImg=new ImageIcon();
		JPanel courtImage=new JPanel();
		
		JTextArea courtinfo=new JTextArea();
		
		
	}
	
}
