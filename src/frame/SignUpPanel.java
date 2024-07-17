package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dataManager.DataManager;

public class SignUpPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Font deafultFont = new Font("맑은 고딕",Font.BOLD,25);
	private ImageIcon img = new ImageIcon("res/joinus.png");
	
	public SignUpPanel(){
		setSize(RootFrame.FRAME_WIDTH,RootFrame.FRAME_HEIGHT);
		setLayout(null);
		setBackground(Color.white);
		final int defaultLabelWidth = 200;
		
		JLabel textHeading = new JLabel("");
		textHeading.setFont(deafultFont);
		textHeading.setSize(600,450);
		textHeading.setLocation(0,0);
		textHeading.setBackground(Color.BLACK);
		textHeading.setOpaque(true);
		ImageIcon imgFixed = new ImageIcon(img.getImage().getScaledInstance(600, 450, 0));
		textHeading.setIcon(imgFixed);
		
		
		
		JLabel textUserName = new JLabel("이름 : ");
		textUserName.setFont(deafultFont);
		textUserName.setSize(defaultLabelWidth,50);
		textUserName.setLocation(10,470);
		
		JTextField formUserName = new JTextField();
		formUserName.setSize(300,50);
		formUserName.setLocation(210,470);
		
		JLabel textEmail = new JLabel("이메일 : ");
		textEmail.setFont(deafultFont);
		textEmail.setSize(defaultLabelWidth,50);
		textEmail.setLocation(10,520);
		
		JTextField formEmail = new JTextField();
		formEmail.setSize(300,50);
		formEmail.setLocation(210,520);
		
		JLabel textPassWord = new JLabel("비밀번호 : ");
		textPassWord.setFont(deafultFont);
		textPassWord.setSize(defaultLabelWidth,50);
		textPassWord.setLocation(10,570);
		
		JPasswordField formPassWord = new JPasswordField();
		formPassWord.setSize(300,50);;
		formPassWord.setLocation(210, 570);
		
		JLabel textPassWordConfirm = new JLabel("비밀번호 확인 : ");
		textPassWordConfirm.setFont(deafultFont);
		textPassWordConfirm.setSize(defaultLabelWidth,50);
		textPassWordConfirm.setLocation(10, 620);
		
		JPasswordField formPassWordConfirm = new JPasswordField();
		formPassWordConfirm.setSize(300,50);;
		formPassWordConfirm.setLocation(210, 620);
		
		JLabel infoLabel = new JLabel("this is infoLabel");
		infoLabel.setSize(500,100);
		infoLabel.setBackground(Color.GRAY);
		infoLabel.setLocation(50,270);
		
		JLabel bottomLabel = new JLabel();
		bottomLabel.setSize(600,100);
		bottomLabel.setLocation(0, 750);
		
		JButton submitButton = new JButton(" 회원 가입 ");
		submitButton.setSize(150,50);
		submitButton.setLocation(10,10);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.data.addUser(formUserName.getText(), formEmail.getText(), formPassWord.getText());
			}
		});
		
		JButton backButton = new JButton(" 뒤로 가기 ");
		backButton.setSize(150,50);
		backButton.setLocation(420,10);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new InitPanel());
			}
		});
		
		bottomLabel.add(submitButton);
		bottomLabel.add(backButton);
		
		this.add(textHeading);
		this.add(textUserName);
		this.add(formUserName);
		this.add(textEmail);
		this.add(formEmail);
		this.add(textPassWord);
		this.add(formPassWord);
		this.add(textPassWordConfirm);
		this.add(formPassWordConfirm);
		this.add(infoLabel);
		this.add(bottomLabel); 
		
		
	}

}
