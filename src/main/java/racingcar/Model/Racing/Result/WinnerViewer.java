package racingcar.Model.Racing.Result;

import java.util.ArrayList;
import java.util.List;

public class WinnerViewer {
    private final List<String> winnerList = new ArrayList<>();

    public void addWinner(String carName) {
        this.winnerList.add(carName);
    }

    public void printWinner() {
        System.out.printf("최종 우승자: %s", String.join(", ", this.winnerList));
    }
}
