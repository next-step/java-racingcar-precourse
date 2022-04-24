package racingcar.damain;

import java.util.Collections;
import java.util.List;

public class WinnerStatus {

    private List<Car> winners;
    private int positionFirst;

    private void add(Car car) {
        winners.add(car);
    }

    public List<Car> getWinners() {
        return winners;
    }

    public void raceResult(Cars cars) {
        this.positionFirst = Collections.max(cars.getCars()).getPosition();
        winners = cars.getWinners(positionFirst);
        showRaceResult();
    }

    public void showRaceResult() {
        System.out.print("최종 우승자: " + winnersName());
    }

    private String winnersName() {
        StringBuilder winnersName = new StringBuilder();
        for (Car car : winners)
            winnersName.append(", " + car.getCarName());

        if (winnersName.length() > 0 && ", ".equals(winnersName.substring(0, 2)))
            return winnersName.substring(2);

        return winnersName.toString();
    }
}
