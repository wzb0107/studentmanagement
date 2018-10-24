package cn.edu.hhuwtian.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TSpecialfieldinfo {
	private Integer id;

	private String number;

	private String name;

	private Integer collegeid;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String man;

	private String phone;

	private String memo;
	
	private TCollegeinfo collegeinfo;

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

	public Integer getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMan() {
		return man;
	}

	public void setMan(String man) {
		this.man = man == null ? null : man.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public TCollegeinfo getCollegeinfo() {
		return collegeinfo;
	}

	public void setCollegeinfo(TCollegeinfo collegeinfo) {
		this.collegeinfo = collegeinfo;
	}

	@Override
	public String toString() {
		return "TSpecialfieldinfo [id=" + id + ", number=" + number + ", name="
				+ name + ", collegeid=" + collegeid
				+ ", man=" + man + ", phone=" + phone + ", memo=" + memo
				+ ", collegeinfo=" + collegeinfo + "]";
	}
}