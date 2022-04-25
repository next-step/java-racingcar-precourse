package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

public class RacingCarConsoleView {

    public static String printInputMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }
    public static String printInputMessage2(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static void printMovingDistanceEveryCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMovingDistance(); i++) {
            System.out.print("-");
        }
        printMessageLine("");
    }

    public static void printMessageLine(String message) {
        System.out.println(message);
    }
    public static void printMessage(String message) {
        System.out.print(message);
    }

}
