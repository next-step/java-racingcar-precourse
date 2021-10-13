package racinggame.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public String proceedRace() {
        StringBuilder sb = new StringBuilder();
        for (Car car : racingCars) {
            car.moving(Randoms.pickNumberInRange(0, 9));
            sb.append(car.getCarName() + " : ")
                    .append(car.displayDistance(car))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getWinner() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : racingCars) {
            compareDistance(Collections.max(racingCars).getDistance().getDistance(), car, winnerList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자는 ")
                .append(String.join(",", winnerList))
                .append(" 입니다.");

        return sb.toString();
    }

    private void compareDistance(int distance, Car car, List<String> winnerList) {
        if (distance == car.getDistance().getDistance()) {
            winnerList.add(car.getCarName());
        }
    }

}
