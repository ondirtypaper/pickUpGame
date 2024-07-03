package frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FirstPagePanel extends JPanel implements ActionListener {

	JPanel mapPanel;
	JLabel popUpLabel;
	JLabel userLabel;
	int x;
	int y;
	Timer timer;
	int timerDelay = 75;
	int raderRadius = 75;
	int animationCount = 0;

	ArrayList<mapItem> list;

	private class mapItem {
		int id;
		int x;
		int y;
		int itemType;

		public mapItem(int id, int x, int y, int itemType) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.itemType = itemType;
		}
	}

	FirstPagePanel() {
		setBackground(Color.white);
		setLayout(null);
		setSize(600, 800);

		mapPanel = new JPanel();
		mapPanel.setBackground(Color.LIGHT_GRAY);
		mapPanel.setOpaque(false);
		mapPanel.setSize(500, 500);
		mapPanel.setLocation(50, 50);

		ImageIcon myFace = new ImageIcon("res/icons8-human-head-48.png");
		userLabel = new JLabel(myFace);
		// userLabel.setText("me!");
		userLabel.setSize(100, 100);
		userLabel.setOpaque(true);
		userLabel.setLocation(250, 250);

		mapPanel.add(userLabel);

		popUpLabel = new JLabel("  주변 경기장 정보를 탐색중입니다.");
		popUpLabel.setBackground(Color.gray);
		popUpLabel.setOpaque(true);
		popUpLabel.setSize(600, 200);
		popUpLabel.setLocation(0, 600);

		this.add(mapPanel);
		this.add(userLabel);
		this.add(popUpLabel);

		timer = new Timer(500, this);
		timer.start();

	}

	private void getCenterGPS() {
		// 사용자의 현재 위치를 기기로부터 가져오는 method
		x = 0;
		y = 0;
		// 사용자 현재 위치 [0,0]으로 가정
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		// TODO: animate circles
		Graphics2D g2d = (Graphics2D) g;
		raderRadius = 75;
		g2d.setColor(Color.GRAY);
		for (int i = 0; i < 10; i++) {
			raderRadius = raderRadius + (i * 10) + (animationCount * 5); // default : 75 ~ 165
			g2d.drawOval(300 - raderRadius, 300 - raderRadius, 2 * raderRadius, 2 * raderRadius);
			
		}
		animationCount++;
		//System.out.println(animationCount++);
		if(animationCount >= 10) {
			animationCount = 0;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//System.out.println("Who called action?" + e.getSource());

		repaint();
	}

}
