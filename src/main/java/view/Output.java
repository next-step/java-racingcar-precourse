package view;

import java.util.List;
import race.Car;
import race.Race;

public class Output {
    public static void printException(String msg) {
        System.out.println(msg);
    }

    public static void printRaceState(List<Car> cars) {
        for (Car c : cars) {
            System.out.println(c.toString());
        }
        System.out.println();
    }
}
