package community;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
        setBackground(Color.white);

        
        
     // 상단 배너 패널 생성 및 위치 설정
        JPanel board = new JPanel();
        board.setSize(576, 180);
        board.setLocation(4, 0);
        board.setBackground(RootFrame.MAIN_RED);
        board.setLayout(new BoxLayout(board, BoxLayout.Y_AXIS));
        add(board);
        
        JLabel boardJLabel = new JLabel("새 리뷰 작성");
        boardJLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 50));
        boardJLabel.setHorizontalAlignment(JLabel.CENTER);
        boardJLabel.setOpaque(true);
        boardJLabel.setForeground(Color.white);
        boardJLabel.setBackground(new Color(255,0,0,0));
        add(boardJLabel);
        
     // 이미지가 들어갈 패널 만들기
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.X_AXIS));
        boardPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 가운데 정렬
        boardPanel.setBackground(RootFrame.MAIN_RED);
        
        // 이미지 로드
        ImageIcon img1 = new ImageIcon("res/ballbattle.png");
        ImageIcon img2 = new ImageIcon("res/dribble.png");
        ImageIcon img3 = new ImageIcon("res/dunk.png");
        ImageIcon img4 = new ImageIcon("res/dunkshoot.png");
        
       
        
        JLabel imgLabel1 = createScaledImageLabel(img1, 50, 50);
        JLabel imgLabel2 = createScaledImageLabel(img2, 50, 50);
        JLabel imgLabel3 = createScaledImageLabel(img3, 50, 50);
        JLabel imgLabel4 = createScaledImageLabel(img4, 50, 50);
       
        imgLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        imgLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        imgLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        imgLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //이미지 사이에 공간 만들기
        boardPanel.add(imgLabel1);
        boardPanel.add(Box.createVerticalStrut(10)); 
        boardPanel.add(imgLabel2);
        boardPanel.add(Box.createVerticalStrut(10)); 
        boardPanel.add(imgLabel3);
        boardPanel.add(Box.createVerticalStrut(10)); 
        boardPanel.add(imgLabel4);
        
        // board 패널에 컴포넌트 추가
        board.add(boardJLabel);
        board.add(Box.createVerticalStrut(20)); 
        board.add(boardPanel);
        
        
        

        JLabel writerLabel = new JLabel("작성자 :");
        writerLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        writerLabel.setBounds(390, 230, 60, 30);
        add(writerLabel);

        TextField writer = new TextField(40);
        writer.setBounds(450, 230, 100, 30);
        writer.setBackground(Color.white);
        
        JLabel titleLabel = new JLabel("제목 :");
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        titleLabel.setBounds(30, 195, 50, 20);
        add(titleLabel);

        TextField title = new TextField("", 40);
        title.setBounds(80, 190, 460, 30);
        title.setBackground(Color.white);

        TextArea post = new TextArea("글 의 내용을 적어주세요");
        post.setBounds(50, 280, 500, 450);

        JLabel scoreLabel = new JLabel("점수:");
        scoreLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        scoreLabel.setBounds(50, 740, 50, 30);
        add(scoreLabel);

        String[] scores = { "☆☆☆☆★", "☆☆☆★★", "☆☆★★★", "☆★★★★", "★★★★★" };
        JComboBox<String> scoreComboBox = new JComboBox<>(scores);
        scoreComboBox.setBounds(100, 740, 100, 30);
        add(scoreComboBox);

        JButton btnCheck = new JButton("게시하기");
        btnCheck.setBackground(Color.white);
        btnCheck.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnCheck.setSize(200, 50);
        btnCheck.setLocation(320, 780);

        JButton btnBack = new JButton("취소");
        btnBack.setBackground(Color.white);
        btnBack.setFont(new Font("맑은 고딕", Font.BOLD, 20));
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

        add(title);
        add(writer);
        add(post);
        add(btnCheck);
        add(btnBack);

        
    }
    private static JLabel createScaledImageLabel(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage(); 
        Image newImg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(newImg); 
        return new JLabel(scaledIcon);
    }
}