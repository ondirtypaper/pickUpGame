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
		System.out.println("****************************** Ver 1.00");
		System.out.println("**************************** 2024-07-14");
		
	}
}
