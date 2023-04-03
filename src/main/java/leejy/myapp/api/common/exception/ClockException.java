package leejy.myapp.api.common.exception;

public class ClockException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMessage;
	
	public ClockException(Exception ex, ClockError error) {
		super(ex);
		this.errCode = error.getCode();
		this.errMessage = error.getMessage();
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
}
