package top.jsjkxyjs.entity;

public class Course {
	int id;
	String CourseName;
	int Teacher;
	int Room;
	int MaxSize;
	String YearSemester;
	int Week;
	String ClassCode;
	float Credit;
	String Desc;
	int Choose;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getTeacher() {
		return Teacher;
	}

	public void setTeacher(int teacher) {
		Teacher = teacher;
	}

	public Course(String courseName, int teacher, int room, int maxSize, String yearSemester, int week, String classCode, float credit, String desc, int choose) {
		CourseName = courseName;
		Teacher = teacher;
		Room = room;
		MaxSize = maxSize;
		YearSemester = yearSemester;
		Week = week;
		ClassCode = classCode;
		Credit = credit;
		Desc = desc;
		Choose = choose;
	}

	public Course() {
	}

	public int getMaxSize() {
		return MaxSize;
	}

	public void setMaxSize(int maxSize) {
		MaxSize = maxSize;
	}

	public int getRoom() {
		return Room;
	}

	public void setRoom(int room) {
		Room = room;
	}

	public int getWeek() {
		return Week;
	}

	public String getYearSemester() {
		return YearSemester;
	}

	public void setYearSemester(String yearSemester) {
		YearSemester = yearSemester;
	}

	public void setWeek(int week) {
		Week = week;
	}

	public String getClassCode() {
		return ClassCode;
	}

	public void setClassCode(String classCode) {
		ClassCode = classCode;
	}

	public float getCredit() {
		return Credit;
	}

	public void setCredit(float credit) {
		Credit = credit;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public int getChoose() {
		return Choose;
	}

	public void setChoose(int choose) {
		Choose = choose;
	}
}
