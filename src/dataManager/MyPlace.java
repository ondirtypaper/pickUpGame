package dataManager;

public class MyPlace {

	String userEmail;
	int id;
	String name;
	Position p;
	
	public MyPlace(String userEmail, int id, String name, Position p) {
		this.userEmail = userEmail;
		this.id = id;
		this.name = name;
		this.p = p;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	
	
}
