package racinggame.game.car;

import java.util.Collections;
import java.util.List;

public class WinnerForwardMovementCount {
    private final int winnerForwardMovementCount;

    public WinnerForwardMovementCount(List<Car> carList) {
        this.winnerForwardMovementCount = Collections.max(carList).getForwardMovementCount();
    }

    public int getWinnerForwardMovementCount() {
        return winnerForwardMovementCount;
    }
}
