package cn.edu.hhuwtian.pojo;

import java.util.List;

public class TCourseinfo {
	private Integer id;

	private String number;

	private String name;

	private Integer teacherid;

	private String time;

	private String place;

	private String memo;

	private TTeacher teacher;

	private List<TStudentselectcourseinfo> studentCourse;

	public List<TStudentselectcourseinfo> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<TStudentselectcourseinfo> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public TTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(TTeacher teacher) {
		this.teacher = teacher;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time == null ? null : time.trim();
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place == null ? null : place.trim();
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}
}