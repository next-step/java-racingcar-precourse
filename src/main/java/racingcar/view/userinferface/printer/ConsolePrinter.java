package racingcar.view.userinferface.printer;

public class ConsolePrinter implements Printer {
    @Override
    public void info(String message) {
        System.out.print(message);
    }
}
