package subPage3;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Temporary_Mousepoint extends JFrame {

	public Temporary_Mousepoint(JPanel e) {
		setTitle("pickupgame");
		setBounds(700,50,600,900);
		setLayout(null);
		getContentPane().setBackground(Color.orange);//나중에 버튼 달면 없애주기(프레임 배경색)
		
		add(e);
		
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
//	public static void main(String[] args) {
//		
//		new SubPage3Frame(new SubPage3Panel());
//		
//	}
	
}
