package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class PlayResult {

    private List<Car> carList;

    public PlayResult(List<Car> carList) {
        this.carList = carList;
    }

    public void printWinnerNames() {
        GuideMessage.우승자_안내.printMessage();
        System.out.println(getWinnerNames());
    }

    public String getWinnerNames() {
        Car winner = Collections.max(carList);
        return appendCoWinnerNames(winner).toString();
    }

    private StringBuilder appendCoWinnerNames(final Car winner) {
        StringBuilder sb = new StringBuilder();
        sb.append(winner.getName());
        for (Car car : carList) {
            if (!winner.getName().equals(car.getName())
                    && winner.getPosition() == car.getPosition()) {
                sb.append(", " + car.getName());
            }
        }
        return sb;
    }

}
