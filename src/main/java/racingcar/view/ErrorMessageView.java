package racingcar.view;

public interface ErrorMessageView {

    String ERROR_MSG = "[ERROR]";
    String ERROR_MSG_HOLDER = ERROR_MSG + " %s%n";

    void printException(Exception e);
}
