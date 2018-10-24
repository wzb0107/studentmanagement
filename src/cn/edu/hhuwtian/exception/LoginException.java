package cn.edu.hhuwtian.exception;

/**
 * 登录的异常类
 * 
 * @author 贾金磊
 * 
 */
public class LoginException extends Exception {

	private static final long serialVersionUID = 1L;

	private String msg;
	
	public LoginException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
