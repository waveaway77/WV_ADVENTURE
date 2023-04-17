package leejy.myapp.api.common.exception.controller;

/*
Customer Exception Class인 HomeException이 사용될 때 발동한다. (원리:@ExceptionHandler)
 */

import com.example.playground.common.exception.model.ExceptionCodeResponse;
import com.example.playground.common.exception.vo.ResultCdVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;

@ControllerAdvice
public class HomeExceptionHandler {
//
//    @Resource
//    ResultMapper mapper;
//
//    @ExceptionHandler(HomeException.class)
//    public ResponseEntity<ExceptionCodeResponse> exceptionHandler(HomeException ex) {
//
//        ExceptionCodeResponse response = new ExceptionCodeResponse();
//
//        ResultCdVo vo = mapper.getResultCd(ex.getCode());
//
//        response.setCode(vo.getRESULT_CD());
//        response.setMessage(vo.getRESULT_MESSAGE());
//
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}

/*
new ResponseEntity<>
*/