package community;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import frame.ControlPanel;
import frame.RootFrame;

// Commu 패키지 참고해서 작성
public class ReviewBegin extends JPanel {
    public ReviewBegin() {
        List<ReviewVO> reList = SharedReview.getreList();

        setSize(600, 900);
        setLayout(null);
        setBackground(Color.white);

        // 메뉴 패널 생성 및 위치 설정
        JPanel menu = new JPanel();
        menu.setSize(576, 40);
        menu.setLocation(4, 740);
        menu.setLayout(new GridLayout(1, 2, 10, 10)); // 버튼이 나란히 배치될 수 있도록 설정

        // ReviewMake로 가는 버튼
        JButton bts = new JButton("새로운 리뷰");
        bts.setBackground(Color.white);
        bts.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        bts.setPreferredSize(new Dimension(176, 50));
        menu.add(bts);

        bts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootFrame.setFrameFor(new ReviewMake());
            }
        });

        // CommuBegin으로 가는 버튼
        JButton btsBack = new JButton("게시판으로 이동하기");
        btsBack.setBackground(Color.white);
        btsBack.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btsBack.setPreferredSize(new Dimension(176, 50));
        menu.add(btsBack);

        btsBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootFrame.setFrameFor(new CommuBegin());
            }
        });

        // 게시판 패널 생성 및 위치 설정
        JPanel post = new JPanel();
        post.setSize(576, 600);
        post.setLocation(0, 200);
        post.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        post.setBackground(new Color(255, 0, 0, 0)); // 배경색 설정

        for (ReviewVO i : reList) {
            JPanel postPanel = new JPanel();
            postPanel.setPreferredSize(new Dimension(576, 40));
            postPanel.setBackground(Color.white);
            postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS)); // 세로로 배치

            JLabel title = new JLabel(i.getTitle());
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            title.setFont(new Font("맑은 고딕", Font.BOLD, 16));
            postPanel.add(title, BorderLayout.NORTH);

            JLabel writer = new JLabel("작성자: " + i.getWriter());
            writer.setAlignmentX(Component.CENTER_ALIGNMENT);
            writer.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
            postPanel.add(writer, BorderLayout.CENTER);

            postPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
            
            postPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    RootFrame.setFrameFor(new ReviewDetail(i));
                }
                @Override
                public void mouseEntered(java.awt.event.MouseEvent arg0) {
                	title.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
                }
                
                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                	title.setFont(new Font("맑은 고딕", Font.BOLD, 16));
                 
                }
                
                
            });

            post.add(postPanel);
        }

        // 상단 배너 패널 생성 및 위치 설정
        JPanel board = new JPanel();
        board.setSize(576, 180);
        board.setLocation(4, 0);
        board.setBackground(RootFrame.MAIN_RED);
        board.setLayout(new BoxLayout(board, BoxLayout.Y_AXIS));
        
     // 상단 배너 코트 리뷰 글자
        JLabel boardJLabel = new JLabel("코트 리뷰");
        boardJLabel.setForeground(Color.white);
        boardJLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 50));
        boardJLabel.setSize(288,90);
        boardJLabel.setLocation(185,45);
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

      //controlPanel 삽입 by 성배
  		ControlPanel controlPanel = new ControlPanel();
  		controlPanel.setBackground(RootFrame.MAIN_RED);
  		controlPanel.setSize(600,100);
  		controlPanel.setLocation(0,800);
  		
  		add(post);
        add(board);
        add(controlPanel);
        add(menu);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Community Board");
        frame.setSize(600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ReviewBegin());
        frame.setVisible(true);
    }
    
    private static JLabel createScaledImageLabel(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage(); 
        Image newImg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(newImg);  
        return new JLabel(scaledIcon);
    }

    
}