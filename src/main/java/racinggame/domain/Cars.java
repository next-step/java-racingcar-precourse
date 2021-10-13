package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public Cars(List<Car> carList) {
        this.carList = carList;
    }


    public List<Car> getWinner() {
        Position maxPosition = findMaxPosition();
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : carList) {
            addWinner(car, maxPosition, winnerCars);
        }
        return winnerCars;
    }

    public void addWinner(Car car, Position position, List<Car> winnerCars) {
        if (car.isWinnerCar(position)) {
            winnerCars.add(car);
        }
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

}
