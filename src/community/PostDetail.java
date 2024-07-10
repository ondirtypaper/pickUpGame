package community;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PostDetail extends JPanel{
	
	public PostDetail(CommuVO commuVO) {
	setBackground(new Color(0xFFD700));
	setLayout(null);
	setSize(600, 900);

	JLabel title = new JLabel(commuVO.getTitle());
	title.setFont(new Font("굴림", Font.BOLD, 20));
	title.setBounds(50, 100, 500, 50);
	add(title);

	JLabel detail = new JLabel("<html>" + commuVO.getDeTail() + "</html>");
	detail.setFont(new Font("굴림", Font.PLAIN, 14));
	detail.setBounds(50, 200, 500, 500);
	add(detail);

	JButton btnBack = new JButton("뒤로가기");
	btnBack.setBackground(Color.yellow);
	btnBack.setFont(new Font("굴림", Font.BOLD, 20));
	btnBack.setBounds(200, 780, 200, 50);
	btnBack.addActionListener(e -> CommuBase.getInstance(new CommuBegin()));
	add(btnBack);
	
	}
}