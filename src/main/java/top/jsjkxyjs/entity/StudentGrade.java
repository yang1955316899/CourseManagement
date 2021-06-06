package top.jsjkxyjs.entity;

import java.util.List;

public class StudentGrade {
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<course> courseList) {
		this.courseList = courseList;
	}

	private int studentId;
	private String studentName;
	private int classId;
	private String className;
	public List<course> courseList;

	public class course {
		private int courseId;
		private String courseName;
		private String teacher;
		private int YearSemester;
		private int grade;

		public int getCourseId() {
			return courseId;
		}

		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public String getTeacher() {
			return teacher;
		}

		public void setTeacher(String teacher) {
			this.teacher = teacher;
		}

		public int getYearSemester() {
			return YearSemester;
		}

		public void setYearSemester(int yearSemester) {
			YearSemester = yearSemester;
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}
	}

}
