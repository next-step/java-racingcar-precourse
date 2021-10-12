package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerNames {
    private List<String> winnerNames = new ArrayList<>();


    public void addName(String carName) {
        winnerNames.add(carName);
    }

    public String getWinnerNames() {
        validateWinnerNames();
        return String.join(",", winnerNames);
    }

    private void validateWinnerNames() {
        if (winnerNames.isEmpty()) {
            throw new NotExistWinnerException("우승자가 구해지지 않았습니다.");
        }
    }
}
