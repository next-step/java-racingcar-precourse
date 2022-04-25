package racingcar.view;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void printMessageWithNewLine(String message) {
        System.out.println(message);
    }
}
