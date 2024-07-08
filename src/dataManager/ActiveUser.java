package dataManager;

import java.awt.geom.Point2D;

public class ActiveUser extends User{
	
	private Position currentLocation;
	private int favoriteCourtId;
	
	public ActiveUser(String name, String email, String passWord) {
		super(name, email, passWord);
		currentLocation = null;
		favoriteCourtId = -1;
	}

	public Position getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Position currentLocation) {
		this.currentLocation = currentLocation;
	}
	public void setCurrentLocation(double x, double y) {
		currentLocation = new Position();
		currentLocation.setLocation(x, y);
	}

	public int getFavoriteCourtId() {
		return favoriteCourtId;
	}

	public void setFavoriteCourtId(int favoriteCourtId) {
		this.favoriteCourtId = favoriteCourtId;
	}

	
	
}
