package community;

public class CommuVO {
	
	private String title;
	private String deTail;
	private String id;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public CommuVO(String title, String deTail, String id) {
		
		this.title = title;
		this.deTail = deTail;
		this.id = id;
	}
	
	
	
	
	
	
	
}
