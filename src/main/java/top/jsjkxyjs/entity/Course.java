package top.jsjkxyjs.entity;

public class Course {
	int id;
	String CourseName;
	int Teacher;
	int Location;
	int MaxSize;
	int YearSemester;
	int Day;
	int ClassCode;
	float Creadit;
	int Assistant;

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

	public int getLocation() {
		return Location;
	}

	public void setLocation(int location) {
		Location = location;
	}

	public int getMaxSize() {
		return MaxSize;
	}

	public void setMaxSize(int maxSize) {
		MaxSize = maxSize;
	}

	public int getYearSemester() {
		return YearSemester;
	}

	public void setYearSemester(int yearSemester) {
		YearSemester = yearSemester;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getClassCode() {
		return ClassCode;
	}

	public void setClassCode(int classCode) {
		ClassCode = classCode;
	}

	public float getCreadit() {
		return Creadit;
	}

	public void setCreadit(float creadit) {
		Creadit = creadit;
	}

	public int getAssistant() {
		return Assistant;
	}

	public void setAssistant(int assistant) {
		Assistant = assistant;
	}
}
