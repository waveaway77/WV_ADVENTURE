package leejy.myapp.api.common.exception.vo;

public class ResultCdVo {
    private String RESULT_CD = "";
    private String RESULT_MESSAGE = "";

    public String getRESULT_CD() {
        return RESULT_CD;
    }

    public void setRESULT_CD(String RESULT_CD) {
        this.RESULT_CD = RESULT_CD;
    }

    public String getRESULT_MESSAGE() {
        return RESULT_MESSAGE;
    }

    public void setRESULT_MESSAGE(String RESULT_MESSAGE) {
        this.RESULT_MESSAGE = RESULT_MESSAGE;
    }

    @Override
    public String toString() {
        return "ResultCdVo{" +
                "RESULT_CD='" + RESULT_CD + '\'' +
                ", RESULT_MESSAGE='" + RESULT_MESSAGE + '\'' +
                '}';
    }
}
