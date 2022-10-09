package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winnerList;

    public Winners() {
        winnerList = new ArrayList<>();
    }

    public void addCarInMaxPosition(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winnerList.add(car);
        }
    }

    public List<Car> getAll() {
        return winnerList;
    }
}
