package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getMaxMovesCount() {
        List<Integer> movesCounts = new ArrayList<>();
        racingCars.forEach(racingCar -> movesCounts.add(racingCar.getMovesCount()));

        return Collections.max(movesCounts);
    }

    public List<RacingCar> getWinners() {
        List<RacingCar> winners = new ArrayList<>();
        racingCars.forEach(racingCar -> {
            if (getMaxMovesCount() == racingCar.getMovesCount()) {
                winners.add(racingCar);
            }
        });
        return winners;
    }

    public StringBuilder getWinnersRacingCarName() {
        StringBuilder racingGameResult = new StringBuilder();
        getWinners().forEach(racingCar -> {
            racingGameResult.append(racingCar.getRacingCarName()).append(",");
        });
        return racingGameResult.replace(racingGameResult.length() - 1, racingGameResult.length(), " ");
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("최종 우승자는 ")
                .append(getWinnersRacingCarName())
                .append("입니다.")
                .toString();
    }
}
