package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Car;

public class MaxValueFinder {
    public static int getMaxDistance(List<Car> cars) {
        ArrayList<Integer> distances = new ArrayList<>();
        cars.forEach(car -> {
            distances.add(car.getDistance());
        });
        distances.sort(Comparator.reverseOrder());
        return distances.get(0);
    }
}
