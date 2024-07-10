package community;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frame.ControlPanel;
import frame.RootFrame;

public class CommuBegin extends JPanel {

	 public CommuBegin() {
	    	List<CommuVO> commuList = SharedList.getSharedList();
	    	
	        setSize(600,900);
	        setLayout(null);
	        setBackground(Color.white);

	        JPanel post = new JPanel();
	        post.setSize(600, 600);
	        post.setLocation(0, 200);
	        post.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
	        post.setBackground(Color.white); // 배경색 설정

	        // 게시물 목록에서 하나씩 게시물을 가져옴
	        for (CommuVO i : commuList) {
	            JPanel postPanel = new JPanel();
	            postPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	            postPanel.setPreferredSize(new Dimension(580, 80));
	            postPanel.setBackground(Color.lightGray);
	            postPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

	            JLabel title = new JLabel(i.getTitle());
	            title.setFont(new Font("굴림", Font.BOLD, 16));

	            JLabel detail = new JLabel("<html>" + i.getDeTail() + "</html>");
	            detail.setFont(new Font("굴림", Font.PLAIN, 14));

	            postPanel.add(title);
	            postPanel.add(detail);

	            postPanel.addMouseListener(new MouseListener() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                	RootFrame.setFrameFor(new PostDetail(i));
	                }

	                @Override
	                public void mousePressed(MouseEvent e) {
	                }

	                @Override
	                public void mouseReleased(MouseEvent e) {
	                }

	                @Override
	                public void mouseEntered(MouseEvent e) {
	                }

	                @Override
	                public void mouseExited(MouseEvent e) {
	                }
	            });

	            post.add(postPanel);
	        }

	        JPanel board = new JPanel();
	        board.setSize(600, 200);
	        board.setLocation(0, 0);
	        board.setBackground(Color.GRAY);


	        //controlPanel 삽입 by 성배
      		ControlPanel controlPanel = new ControlPanel();
      		controlPanel.setBackground(RootFrame.MAIN_RED);
      		controlPanel.setSize(600,100);
      		controlPanel.setLocation(0,800);
      		
      		add(post);
	        add(board);
	        add(controlPanel);
	        
	        
	        
	        // PostMake로 가는 버튼
	        JButton bts = new JButton("새 글 쓰기");
	        bts.setBackground(Color.yellow);
	        bts.setFont(new Font("굴림", Font.BOLD, 20));
	        bts.setSize(200, 50);
	        bts.setLocation(200, 600);
	        add(bts);
	        
	        bts.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					RootFrame.setFrameFor(new PostMake());
					
				}
			});
	            
	   
	       
	    }

	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Community Board");
	        frame.setSize(600, 900);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(new CommuBegin());
	        frame.setVisible(true);
	   
	    
	    
	    
	    } 
	}

