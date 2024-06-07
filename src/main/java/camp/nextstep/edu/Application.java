package camp.nextstep.edu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UI ui = new UI(scanner);
        ui.inputCarNames();
        ui.inputRepeatCount();
        ui.run();
    }
}
