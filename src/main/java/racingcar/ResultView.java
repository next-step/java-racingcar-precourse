package racingcar;

import java.util.List;

public class ResultView {
    public void printRoundResult(Race race) {
        for (Car car : race.getCars()) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
