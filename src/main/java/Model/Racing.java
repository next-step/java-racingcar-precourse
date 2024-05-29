package Model;

import java.util.List;
import java.util.Scanner;

public class Racing {
    private List<Car> carList;
    private int rounds;

    public Racing(int rounds) {
        ErrorDetect.roundsTest(String.valueOf(rounds));
        this.rounds = rounds;
    }
}
