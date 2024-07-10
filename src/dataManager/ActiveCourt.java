package dataManager;

public class ActiveCourt extends Court{

	int userNum;
	
	public ActiveCourt(int id, String name, Position p) {
		super(id, name, p);
		// TODO Auto-generated constructor stub
		this.userNum = 0;
	}

}
