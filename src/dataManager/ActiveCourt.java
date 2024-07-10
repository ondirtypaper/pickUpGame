package dataManager;

public class ActiveCourt extends Court{

	int userNum;
	
	public ActiveCourt(int id, String name, Position p) {
		super(id, name, p);
		// TODO Auto-generated constructor stub
		this.userNum = 0;
	}
	
	public ActiveCourt(Court c) {
		super(c.id, c.name, c.p);
		this.ringNum = c.ringNum;
		this.texture = c.texture;
		this.hasParking = c.hasParking;
		this.hasLight = c.hasLight;
		this.hasToilet = c.hasToilet;
	}

}
