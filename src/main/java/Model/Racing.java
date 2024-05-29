package Model;

import java.util.List;
import java.util.Scanner;

public class Racing {
    private List<Car> carList;
    private int rounds;

    public void setRounds() {
        Scanner scanner = new Scanner(System.in);
        String roundsInput = scanner.nextLine();

        ErrorDetect.roundsTest(roundsInput);
        rounds = Integer.parseInt(roundsInput);
    }
}
