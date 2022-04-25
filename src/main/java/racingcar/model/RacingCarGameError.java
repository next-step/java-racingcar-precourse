package racingcar.model;

public class RacingCarGameError {

    private String errorCode;
    private String defaultMessage;

    public void initErorr() {
        this.errorCode = null;
        this.defaultMessage = null;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
