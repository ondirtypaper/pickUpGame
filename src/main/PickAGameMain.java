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
		// Version Number
		// 1.abcd  .이하 abcd는 가나순으로 팀원들의 업데이트 여부
		// 강성배, 김희재, 윤형석, 서영준
		
		System.out.println("***************************************");
		System.out.println("************  Pick A Game  ************");
		System.out.println("***************************************");
		System.out.println("**************************** Ver 1.1100");
		System.out.println("**************************** 2024-07-16");
		

		// Just for test
		// RootFrame.data.addUser("test_admin", "a@test.com", "1234pass!");
		// data/user.data 로 테스트 계정 새로 가입할 필요 없어짐
		
		/* 코드 데이터 생성 코드
		Court c1 = new Court(1, "성균관대학교 인문사회과학 캠퍼스 농구장", new Position(61, 334));
		c1.setHasLight(true);
		c1.setHasParking(false);
		c1.setHasToilet(true);
		c1.setRingNum(2);
		c1.setTexture("우레탄");
		Court c2 = new Court(2, "홍익대학교 사범대학 부속고등학교 농구장", new Position(326, 149));
		Court c3 = new Court(3, "동성고등학교 농구장", new Position(310, 414));
		Court c4 = new Court(4, "가톨릭대학교 성신교정 농구장", new Position(417, 434));
		RootFrame.data.addCourt(c1);
		RootFrame.data.addCourt(c2);
		RootFrame.data.addCourt(c3);
		RootFrame.data.addCourt(c4);
		*/

	}
}
