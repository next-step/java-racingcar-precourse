package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import race.Car;
import race.Race;
import static view.Prompt.RESULT;
import static view.Prompt.WINNERS;

public class Output {

    public static void printException(String msg) {
        System.out.println(msg);
    }

    public static void printResult() {
        System.out.println(Prompt.RESULT);
    }

    public static void printRaceState(List<Car> cars) {
        for (Car c : cars) {
            System.out.println(c.toString());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        StringJoiner sj = new StringJoiner(", ");
        System.out.print(WINNERS);
        for (String winnerName : winnerNames) {
            sj.add(winnerName);
        }
        System.out.println(sj.toString());
    }
}
