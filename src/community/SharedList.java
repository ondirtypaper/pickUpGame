package community;

import java.util.ArrayList;
import java.util.List;



public class SharedList {

    private static List<CommuVO> commuList = new ArrayList<>();

    public static List<CommuVO> getSharedList() {
        return commuList;
    }

    public static void addToSharedList(String item, String item2) {
        // CommuVO 클래스에 따라 생성자 수정
        commuList.add(new CommuVO(item, item2 ));
    }

	public static void setCommuList(List<CommuVO> commuList) {
		SharedList.commuList = commuList;
	}
	static {
		commuList.add(new CommuVO("첫 번째 게시글", "첫 번째 게시글의 내용입니다."));
		commuList.add(new CommuVO("두 번째 게시글", "두 번째 게시글의 내용입니다."));
		// 필요한 만큼 초기 데이터를 추가
		}
}

