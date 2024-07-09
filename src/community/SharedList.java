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
    
}

