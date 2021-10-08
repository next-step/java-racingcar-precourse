package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;

public class OutputView {
    public void printCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s: %s%n", car.getName(), positionToGauge(car.getPosition()));
        }
        System.out.println();
    }

    private String positionToGauge(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
