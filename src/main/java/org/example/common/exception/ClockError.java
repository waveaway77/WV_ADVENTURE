package org.example.common.exception;

public enum ClockError {
	SUCCESS("000000", "성공"),
	ER0001("ER0001","서버 에러");
	
	private String code;
	private String message;
	
	ClockError(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage(String... args) {
		String returnMsg = message;
		if(args==null || args.length <= 0) {
			return returnMsg;
		}
		
		String[] splitMsg = message.split("");
		if(splitMsg == null || splitMsg.length <= 1) {
			return returnMsg;
		}
		
		for (String str : args) {
			returnMsg = returnMsg.replaceFirst("%", str);
		}
		
		return returnMsg;
	}
}
