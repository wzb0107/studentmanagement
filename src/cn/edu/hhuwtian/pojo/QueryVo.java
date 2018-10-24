package cn.edu.hhuwtian.pojo;

public class QueryVo {
	private Integer collegeid;
	private Integer spacialfieldid;
	private Integer classid;
	private Integer teacherid;
	private Integer studentid;
	private Integer courseid;
	private Integer[] ids;
	private String number;
	private String name;// 关键字
	private Integer page;// 当前页
	private Integer size;// 每页数
	private Integer startRow = 0;// 起始行

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public Integer getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public Integer getSpacialfieldid() {
		return spacialfieldid;
	}

	public void setSpacialfieldid(Integer spacialfieldid) {
		this.spacialfieldid = spacialfieldid;
	}

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

}
