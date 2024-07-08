package frame;



import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManager.ActiveUser;
import dataManager.Position;
import dataManager.User;
import dataManager.DataManager;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class RootFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RootFrame instance;
	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 900;
	
	public static DataManager data;
	public static ActiveUser cUser;
	public static ArrayList<ActiveUser> aroundAU;
	
	public static final Color MAIN_RED = new Color(0xC85356);
	public static final Color MAIN_ORANGE = new Color(0xED6B44);
	
	
	private RootFrame(JPanel e) {
		
		
		setTitle("Pick A Game");
		setLayout(null);
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		
		// data 초기화
		data = new DataManager();
		// test data 생성
		data.initForTest();
		
		add(e);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	/**
	 * View 변경을 위한 frame 재설정 method
	 * @param e - 변경할 view panel
	 */
	public static void setFrameFor(JPanel e) {
		if(instance == null)instance = new RootFrame(e);
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);
		instance.revalidate();
		instance.repaint();
	}
	
	public static void setCurrentUser(int index) {
		
		User u = data.getRegUser(index);
		//setCurrentGPS();
		cUser = new ActiveUser(u.getName(), u.getEmail(), u.getPassWord());
		cUser.setCurrentLocation(getPosition());
		cUser.setFavoriteCourtId(getFavoriteCourtId());
		
		System.out.println("RootFrame : Current User > " + cUser.getName());
	}
	/**
	 * Test를 위해 사용자의 Position을 0,0으로 가정
	 * 실구현을 위해서는 사용자의 위치정보를 가져오도록 변경 요함
	 * @return Position (0,0)
	 */
	public static Position getPosition() {
		Position p = new Position();
		p.setLocation(0.0, 0.0);
		return p;
	}
	/**
	 * 사용자가 미리 설정하거나 
	 * 가장 접근이 쉬운 코트(경기장) 정보를 가져오는 method
	 * 일종의 추천 알고리즘을 적용할 것
	 * 
	 */
	public static int getFavoriteCourtId() {
		return -1;
	}
	public static void updateActiveUsers() {
		aroundAU = data.getAroundActvieUser(getPosition());
	}
}
