package racingcar.model;

import static racingcar.constant.Message.RACE_FINAL_WINNER;

import java.util.List;
import org.assertj.core.util.Lists;

public class RacingJudge {
    private List<Car> carList;

    public RacingJudge(List<Car> carList) {
        this.carList = carList;
    }

    public void judgeWinner() {
        List<Car> winners = findWinners();
        String winnerNames = convertWinnerNames(winners);
        System.out.println(RACE_FINAL_WINNER + winnerNames);
    }

    public List<Car> findWinners() {
        List<Car> winners = Lists.newArrayList();
        for (Car newCar : carList) {
            winners = findWinner(winners, newCar);
        }

        return winners;
    }


    private List<Car> findWinner(List<Car> winners, Car newCar) {
        if (winners.isEmpty()) {
            winners.add(newCar);
            return winners;
        }

        return findWinnerByCompareGoCount(winners, newCar);
    }

    private List<Car> findWinnerByCompareGoCount(List<Car> winners, Car newCar) {
        Car anyWinnerCar = winners.get(0);
        if (anyWinnerCar.getGoCount() > newCar.getGoCount()) {
            return winners;
        }
        if (anyWinnerCar.getGoCount() < newCar.getGoCount()) {
            winners.clear();
        }
        winners.add(newCar);
        return winners;
    }

    private String convertWinnerNames(List<Car> winners) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winners.size() - 1; i++) {
            builder.append(winners.get(i).getName() + ", ");
        }

        builder.append(winners.get(winners.size() - 1).getName());

        return builder.toString();
    }
}
