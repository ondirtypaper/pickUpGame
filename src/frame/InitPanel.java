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

public class InitPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel inputPanel;
	private JLabel logoLabel;
	private JLabel inputLabel;
	private JButton logInBtn;
	private JButton signUpBtn;
	
	public InitPanel(){
		setSize(RootFrame.FRAME_WIDTH,RootFrame.FRAME_HEIGHT);
		setLayout(null);
		setBackground(Color.white);
		
		ImageIcon logo = new ImageIcon("res/Logo_PickUpGame.png");
		
		logoLabel = new JLabel(logo);
		logoLabel.setSize(600, 500);
		logoLabel.setLocation(0,0);
		
		inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setSize(600,400);
		inputPanel.setLocation(0,500);
		inputPanel.setBackground(Color.white);
		

		inputLabel = new JLabel();
		inputLabel.setSize(600,400);
		inputLabel.setLocation(0,0);
		//inputLabel.setOpaque(true);
		
		
		
		
		logInBtn = new JButton();
		//btn1.setText("Log In");
		ImageIcon icon_btn1 = new ImageIcon("res/logInIconText.png");
		ImageIcon icon_btn1_fixed = new ImageIcon(icon_btn1.getImage().getScaledInstance(260, 80, 3));
		logInBtn.setIcon(icon_btn1_fixed);
		logInBtn.setFocusable(false);
		logInBtn.setBackground(Color.white);
		logInBtn.setBorder(null);
		logInBtn.setSize(300,100);
		logInBtn.setLocation(150,0);
		logInBtn.setFont(new Font("Sans-serif",Font.BOLD,25));
		logInBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//RootFrame.getInstance(new LogInPanel());
				getLogInPanel();
			}
		});
		
		JButton signUpBtn = new JButton();
		ImageIcon icon_btn2 = new ImageIcon("res/signupIconText.png");
		ImageIcon icon_btn2_fixed = new ImageIcon(icon_btn2.getImage().getScaledInstance(280, 90, 3));
		signUpBtn.setIcon(icon_btn2_fixed);
		//btn2.setText("Sign Up");
		signUpBtn.setSize(300,100);
		signUpBtn.setBackground(Color.white);
		signUpBtn.setBorder(null);
		signUpBtn.setLocation(150,160);
		signUpBtn.setFocusable(false);
		signUpBtn.setFont(new Font("Sans-serif",Font.BOLD,25));
		
		signUpBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new SignUpPanel());
				
			}
		});
		
		inputLabel.add(logInBtn);
		inputLabel.add(signUpBtn);
		
		inputPanel.add(inputLabel);
		
		add(logoLabel);
		add(inputPanel);
		
	}
	
	public void getLogInPanel() {
		inputPanel.removeAll();
		
		JLabel msgLabel = new JLabel("이메일과 비밀번호를 입력하여 주세요");
		msgLabel.setLocation(150,0);
		msgLabel.setSize(500,50);
		msgLabel.setBackground(Color.white);
		msgLabel.setOpaque(true);
		
		inputPanel.add(msgLabel);
		
		JLabel inputLabel = new JLabel();
		inputLabel.setLocation(50,50);
		inputLabel.setSize(500,300);
		inputLabel.setBackground(Color.white);
		inputLabel.setOpaque(true);
		
		//JTextField formEmail = new JTextField("a@test.com");
		JTextField formEmail = new JTextField("");
		formEmail.setSize(300,50);
		formEmail.setLocation(100,50);
		
		//JPasswordField formPassWord = new JPasswordField("1234pass!");
		JPasswordField formPassWord = new JPasswordField("");
		formPassWord.setSize(300,50);
		formPassWord.setLocation(100, 110);
		
		JButton btn1 = new JButton();
		btn1.setSize(300, 100);
		btn1.setLocation(100,180);
		btn1.setText("pick up your game");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("InitPanel : " + formEmail.getText() + " Log-in request.");
				// TODO : Learn about JPasswordField.getPassword()
				int logInMsg = RootFrame.data.logInRequest(formEmail.getText(), formPassWord.getText());
				if(logInMsg >= 0) {
					// RootFrame.userData.LOG_IN_SUCCESS
					System.out.println("InitPanel : Log-in Success. " + formEmail.getText());
					// TODO : RootFrame에 로그인 성공 알림 
					RootFrame.setFrameFor(new FirstPagePanel());
					RootFrame.setCurrentUser(logInMsg);
				}
				else {
					System.out.println("InitPanel : Log-in request denied - 로그인 실패 에러코드 : " + logInMsg );
					switch(logInMsg) {
					case 1:
						System.out.println("Password 불일치");
						msgLabel.setText("비밀번호가 일치하지 않습니다");
						break;
					case 2:
						System.out.println("Email 불일치");
						msgLabel.setText("가입되지 않은 이메일입니다.");
						break;
					case 3:
						System.out.println("Empty User List");
						msgLabel.setText("회원 정보를 불러올 수 없습니다.");
						break;
					default:
						System.out.println("Wrong logInMsg");
						msgLabel.setText("알 수 없는 이유로 로그인에 실패하였습니다.");
					}
				}
			}
		});
		
		JButton backBtn = new JButton();
		backBtn.setSize(50, 100);
		backBtn.setLocation(420, 180);
		backBtn.setText("<");
		backBtn.setFocusable(false);
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new InitPanel());
				
			}
		});
		
		inputLabel.add(formEmail);
		inputLabel.add(formPassWord);
		inputLabel.add(btn1);
		inputLabel.add(backBtn);
		
		inputPanel.add(inputLabel);
		
		inputPanel.revalidate();
		inputPanel.repaint();

	}
	
}
