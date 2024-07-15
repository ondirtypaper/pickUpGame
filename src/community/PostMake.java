package community;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import frame.RootFrame;

public class PostMake extends JPanel{
	
	
	  public PostMake() {
	        // JPanel 기본 구조
	        setBackground(new Color(0xFFD700));
	        setLayout(null);
	        setSize(600, 900);

	        JPanel pm = new JPanel();
	        pm.setSize(600, 900);
	        pm.setLocation(0, 0);
	        pm.setLayout(null);
	        pm.setBackground(Color.white);

	        TextField title = new TextField("제목 ", 40);
	        title.setBounds(50, 100, 500, 50);
	        title.setBackground(Color.white);

	        JLabel writerLabel = new JLabel("작성자 :");
	        writerLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
	        writerLabel.setBounds(350, 180, 100, 30);
	        pm.add(writerLabel);

	        TextField writer = new TextField(40);
	        writer.setBounds(450, 180, 100, 30);
	        writer.setBackground(Color.white);

	        TextArea post = new TextArea("글 의 내용을 적어주세요");
	        post.setBounds(50, 230, 500, 500);

	        JButton btnCheck = new JButton("게시하기");
	        btnCheck.setBackground(Color.yellow);
	        btnCheck.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	        btnCheck.setSize(200, 50);
	        btnCheck.setLocation(320, 780);

	        JButton btnBack = new JButton("취소");
	        btnBack.setBackground(Color.yellow);
	        btnBack.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	        btnBack.setSize(200, 50);
	        btnBack.setLocation(70, 780);

	        btnCheck.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String a = title.getText();
	                String b = post.getText();
	                String pName = writer.getText();

	                SharedList.addToSharedList(a,b,pName);
	                RootFrame.setFrameFor(new CommuBegin());
	            }
	        });
	        
	        btnBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 RootFrame.setFrameFor(new CommuBegin());
					
				}
			});

	        
	        pm.add(title);
	        pm.add(writer);
	        pm.add(post);
	        pm.add(btnCheck);
	        pm.add(btnBack);
	        
	        add(pm);
	    }
	}
