package console;

import racingcar.Car;

public class PrintOutput {

    public static void gameStatus(Car car) {
        System.out.println(car.getName() + " : " + printDash(car.getPosition()));
    }

    private static String printDash(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
