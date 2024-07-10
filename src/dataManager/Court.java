package dataManager;

public class Court {
	int id;
	String name;
	Position p;
	
	int ringNum;
	String texture;
	boolean hasParking;
	boolean hasLight;
	boolean hasToilet;
	
	
	public Court(int id, String name, Position p) {
		this.id = id;
		this.name = name;
		this.p = p;
		this.ringNum = 2;
		this.texture = "";
		this.hasParking = false;
		this.hasLight = false;
		this.hasToilet = false;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Position getP() {
		return p;
	}


	public void setP(Position p) {
		this.p = p;
	}


	public int getRingNum() {
		return ringNum;
	}


	public void setRingNum(int ringNum) {
		this.ringNum = ringNum;
	}


	public String getTexture() {
		return texture;
	}


	public void setTexture(String texture) {
		this.texture = texture;
	}


	public boolean isHasParking() {
		return hasParking;
	}


	public void setHasParking(boolean hasParking) {
		this.hasParking = hasParking;
	}


	public boolean isHasLight() {
		return hasLight;
	}


	public void setHasLight(boolean hasLight) {
		this.hasLight = hasLight;
	}


	public boolean isHasToilet() {
		return hasToilet;
	}


	public void setHasToilet(boolean hasToilet) {
		this.hasToilet = hasToilet;
	}
	
	public boolean equals(Court otherC) {
		return this.id == otherC.id;
	}
}

