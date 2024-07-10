package main;

import dataManager.Court;
import dataManager.Position;
import frame.*;

public class PickAGameMain {

	public static void main(String[] args) {
		RootFrame.setFrameFor(new InitPanel());
		
		// Just for test
		// RootFrame.data.addUser("test_admin", "a@test.com", "1234pass!");
		// data/user.data 로 테스트 계정 새로 가입할 필요 없어짐
		Court c1 = new Court(1, "성균관대학교 인문사회과학 캠퍼스 농구장 ★", new Position(10,25));
		Court c2 = new Court(2, "두번째 농구장 이름", new Position(-20,-50));
		c1.setHasLight(true);
		RootFrame.data.addCourt(c1);
		RootFrame.data.addCourt(c2);
	}
}
