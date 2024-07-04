package frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MapItem extends JLabel implements MouseListener{
	int id;
	int x;
	int y;
	int itemType;
	ImageIcon ballIcon = new ImageIcon("res/justABall.png");

	public MapItem(int id, int x, int y, int itemType) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.itemType = itemType;
		this.setIcon(new ImageIcon(ballIcon.getImage().getScaledInstance(35, 35, 0)));
		this.setSize(35,35);
		this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("user click the map item" + e.getComponent().getName());
		
		//this.setIcon(getDisabledIcon());
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
		this.setIcon(new ImageIcon(ballIcon.getImage().getScaledInstance(50, 50, 0)));
		this.setSize(50,50);
		this.setLocation((int)this.getLocation().getX()-8, (int)this.getLocation().getY()-8);
		 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setIcon(new ImageIcon(ballIcon.getImage().getScaledInstance(35, 35, 0)));
		this.setSize(35,35);
		this.setLocation((int)this.getLocation().getX()+8, (int)this.getLocation().getY()+8);
		
	}
}
