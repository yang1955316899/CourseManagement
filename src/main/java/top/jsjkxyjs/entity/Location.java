package top.jsjkxyjs.entity;

public class Location {
	int id;
	String Title;
	int PID;
	int MaxSize;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getPID() {
		return PID;
	}

	public void setPID(int PID) {
		this.PID = PID;
	}

	public int getMaxSize() {
		return MaxSize;
	}

	public void setMaxSize(int maxSize) {
		MaxSize = maxSize;
	}
}
