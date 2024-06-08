package game.domain;

import game.exception.constant.ErrorMessage;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void move() {
        carList.forEach(Car::move);
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return carList.stream()
            .map(Car::getPosition)
            .max(Comparator.naturalOrder())
            .orElseThrow(() -> new NoSuchElementException(ErrorMessage.EMPTY_LIST.getMessage()));
    }
}
