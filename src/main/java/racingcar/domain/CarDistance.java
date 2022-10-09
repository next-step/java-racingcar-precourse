package racingcar.domain;

import java.util.*;

public class CarDistance {
    private static final String EMPTY = "";

    private Map<String, Integer> carToDistance;

    public CarDistance(List<Car> cars) {
        this.carToDistance = convertCarToDistance(cars);
    }

    private Map<String, Integer> convertCarToDistance(List<Car> cars) {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), calculateDistance(car.getDistances()));
        }

        return result;
    }

    private int calculateDistance(ArrayList<Boolean> distances) {
        int carDistance = 0;

        for (Boolean distance : distances) {
            carDistance = increaseIfMove(distance, carDistance);
        }

        return carDistance;
    }

    private int increaseIfMove(Boolean isMove, int distance) {
        if (isMove) {
            return distance + 1;
        }

        return distance;
    }

    public List<String> winner() {
        List<String> winnerNames = new ArrayList<>();
        int highestDistance = getHighestDistance();

        for (Map.Entry<String, Integer> entry : carToDistance.entrySet()) {
            winnerNames.add(findMultiWinner(entry, highestDistance));
        }

        winnerNames.removeIf(String::isEmpty);
        return winnerNames;
    }

    private int getHighestDistance() {
        int highestDistance = -1;
        for (Map.Entry<String, Integer> entry : carToDistance.entrySet()) {
            highestDistance = returnHighestDistance(entry.getValue(), highestDistance);
        }

        return highestDistance;
    }

    private int returnHighestDistance(int carMoveDistance, int highestDistance) {
        if (carMoveDistance > highestDistance) {
            return carMoveDistance;
        }

        return highestDistance;
    }

    private String findMultiWinner(Map.Entry<String, Integer> entry, int highestDistance) {
        if (entry.getValue() != highestDistance) {
            return EMPTY;
        }

        return entry.getKey();
    }
}
