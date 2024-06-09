import model.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    RaceView view = new RaceView();

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

    public static int setIter(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("시도 회수는 0 이상이어야 합니다.");
        }
        return input;
    }

    public void start() {
        int iterNum = setIter(view.showSetiter());
        StringBuilder winners = new StringBuilder();
        Race race = new Race(setCars(view.showSetcars()), iterNum);
        for(int i=0 ; i<iterNum ; i++) {
            race.round();
        }
        for(String winner : race.checkWinner()) {
            winners.append(winner).append(",");
        }

        view.showWinners(winners.substring(0, winners.length()-1));
    }
}
