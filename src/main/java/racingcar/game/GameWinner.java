package racingcar.game;

import racingcar.car.Car;
import racingcar.car.CarName;
import racingcar.car.CarPosition;
import racingcar.game.dto.WinnerResult;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameWinner {


    public List<WinnerResult> selectWinner(List<Car> cars) {
        List<WinnerResult> winnerResults = new LinkedList<>();
        Collections.sort(cars, Collections.reverseOrder());
        CarPosition winnerPosition = cars.get(0).getPosition();
        for (Car car : cars) {
            CarPosition carPosition = car.getPosition();
            CarName carName = car.getCarName();
            if (isMaxPosition(winnerPosition, carPosition)) {
                winnerResults.add(new WinnerResult(carName.getName()));
            }
        }
        return winnerResults;
    }

    private boolean isMaxPosition(CarPosition maxPosition, CarPosition otherPosition) {
        return maxPosition.getPosition() == otherPosition.getPosition();
    }
}
