package racingcar.view;

public class ErrorView {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void printErrorMsg(String msg){
        System.out.println(ERROR_MESSAGE + msg);
    }
}
