package cn.edu.hhuwtian.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TClassinfo {
	private Integer id;

	private String number;

	private String name;

	private Integer spacialfieldid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String teachercharge;

	private String phone;

	private String memo;

	private TSpecialfieldinfo specialfieldinfo;

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

	public Integer getSpacialfieldid() {
		return spacialfieldid;
	}

	public void setSpacialfieldid(Integer spacialfieldid) {
		this.spacialfieldid = spacialfieldid;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTeachercharge() {
		return teachercharge;
	}

	public void setTeachercharge(String teachercharge) {
		this.teachercharge = teachercharge == null ? null : teachercharge
				.trim();
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

	public TSpecialfieldinfo getSpecialfieldinfo() {
		return specialfieldinfo;
	}

	public void setSpecialfieldinfo(TSpecialfieldinfo specialfieldinfo) {
		this.specialfieldinfo = specialfieldinfo;
	}

}