package main;

import frame.*;

public class PickAGameMain {

	public static void main(String[] args) {
		RootFrame.setFrameFor(new InitPanel());
		
		// Just for test
		// RootFrame.data.addUser("test_admin", "a@test.com", "1234pass!");
		// data/user.data 로 테스트 계정 새로 가입할 필요 없어짐
	}
}
