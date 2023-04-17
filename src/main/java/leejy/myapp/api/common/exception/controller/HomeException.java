package leejy.myapp.api.common.exception.controller;

/*
Exception class를 상속받아 Custom Exception Class 생성.
상속을 받은 이유 : ?
생정자를 throw하여 [throw new HomeException("");] 인입된 String errorCode를 사용하여 멤버변수에 대입
해당 클래스가 사용될 때 HomeExceptionHandler가 작동한다 (@ExceptionHandler)
컨트롤러가 전달한 에러코드를 이 멤버변수에 대입하여 Handler에서 파라미터로 받아 db 조회를 한다.
 */
public class HomeException extends Exception {

    private String code = "";

    public HomeException(String errorCode) {
        this.code = errorCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "HomeException{" +
                "code='" + code + '\'' +
                '}';
    }
}
