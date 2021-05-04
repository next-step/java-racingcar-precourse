package racingcar.domain;

import java.util.List;

import static racingcar.domain.constant.RacingCarConstant.SEPARATOR;

public class RacingCarGame {
    private static MoveCondition moveCondition = new MoveCondition();
    private static Cars cars;
    private static Round round;
    private static RaceRecords raceRecords;

    public RacingCarGame(String carNames, String round) {
        this.cars = new Cars(carNames.split(SEPARATOR));
        this.round = new Round(round);
        this.raceRecords = new RaceRecords();
    }

    public void play() {
        while (round.executable()) {
            executeRound();
        }
    }

    private void executeRound() {
        round.execute();
        cars.move(moveCondition);
        raceRecords.saveLapTime(cars.getCars());
    }

    public String getRaceRecords() {
        return raceRecords.getRaceRecords();
    }

    public List<Car> getWinner() {
        return cars.getWinners();
    }

}
