package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner sc;

    public String[] inputCarParticipateInRacingGame() {
        sc = new Scanner(System.in);
        return sc.nextLine().split(",");
    }
}
