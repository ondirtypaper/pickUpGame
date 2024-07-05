package frame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInPanel extends JPanel{

	LogInPanel(){
		setSize(RootFrame.FRAME_WIDTH,400);
		setLayout(null);
		setBackground(Color.white);
		
		JLabel msgLabel = new JLabel("this is label for msg");
		msgLabel.setLocation(50,50);
		msgLabel.setSize(500,50);
		msgLabel.setBackground(Color.gray);
		msgLabel.setOpaque(true);
		
		add(msgLabel);
		
		JLabel inputLabel = new JLabel();
		inputLabel.setLocation(50,100);
		inputLabel.setSize(500,350);
		inputLabel.setBackground(Color.gray);
		inputLabel.setOpaque(true);
		
		JTextField formEmail = new JTextField();
		formEmail.setSize(300,50);
		formEmail.setLocation(100,50);
		
		JPasswordField formPassWord = new JPasswordField();
		formPassWord.setSize(300,50);
		formPassWord.setLocation(100, 110);
		
		inputLabel.add(formEmail);
		inputLabel.add(formPassWord);
		
		add(inputLabel);
	}
}
