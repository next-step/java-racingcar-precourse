package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<CarName> winnerList = new ArrayList<>();
    private int maxScore = 0;
    StringBuilder sb = new StringBuilder();

    public void addWinner(String carName) {
        this.winnerList.add(new CarName(carName));
    }

    public List<CarName> winnersName() {
        return new ArrayList<>(winnerList);
    }

    public String getWinnersName(List<Car> cars) {
        for (Car car : cars) {
            maxScore = getMaxScore(maxScore, sb, car);
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    private int getMaxScore(int maxScore, StringBuilder sb, Car car) {
        if (car.getScore().getScore() >= maxScore) {
            maxScore = car.getScore().getScore();
            sb.append(car.getCarName().getCarName() + ", ");
        }
        return maxScore;
    }
}
