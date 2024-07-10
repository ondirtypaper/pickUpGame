package dataManager;

import java.awt.geom.Point2D;
import java.io.Serializable;

public class Position extends Point2D implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double x;
	double y;
	
	public Position() {
		this.x = 0;
		this.y = 0;
	}
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Position(int x, int y) {
		this.x = (double)x;
		this.x = (double)y;
	}
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setLocation(double x, double y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(Position other) {
		return Point2D.distance(x, y, other.x, other.y);
	}

}
