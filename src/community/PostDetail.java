package community;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import frame.RootFrame;



public class PostDetail extends JPanel {
    public PostDetail(CommuVO commuVO) {
        setBackground(Color.white);
        setLayout(null);
        setSize(600, 900);
        
        
        // 상단 배너 패널 생성 및 위치 설정
        JPanel board = new JPanel();
        board.setSize(576, 180);
        board.setLocation(4, 0);
        board.setBackground(RootFrame.MAIN_RED);
        board.setLayout(new BoxLayout(board, BoxLayout.Y_AXIS));
        add(board);
        
        // 상단 배너 자유게시판 글자
        JLabel boardJLabel = new JLabel("게시글");
        boardJLabel.setForeground(Color.white);
        boardJLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 50));
        boardJLabel.setSize(288,90);
        boardJLabel.setLocation(160,45);
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

        JLabel title = new JLabel(commuVO.getTitle());
        title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        title.setBounds(50, 210, 500, 30);
        add(title);

        JLabel writer = new JLabel("작성자: " + commuVO.getpName());
        writer.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
        writer.setBounds(50, 240, 500, 20);
        add(writer);

        JTextArea detail = new JTextArea(commuVO.getDeTail());
        detail.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        detail.setLineWrap(true);
        detail.setWrapStyleWord(true);
        detail.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detail);
        scrollPane.setBounds(50, 260, 500, 500);
        add(scrollPane);

        JButton btnBack = new JButton("뒤로가기");
        btnBack.setBackground(Color.white);
        btnBack.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnBack.setBounds(200, 780, 200, 50);
        btnBack.addActionListener(e -> RootFrame.setFrameFor(new CommuBegin()));
        add(btnBack);
    }

    private static JLabel createScaledImageLabel(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage();  
        Image newImg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(newImg); 
        return new JLabel(scaledIcon);
    }

}