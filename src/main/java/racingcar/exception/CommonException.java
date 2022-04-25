package racingcar.exception;

public class CommonException extends RuntimeException{

    private static final String COMMON_ERROR_MESSAGE = "[ERROR] ";

    public CommonException(String errorMessage){
        super(COMMON_ERROR_MESSAGE + errorMessage);
    }
}
