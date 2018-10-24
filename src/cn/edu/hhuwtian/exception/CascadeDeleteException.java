package cn.edu.hhuwtian.exception;

/**
 * 级联删除的异常类
 * 
 * @author 贾金磊
 * 
 */
public class CascadeDeleteException extends Exception {

	private static final long serialVersionUID = 1L;

	private String msg;
	
	public CascadeDeleteException(String msg) {
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
