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

	public InitPanel(){
		setSize(600,900);
		setLayout(null);
		setBackground(Color.white);
		
		ImageIcon logo = new ImageIcon("res/Logo_PickUpGame.png");
		
		JLabel label1 = new JLabel(logo);
		label1.setSize(600, 600);
		label1.setLocation(0,0);
		
		JLabel label2 = new JLabel();
		label2.setSize(600,300);
		label2.setLocation(0,600);
		label2.setBackground(Color.gray);
		
		JButton btn1 = new JButton();
		btn1.setText("Log In");
		ImageIcon icon_btn1 = new ImageIcon("res/icons8-dribbble-48.png");
		btn1.setIcon(icon_btn1);
		btn1.setFocusable(false);
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
		btn2.setText("Sign Up");
		btn2.setSize(300,100);
		btn2.setLocation(150,110);
		btn2.setFocusable(false);
		btn1.setFont(new Font("Sans-serif",Font.BOLD,25));
		
		label2.add(btn1);
		label2.add(btn2);
		
		add(label1);
		add(label2);
		
	}
	
}
