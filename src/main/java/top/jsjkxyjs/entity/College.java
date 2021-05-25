package top.jsjkxyjs.entity;

public class College {
	int id;
	int Counselor;
	private String Title;
	private int pId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCounselor() {
		return Counselor;
	}

	public void setCounselor(int counselor) {
		Counselor = counselor;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
}
