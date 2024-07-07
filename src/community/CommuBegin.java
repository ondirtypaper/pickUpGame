package community;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CommuBegin extends JPanel {
	
	public CommuBegin() {
		
		ArrayList<CommuVO> commuList = new ArrayList<>();
		
		commuList.add(new CommuVO("아 한국은 왜이렇게 먹을게 없냐", "라고하면 댓글로 훈수가 들어올거라고 어쩌고저쩌고", "강태공"));
		//스캐너나 JOPtionPane 사용해서 추가가 가능한지 먼저 테스트 해야함
		
		
		setSize(600,900);
		setLayout(null);
		setBackground(Color.white);
		
		JPanel post = new JPanel();
		post.setSize(600, 600);
		post.setLocation(0, 200);
		post.setLayout(new FlowLayout());
		//게시물 목록에서 하나씩 게시물을 가져옴
		for(CommuVO commiList : commuList) {
			JLabel img = new JLabel(commiList.getTitle());
			img.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					//게시물 클릭 시 처리학 로직
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			// 'post' 패널에 게시물 레이블 추가
			post.add(img);
		}
		
		
		
		JPanel board = new JPanel();
		board.setSize(600, 200);
		board.setLocation(0, 0);
		board.setBackground(Color.GRAY);
		//랭킹 및 업적 우수자 창을 만들기 위해선 둘을 나눠야 함
		
		
		
		JPanel menu = new JPanel();
		menu.setSize(600, 100);
		menu.setLocation(0, 800);
		menu.setBackground(Color.lightGray);
		
		add(post);
		add(board);
		add(menu);
	}
	
}
