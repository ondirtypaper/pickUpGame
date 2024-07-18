package frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import dataManager.Position;
import subPage3.SubPage3MainPanel;

public class MapItem extends JLabel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int USER_TYPE = 1;
	public static final int COURT_TYPE = 2;
	
	String id;
	int itemType;
	ImageIcon ballIcon = new ImageIcon("res/justABall.png");
	ImageIcon courtIcon = new ImageIcon("res/subPage3Img/locationbutton_4040.png");
	Position p;

	public MapItem(String id, double x, double y, int itemType) {
		this.id = id;
		//this.x = x;
		//this.y = y;
		p = new Position();
		p.setLocation(x, y);
		this.itemType = itemType;
		if (itemType == USER_TYPE) {
			this.setIcon(new ImageIcon(ballIcon.getImage().getScaledInstance(35, 35, 0)));
		}
		else if (itemType == COURT_TYPE) {
			this.setIcon(new ImageIcon(courtIcon.getImage().getScaledInstance(35, 35, 0)));
		}
		this.setSize(35,35);
		this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("user click the map item" + e.getComponent().getName());
		
		if (this.itemType == USER_TYPE) {
			FirstPagePanel.setPopUpLabel(this);
		}
		else if (this.itemType == COURT_TYPE) {
			RootFrame.setFrameFor(new SubPage3MainPanel());
		}
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
		
		//System.out.println("mouse entered in mapItem" + e.getComponent().getName());
		//this.setIcon(new ImageIcon(ballIcon.getImage().getScaledInstance(50, 50, 0)));
		if (this.itemType == USER_TYPE) {
			this.setIcon(new ImageIcon(ballIcon.getImage().getScaledInstance(50, 50, 0)));
		}
		else if (this.itemType == COURT_TYPE) {
			this.setIcon(new ImageIcon(courtIcon.getImage().getScaledInstance(50, 50, 0)));
		}
		
		this.setSize(50,50);
		this.setLocation((int)this.getLocation().getX()-8, (int)this.getLocation().getY()-8);
		 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if (this.itemType == USER_TYPE) {
			this.setIcon(new ImageIcon(ballIcon.getImage().getScaledInstance(35, 35, 0)));
		}
		else if (this.itemType == COURT_TYPE) {
			this.setIcon(new ImageIcon(courtIcon.getImage().getScaledInstance(35, 35, 0)));
		}
		
		this.setSize(35,35);
		this.setLocation((int)this.getLocation().getX()+8, (int)this.getLocation().getY()+8);
		
	}

	
}
