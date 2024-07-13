package community;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

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
        bts.setFont(new Font("굴림", Font.BOLD, 20));
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
        btsBack.setFont(new Font("굴림", Font.BOLD, 20));
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
            JPanel postPanel = new JPanel(new BorderLayout());
            postPanel.setPreferredSize(new Dimension(576, 40));
            postPanel.setBackground(Color.white);
            postPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

            JLabel title = new JLabel(i.getTitle());
            title.setFont(new Font("굴림", Font.PLAIN, 16));
            postPanel.add(title, BorderLayout.NORTH);

            JLabel writer = new JLabel("작성자: " + i.getWriter());
            writer.setFont(new Font("굴림", Font.BOLD, 10));
            postPanel.add(writer, BorderLayout.CENTER);

            postPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    RootFrame.setFrameFor(new ReviewDetail(i));
                }
                @Override
                public void mouseEntered(java.awt.event.MouseEvent arg0) {
                	title.setFont(new Font("굴림", Font.BOLD, 16));
                }
                
                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                	title.setFont(new Font("굴림", Font.PLAIN, 16));
                 
                }
                
                
            });

            post.add(postPanel);
        }

        JPanel board = new JPanel();
        board.setSize(576, 180);
        board.setLocation(4, 0);
        board.setBackground(new Color(0xff7f00));

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
}