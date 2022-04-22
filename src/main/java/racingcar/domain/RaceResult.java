package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private static final String RESULT_FORMAT = "최종 우승자: %s";
    List<String> winnerCarNames;

    public RaceResult() {
        this.winnerCarNames = new ArrayList<>();
    }

    public void addWinnerCar(String car) {
        this.winnerCarNames.add(car);
    }

    public String getResult() {
        return String.format(RESULT_FORMAT, String.join(", ", winnerCarNames));
    }
}
