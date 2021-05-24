package top.jsjkxyjs.entity;

public class Time {
	/**
	 * 时间格式
	 * xxxx-x-x-x-x.x.x.x
	 * 年份-学期-状态码-星期-课程段
	 * 状态码
	 * 1-单周
	 * 2-双周
	 * 3-单双周
	 */
	private int year;
	private int semester;
	private int day;
	private int Code;
	private int[] classCode = new int[10];

	public Time() {
	}

	public Time(int year, int semester, int day, int code, int[] classCode) {
		this.year = year;
		this.semester = semester;
		this.day = day;
		Code = code;
		this.classCode = classCode;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	public int getClassCode(int index) {
		return classCode[index];
	}

	public void setClassCode(int[] classCode) {
		this.classCode = classCode;
	}
}
