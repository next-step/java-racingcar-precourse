package model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarStates {

    private final List<CarState> carStates;

    public CarStates(List<CarState> carStates) {
        this.carStates = carStates;
    }

    public List<CarState> getCarStates() {
        return carStates;
    }

    public List<String> getFrontRunnerNames() {
        return carStates.stream()
            .filter(carState -> carState.getPosition() == getFrontRunnerPosition())
            .map(CarState::getCarName)
            .collect(Collectors.toList());
    }

    private int getFrontRunnerPosition() {
        return carStates.stream()
            .mapToInt(CarState::getPosition)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }
}