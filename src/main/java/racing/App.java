package racing;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GameController controller = new GameController(new Race());
        Scanner scanner = new Scanner(System.in);

        initInput(controller, scanner);

        runGame(controller);
    }

    private static void initInput(GameController controller, Scanner scanner) {
        System.out.println(controller.flushOutput());
        List<Car> cars = InputParser.parseCarNames(scanner.nextLine());
        controller.setCars(new CarSet(cars));

        System.out.println(controller.flushOutput());
        Round round = InputParser.parseRound(scanner.nextLine());
        controller.setRound(round);
    }

    private static void runGame(GameController controller) {
        controller.start();
        System.out.println(controller.flushOutput());
    }
}
