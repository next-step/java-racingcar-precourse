package racinggame.game.model.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerCarNames {
    private final List<CarName> winnerCarNames;

    public WinnerCarNames(List<Car> carList, int winnerForwardMovementCount) {
        this.winnerCarNames = new ArrayList<>();
        Collections.reverse(carList);

        for (Car car : carList) {
            addNamesIfIsWinner(car, winnerForwardMovementCount);
        }
    }

    public List<CarName> getWinnerCarNames() {
        return winnerCarNames;
    }

    private void addNamesIfIsWinner(Car car, int winnerForwardMovementCount) {
        if(car.getForwardMovementCount() == winnerForwardMovementCount) {
            this.winnerCarNames.add(new CarName(car.getCarName().getCarName()));
        }
    }


}
