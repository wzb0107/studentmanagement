package cn.edu.hhuwtian.pojo;

import java.util.List;

public class TStudentselectcourseinfo {
	private Integer id;

	private List<TStudent> students;

	private List<TCourseinfo> courses;

	private Integer score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<TStudent> getStudents() {
		return students;
	}

	public void setStudents(List<TStudent> students) {
		this.students = students;
	}

	public List<TCourseinfo> getCourses() {
		return courses;
	}

	public void setCourses(List<TCourseinfo> courses) {
		this.courses = courses;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}