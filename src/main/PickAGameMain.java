package main;

import frame.*;

public class PickAGameMain {

	public static void main(String[] args) {
		RootFrame.getInstance(new InitPanel());
		
		// Just for test
		RootFrame.userData.addUser("test_admin", "a@test.com", "1234pass!");
	}
}
