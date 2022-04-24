package racingcar.view.userinferface;

import racingcar.view.userinferface.printer.Printer;
import racingcar.view.userinferface.scanner.Scanner;

public class ConsoleUserInterface implements GameUserInterface {

    private final Printer printer;
    private final Scanner scanner;

    public ConsoleUserInterface(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void error(String errorMessage) {
        printer.info(String.format("[ERROR] %s\n", errorMessage));
    }

    @Override
    public void show(String message) {
        printer.info(message);
    }

    @Override
    public String getUserInput(String message) {
        show(message);
        return scanner.read();
    }
}
