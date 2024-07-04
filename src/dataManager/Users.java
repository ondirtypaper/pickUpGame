package dataManager;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Users {

	ArrayList<User> regList;
	ArrayList<ActiveUser> activeList;
	
	class User {
		String name;
		String email;
		String passWord;
	}
	class ActiveUser extends User {
		Point2D currentLocation;
		int favoriteCourtID;
	}
	Users(){
		regList = new ArrayList<User>();
		activeList = new ArrayList<ActiveUser>();
	}
	
	public boolean addUser(String name, String email, String passWord) {
		for(int i = 0; i < regList.size() ; i++) {
			if(regList.get(i).email.equals(email)) {
				return false;
			}
		}
		User temp = new User();
		temp.name = name;
		temp.email = email;
		temp.passWord = passWord;
		regList.add(temp);
		return true;
	}
}
