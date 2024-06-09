import model.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RaceController {
    RaceView view = new RaceView();
    Scanner scanner = new Scanner(System.in);

    public List<String> getCars() {
        List<String> carNames = new ArrayList<>();
        while (carNames.isEmpty()) {
            try {
                carNames = setCars(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                view.showError(e.getMessage());
            }
        }
        return carNames;
    }

    public static List<String> setCars(String input) {
        String[] rawNames = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : rawNames) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            carNames.add(name);
        }
        return carNames;
    }

    public int getIter() {
        int iterNum = 0;
        while(iterNum < 1) {
            try {
                iterNum = setIter(scanner.nextInt());
            } catch (IllegalArgumentException e) {
                view.showError(e.getMessage());
            }
        }
        return iterNum;
    }

    public static int setIter(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("시도 회수는 0 이상이어야 합니다.");
        }
        return input;
    }

    public void start() {
        view.showSetcars();
        List<String> carNames = getCars();
        view.showSetiter();
        int iterNum = getIter();
        StringBuilder winners = new StringBuilder();
        Race race = new Race(carNames, iterNum);
        view.showRound();
        for(int i=0 ; i<iterNum ; i++) {
            race.round();
        }
        for(String winner : race.checkWinner()) {
            winners.append(winner).append(", ");
        }

        view.showWinners(winners.substring(0, winners.length()-2));
    }
}
