package community;

import java.util.ArrayList;
import java.util.List;




public class SharedList {

    private static List<CommuVO> commuList = new ArrayList<>();

    public static List<CommuVO> getSharedList() {
        return commuList;
    }

    public static void addToSharedList(String item, String item2, String item3) {
        // CommuVO 클래스에 따라 생성자 수정
        commuList.add(new CommuVO(item, item2, item3 ));
    }

	public static void setCommuList(List<CommuVO> commuList) {
		SharedList.commuList = commuList;
	}
	
	//초기 데이터 추가하는 정적 메서드 초기화
	static {
		commuList.add(new CommuVO("<공지> 깨끗한 커뮤니티 문화를 만듭시다", "PICK UP GAME 이용해주시는 분들 모두 깨끗하고 기분좋은 커뮤니티 문화를 위해  다들 건전한 게시물들 써주시기 바랍니다.\n"
				+ "","관리자"));
		commuList.add(new CommuVO("농구경기 잘하시더군요", "오늘 경기 함께 뛰어준 분들 오늘 즐거웠어요. 다음번에는 반드시 이기겠습니다 각오하시죠!","서태웅"));
		commuList.add(new CommuVO("레이업 잘하는 방법", "레이업을 할때는 미리 준비가 잘 되어야 해요. 내가 갈 수 있는 경로를 미리 생각해서 자세를 잡으시고 시도할때는 손목의 스냅 없이 공을 밀어올리는듯이 하면 됩니다.\n"
				+ "처음에는 어려울거에요 하지만 레이업은 연습 또 연습이 중요한 기술이에요 이 기술만 제대로 익히면 득점머신이 될 수 있어요.\n"
				+ "속공으로 기회가 있을때도 레이업으로 득점을 하는것은 짜릿하기도 할거에요 모두 함께 즐거운 농구 즐깁시다!","농구천재"));
		commuList.add(new CommuVO("경기 매너 나쁜 사람이 보이네요","위협적인 동작으로 팀 에이스들을 깜짝 놀래키면서 플레이를 하는 분이 계시네요 그러다 다치면 어떻게 하려고 그러는지 모르겠어요.\n"
				+ "이름이 남훈이랫나? 좀 그렇게 플레이 안했으면 좋겠어요. 계속 이런식으로 플레이하시면 같이 게임 절대 안하겠습니다.","채지웅"));
		// 필요한 만큼 초기 데이터를 추가
		}
	}

