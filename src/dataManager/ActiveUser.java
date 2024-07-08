package dataManager;

import java.awt.geom.Point2D;

public class ActiveUser extends User{
	
	private Point2D currentLocation;
	private int favoriteCourtId;
	
	public ActiveUser(String name, String email, String passWord) {
		super(name, email, passWord);
		currentLocation = null;
		favoriteCourtId = -1;
	}

	public Point2D getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point2D currentLocation) {
		this.currentLocation = currentLocation;
	}

	public int getFavoriteCourtId() {
		return favoriteCourtId;
	}

	public void setFavoriteCourtId(int favoriteCourtId) {
		this.favoriteCourtId = favoriteCourtId;
	}

	
	
}
