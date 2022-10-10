package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    
    private List<Car> winners;
    private Distance longestDistance = new Distance();

    Winners(List<Car> cars) {
        this.winners = pickWinners(cars); 
    }

    public List<String> getNames() {
        List<String> result = new ArrayList<>();
        
        for (Car winner : winners) {
            result.add(winner.getName());
        }

        return result;
    }
    
    private List<Car> pickWinners(List<Car> cars) {
        List<Car> result = new ArrayList<>();

        for (Car car : cars) {
            addLongestDistanceCars(result, car);
        }

        return result;
    }

    private void addLongestDistanceCars(List<Car> longestDistanceCars, Car car) {
        if (isNewLongestDistance(car.getDistance())) {
            longestDistanceCars.clear();
        }

        if (isLongestDistance(car.getDistance())) {
            longestDistanceCars.add(car);
        }
    }

    private boolean isNewLongestDistance(Distance distance) {
        if (longestDistance.lessThan(distance)) {
            longestDistance = distance;
            return true;
        }
        
        return false;
    }

    private boolean isLongestDistance(Distance distance) {
        return (longestDistance.equals(distance));
    }
}
