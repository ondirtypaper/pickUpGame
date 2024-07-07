package subPage3;

import java.awt.Color;

import javax.swing.*;

public class SubPage3Frame extends JFrame {

	public static SubPage3Frame temp;
	
	public SubPage3Frame(JPanel e) {
		setTitle("pickupgame");
		setBounds(700,50,600,900);
		setLayout(null);
		getContentPane().setBackground(Color.orange);//나중에 버튼 달면 없애주기(프레임 배경색)
		
		add(e);
		
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		new SubPage3Frame(new SubPage3Panel());
		
	}
	
	
		
		
}
