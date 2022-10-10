package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private static final int INITIAL_MAX_POSITION = 0;

    private final List<Car> carList;
    private final List<Winner> winnerList;

    public Winners(List<Car> carList) {
        this.carList = carList;
        this.winnerList = new ArrayList<>();
    }

    public List<Winner> get() {
        return findWinners(maxPosition());
    }

    private int maxPosition() {
        int maxPosition = INITIAL_MAX_POSITION;
        for (Car car : carList) {
            if (car.isMaxPosition(maxPosition)) {
                maxPosition = car.position();
            }
        }
        return maxPosition;
    }

    private List<Winner> findWinners(int maxPosition) {
        for (Car car : carList) {
            if (car.isMaxPosition(maxPosition)) {
                winnerList.add(new Winner(car.getName()));
            }
        }
        return winnerList;
    }
}
