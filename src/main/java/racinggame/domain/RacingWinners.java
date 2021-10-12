package racinggame.domain;

import java.util.List;

public class RacingWinners {
    private final List<RacingCar> winners;

    public RacingWinners(final List<RacingCar> winners) {
        this.winners = winners;
    }

    public List<RacingCar> getWinners() {
        return winners;
    }

    public StringBuilder getWinnersRacingCarName() {
        StringBuilder racingGameResult = new StringBuilder();
        getWinners().forEach(racingCar -> racingGameResult.append(racingCar.getRacingCarName()).append(","));
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
