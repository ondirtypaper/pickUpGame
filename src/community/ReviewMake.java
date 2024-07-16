package community;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import frame.RootFrame;

public class ReviewMake extends JPanel {
    public ReviewMake() {
        // JPanel 기본 구조
        setBackground(new Color(0xFFD700));
        setLayout(null);
        setSize(600, 900);

        JPanel pm = new JPanel();
        pm.setSize(600, 900);
        pm.setLocation(0, 0);
        pm.setLayout(null);
        pm.setBackground(Color.white);
        
        JLabel pt = new JLabel("새 리뷰 작성");
        pt.setSize(576, 100);
        pt.setLocation(12, 0);
        pt.setFont(new Font("굴림", Font.PLAIN, 18));
        pt.setHorizontalAlignment(JLabel.CENTER);
        pt.setOpaque(true);
        pt.setForeground(Color.white);
        pt.setBackground(RootFrame.MAIN_RED);

        JLabel writerLabel = new JLabel("작성자 :");
        writerLabel.setFont(new Font("굴림", Font.PLAIN, 14));
        writerLabel.setBounds(390, 180, 60, 30);
        pm.add(writerLabel);

        TextField writer = new TextField(40);
        writer.setBounds(450, 180, 100, 30);
        writer.setBackground(Color.white);
        
        JLabel titleLabel = new JLabel("제목 :");
        titleLabel.setFont(new Font("굴림", Font.PLAIN, 14));
        titleLabel.setBounds(30, 100, 50, 30);
        pm.add(titleLabel);

        TextField title = new TextField("", 40);
        title.setBounds(80, 100, 460, 50);
        title.setBackground(Color.white);

        TextArea post = new TextArea("글 의 내용을 적어주세요");
        post.setBounds(50, 230, 500, 500);

        JLabel scoreLabel = new JLabel("점수:");
        scoreLabel.setFont(new Font("굴림", Font.PLAIN, 14));
        scoreLabel.setBounds(50, 740, 50, 30);
        pm.add(scoreLabel);

        String[] scores = { "☆☆☆☆★", "☆☆☆★★", "☆☆★★★", "☆★★★★", "★★★★★" };
        JComboBox<String> scoreComboBox = new JComboBox<>(scores);
        scoreComboBox.setBounds(100, 740, 100, 30);
        pm.add(scoreComboBox);

        JButton btnCheck = new JButton("게시하기");
        btnCheck.setBackground(Color.white);
        btnCheck.setFont(new Font("굴림", Font.BOLD, 20));
        btnCheck.setSize(200, 50);
        btnCheck.setLocation(320, 780);

        JButton btnBack = new JButton("취소");
        btnBack.setBackground(Color.white);
        btnBack.setFont(new Font("굴림", Font.BOLD, 20));
        btnBack.setSize(200, 50);
        btnBack.setLocation(70, 780);

        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = title.getText();
                String b = post.getText();
                String w = writer.getText();
                int score = scoreComboBox.getSelectedIndex() + 1;

                SharedReview.addToreList(a, b, w, score);
                RootFrame.setFrameFor(new ReviewBegin());
            }
        });
        
        btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RootFrame.setFrameFor(new ReviewBegin());
			}
		});

        pm.add(title);
        pm.add(writer);
        pm.add(post);
        pm.add(btnCheck);
        pm.add(btnBack);
        pm.add(pt);

        add(pm);
    }
}