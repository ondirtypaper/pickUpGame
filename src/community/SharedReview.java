package community;

import java.util.ArrayList;
import java.util.List;

public class SharedReview {
	private static List<ReviewVO> reList = new ArrayList<>();

	public static List<ReviewVO> getreList() {
		return reList;
	}

	public static void addToreList(String item, String item2, String item3, int a) {
		// CommuVO 클래스에 따라 생성자 수정
		reList.add(new ReviewVO(item, item2, item3, a));
	}

	public static void setreList(List<ReviewVO> reList) {
		SharedReview.reList = reList;
	}

	static {
		reList.add(new ReviewVO("성대 인사캠 농구장 리뷰입니다", "사람도 많고 조명이 있어서 그런지 특히 야간에는 엄청 많습니다.\r\n"
				+ "3on3나 4on4로 반코트 게임 밀어내기를 많이 해요!\r\n" + "다만 너무 늦게 오시면 자리가 차서 게임 하기 힘드실 수도 있습니다.\r\n", "강성배", 4));
		reList.add(new ReviewVO("리뷰 적어봅니다 ㅎㅎ",
				"중구에서 제일 가까운 코트라서 중구분들이 엄청 많이 오십니다. 시내와 가까워서 그런지 외국인 분들도 많아요!\r\n"
						+ "그런데 사람은 많은데 비해 골대가 2개뿐이라 게임 하기가 힘듭니다.. 저는 비추..\r\n"
						+ "그리고 자꾸 고등학생인지 대학생인지 와서 점프력 테스트 한답시고 그물을 잡아서 그물이 자주 찢어진 상태입니다.. 지금 가보시면\r\n"
						+ "아마 그물 없을거예요.. 관리좀 부탁드려요..\r\n",
				"윤현석", 2));
		reList.add(new ReviewVO(" 성대 인사캠 코트 리뷰!!", "중구에 있는 유일하게 갈만한 코트죠. 굉장히 잘하시는 분도 많고 열정 넘치는 분들이 많습니다.\r\n"
				+ "특히 월 야간 금토일 야간에는 사람이 많고 수요일 야간에도 정기적으로 오시는 분들 있으니 참고하세용~~\r\n", "김희재", 5));
		reList.add(new ReviewVO("성대 인사캠 시설 리뷰 작성자",
				"흠.. 저는 좀 다르게 시설에 대한 리뷰를 작성해볼까 합니다. 일단 우레탄은 괜찮은데 좀 미끄러운 경향이 있습니다.. 그리고 골대가 워낙 낡아서\r\n"
						+ "드가는 슛도 림이 튀어 나오는 경우가 꽤 많습니다..\r\n"
						+ "게다가 누가 잡는지 자주 그물이 찢어집니다. 평일에는 대학시설 화장실이나 식수대를 이용할 수 있지만 주말이 되면 이용할 수 없는것도 흠이라면 흠이네요\r\n"
						+ "우리 모두 깔끔하게 이용해서 올바른 농구인 문화를 만들어 봅시다!",
				"서영준", 2));
		// 필요한 만큼 초기 데이터를 추가
	}

}
