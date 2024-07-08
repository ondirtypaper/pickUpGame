package main;

import frame.*;

public class PickAGameMain {

	public static void main(String[] args) {
		RootFrame.setFrameFor(new InitPanel());
		
		// Just for test
		RootFrame.data.addUser("test_admin", "a@test.com", "1234pass!");
	}
}
