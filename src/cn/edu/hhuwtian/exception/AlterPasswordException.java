package cn.edu.hhuwtian.exception;

public class AlterPasswordException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;

	public AlterPasswordException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
