package community;

public class ReviewVO {
	
	
	private String title;
	private String deTail;
	private String writer;
	private int score;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDeTail() {
		return deTail;
	}
	public void setDeTail(String deTail) {
		this.deTail = deTail;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getScore() {
		return score;
	}
	public void setNum(int num) {
		this.score = score;
	}
	
	public ReviewVO(String title, String deTail, String writer , int score) {
		
		this.title = title;
		this.deTail = deTail;
		this.writer = writer;
		this.score = score;
	}
	
}
