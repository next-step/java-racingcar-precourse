package racingcar.common;

public class MessageMaker {

    private final static String ERROR_HEADER = "[ERROR]";
    private final static String RE_MESSAGE = "다시 입력해주세요.";

    public static String consoleOutErrorMessage(String message){
        return ERROR_HEADER + " " + message + " " + RE_MESSAGE;
    }

}
