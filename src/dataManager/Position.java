package dataManager;

import java.awt.geom.Point2D;

public class Position extends Point2D{

	double x;
	double y;
	
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
