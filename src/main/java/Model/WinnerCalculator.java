package Model;

import java.util.*;

public class WinnerCalculator {

    public List<String> calculateWinners(RacingCarsVO[] cars) {
        int maxMove = 0;
        for (RacingCarsVO car : cars) {
            if (car.getMove() > maxMove) {
                maxMove = car.getMove();
            }
        }
        List<String> winners = new ArrayList<>();
        for (RacingCarsVO car : cars) {
            if (car.getMove() == maxMove) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
