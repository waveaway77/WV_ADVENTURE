package org.example.common.exception;

import org.example.common.model.ErrorResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClockExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ClockException.class})
	@ResponseBody
	public ResponseEntity<ErrorResp> customHandle(ClockException ex) {
		logger.warn("[============= ClockExcpetion=========]", ex);
		ErrorResp resp = new ErrorResp();
		resp.setErrorCode(ex.getErrCode());
		resp.setErrorMessage(ex.getErrMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
	}
}
