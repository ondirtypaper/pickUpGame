package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InitPanel(){
		setSize(RootFrame.FRAME_WIDTH,RootFrame.FRAME_HEIGHT);
		setLayout(null);
		setBackground(Color.white);
		
		ImageIcon logo = new ImageIcon("res/Logo_PickUpGame.png");
		
		JLabel label1 = new JLabel(logo);
		label1.setSize(600, 500);
		label1.setLocation(0,0);
		
		JLabel label2 = new JLabel();
		label2.setSize(600,400);
		label2.setLocation(0,500);
		label2.setBackground(Color.gray);
		
		JButton btn1 = new JButton();
		//btn1.setText("Log In");
		ImageIcon icon_btn1 = new ImageIcon("res/logInIconText.png");
		ImageIcon icon_btn1_fixed = new ImageIcon(icon_btn1.getImage().getScaledInstance(260, 80, 3));
		btn1.setIcon(icon_btn1_fixed);
		btn1.setFocusable(false);
		btn1.setBackground(Color.white);
		btn1.setBorder(null);
		btn1.setSize(300,100);
		btn1.setLocation(150,0);
		btn1.setFont(new Font("Sans-serif",Font.BOLD,25));
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.getInstance(new FirstPagePanel());
				
			}
		});
		
		JButton btn2 = new JButton();
		ImageIcon icon_btn2 = new ImageIcon("res/signupIconText.png");
		ImageIcon icon_btn2_fixed = new ImageIcon(icon_btn2.getImage().getScaledInstance(280, 90, 3));
		btn2.setIcon(icon_btn2_fixed);
		//btn2.setText("Sign Up");
		btn2.setSize(300,100);
		btn2.setBackground(Color.white);
		btn2.setBorder(null);
		btn2.setLocation(150,160);
		btn2.setFocusable(false);
		btn2.setFont(new Font("Sans-serif",Font.BOLD,25));
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.getInstance(new SignUpPanel());
				
			}
		});
		
		label2.add(btn1);
		label2.add(btn2);
		
		add(label1);
		add(label2);
		
	}
	
}
