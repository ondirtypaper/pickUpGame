package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import community.CommuBegin;
import membership.MemberBase;
import subPage3.*;

public class ControlPanel extends JPanel{

	JButton backBtn;
	
	JButton settingBtn;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControlPanel(){
		this.setLayout(null);
				
		backBtn = new JButton();
		backBtn.setSize(50, 50);
		backBtn.setLocation(10, 5);
		backBtn.setText("<");
		backBtn.setFocusable(false);
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new InitPanel());
				
			}
		});
		
		JButton btn1 = new JButton();
		btn1.setSize(107,50);
		btn1.setText(" 코트 ");
		btn1.setLocation(65,5);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new SubPage3MainPanel());
			}
		});
		
		JButton btn2 = new JButton();
		btn2.setSize(107,50);
		btn2.setText(" 커뮤니티 ");
		btn2.setLocation(177,5);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new CommuBegin());
			}
		});
		
		JButton btn3 = new JButton();
		btn3.setSize(107,50);
		btn3.setText(" Pick Up ");
		btn3.setLocation(289,5);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new FirstPagePanel());
			}
		});
		
//		JButton btn4 = new JButton();
//		btn4.setSize(85,50);
//		btn4.setText(" Page 3 ");
//		btn4.setLocation(335,5);
//		
		JButton btn5 = new JButton();
		btn5.setSize(105,50);
		btn5.setText(" 회원관리 ");
		btn5.setLocation(401,5);
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                MemberBase.getInstance().setVisible(true);
		            }
		        });
			}
		});
		settingBtn = new JButton();
		settingBtn.setSize(65, 50);
		settingBtn.setLocation(512, 5);
		settingBtn.setText("...");
		settingBtn.setFocusable(false);
		settingBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new InitPanel());
				
			}
		});
		
		this.add(backBtn);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		//this.add(btn4);
		this.add(btn5);
		this.add(settingBtn);
	}
}
