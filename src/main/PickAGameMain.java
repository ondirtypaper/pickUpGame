package main;

import dataManager.Court;
import dataManager.Position;
import frame.InitPanel;
import frame.RootFrame;

public class PickAGameMain {

	
	public static void main(String[] args) {

		// RootFrame 호출
		RootFrame.setFrameFor(new InitPanel());


		// 버전 관리를 위한 log 출력
		System.out.println("***************************************");
		System.out.println("************  Pick A Game  ************");
		System.out.println("***************************************");
		System.out.println("****************************** Ver 1.3*");
		System.out.println("**************************** 2024-07-18");
		

		// Just for test
		// RootFrame.data.addUser("test_admin", "a@test.com", "1234pass!");
		// data/user.data 로 테스트 계정 새로 가입할 필요 없어짐
		Court c1 = new Court(1, "성균관대학교 인문사회과학 캠퍼스 농구장", new Position(61, 334));
	      c1.setHasLight(true);
	      c1.setHasParking(false);
	      c1.setHasToilet(true);
	      c1.setRingNum(2);
	      c1.setTexture("우레탄");
	      Court c2 = new Court(2, "홍익대학교 사범대학 부속고등학교 농구장", new Position(326, 149));
	      c2.setHasLight(false);
	      c2.setHasParking(false);
	      c2.setHasToilet(false);
	      c2.setRingNum(4);
	      c2.setTexture("모래");
	      Court c3 = new Court(3, "동성고등학교 농구장", new Position(310, 414));
	      c3.setHasLight(true);
	      c3.setHasParking(true);
	      c3.setHasToilet(true);
	      c3.setRingNum(6);
	      c3.setTexture("우레탄");
	      Court c4 = new Court(4, "가톨릭대학교 성신교정 농구장", new Position(417, 434));
	      c4.setHasLight(true);
	      c4.setHasParking(false);
	      c4.setHasToilet(false);
	      c4.setRingNum(3);
	      c4.setTexture("플라스틱");
	      RootFrame.data.addCourt(c1);
	      RootFrame.data.addCourt(c2);
	      RootFrame.data.addCourt(c3);
	      RootFrame.data.addCourt(c4);

	}
}
