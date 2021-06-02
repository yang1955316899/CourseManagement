package top.jsjkxyjs.entity;

import java.util.List;

public class StudentGrade {
	private int studentId;
	private String studentName;
	private int classId;
	private String className;
	private List<course> courseList;

	class course {
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
