package frame;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FirstPagePanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mapPanel;
	JLabel popUpLabel;
	JLabel userLabel;
	ControlPanel controlPanel;
	ImageIcon ballIcon = new ImageIcon("res/justABall.png");
	
	MapItem[] itemLabels = new MapItem[10];
	int x;
	int y;
	Timer timer;
	int timerDelay = 75;
	int raderRadius = 75;
	int animationCount = 0;
	int itemPopCount = 0;

	ArrayList<MapItem> list;

	

	FirstPagePanel() {
		setBackground(Color.white);
		setLayout(null);
		setSize(600, 900);

		mapPanel = new JPanel();
		mapPanel.setBackground(Color.LIGHT_GRAY);
		mapPanel.setOpaque(false);
		mapPanel.setSize(500, 500);
		mapPanel.setLocation(50, 50);

		ImageIcon myFace = new ImageIcon("res/icons8-human-head-48.png");
		userLabel = new JLabel(myFace);
		// userLabel.setText("me!");
		userLabel.setSize(50, 50);
		userLabel.setOpaque(false);
		userLabel.setLocation(275, 275);

		mapPanel.add(userLabel);

		popUpLabel = new JLabel("  주변 경기장 정보를 탐색중입니다.");
		popUpLabel.setBackground(Color.gray);
		popUpLabel.setOpaque(true);
		popUpLabel.setSize(600, 200);
		popUpLabel.setLocation(0, 600);

		controlPanel = new ControlPanel();
		controlPanel.setBackground(Color.gray);
		controlPanel.setSize(600,100);
		controlPanel.setLocation(0,800);
		
		this.add(mapPanel);
		this.add(userLabel);
		this.add(popUpLabel);
		this.add(controlPanel);
		
		initForTest();
		timer = new Timer(250, this);
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
		getCenterGPS();
		findItems(x,y);
		repaint();
		itemPopCount++;
	}
	
	public void findItems(int x, int y) {
		
		// updateRequest(x, y); 
//		for(MapItem item : list) {
//			this.setItem(item);
//		}
		if(list.size() > itemPopCount) {
			//System.out.println(list.size());
			this.setItem(list.get(itemPopCount), itemPopCount);
		}
	}

	public void setItem(MapItem item, int index) {
		itemLabels[index] = item;
		itemLabels[index].setName(""+item.id);
		itemLabels[index].setLocation((item.x - x) + 300 ,(item.y - y) + 300);
		this.add(itemLabels[index]);
		System.out.println("try to set item" + item.id + " at " + (item.x - x) + "," + (item.y - y));
	}
	
	public void initForTest() {
		list = new ArrayList<MapItem>();
		list.add(new MapItem(1, 20, 20, 1));
		list.add(new MapItem(2, -100, -100, 1));
		list.add(new MapItem(3, 200, 200, 2));
		list.add(new MapItem(4, -175, 175, 2));
	}


}
