package erp_jsp_exam.dto;

public class Title {
	private int titleNo;
	private String titleName;
	
	public Title() {
	}
	public int getTitleNo() {
		return titleNo;
	}
	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public Title(int titleNo, String titleName) {
		super();
		this.titleNo = titleNo;
		this.titleName = titleName;
	}
	public Title(int titleNo) {
		super();
		this.titleNo = titleNo;
	}
	@Override
	public String toString() {
		return String.format("Title [titleNo=%s, titleName=%s]", titleNo, titleName);
	}
	
	
}
