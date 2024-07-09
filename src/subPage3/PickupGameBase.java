package subPage3;

import java.awt.*;
import java.text.Normalizer;

public class PickupGameBase {
	//임시 글꼴
	public static Font tempfont=new Font("돋움",Font.BOLD,10);
	
	//위치버튼 넣어주는 포인트 객체
	public Point pointCourt1Hong=new Point(326,149);
	public Point pointCourt2Sung=new Point(61,334);
	public Point pointCourt3dong=new Point(310,414);
	public Point pointCourt4Catholic=new Point(417,434);
	
	
	public Point getPointCourt1Hong() {
		return pointCourt1Hong;
	}


	public Point getPointCourt2Sung() {
		return pointCourt2Sung;
	}


	public Point getPointCourt3dong() {
		return pointCourt3dong;
	}


	public Point getPointCourt4Catholic() {
		return pointCourt4Catholic;
	}


	
	
}
