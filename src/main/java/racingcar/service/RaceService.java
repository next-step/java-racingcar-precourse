package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Joiners;
import racingcar.domain.Player;
import racingcar.domain.RoundStatus;
import racingcar.domain.response.CarRaceResult;
import racingcar.domain.response.PlayResult;
import racingcar.domain.response.RoundResult;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.GuideMessagePrinter.printRoundResult;

/**
 * @author : choi-ys
 * @date : 2022/04/23 4:53 오후
 */
public class RaceService {
    private final RandomNumberService randomNumberService;

    public RaceService(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    public CarRaceResult playSingleRoundByCar(Car car, int currentRound) {
        randomNumberService.generateSingleRoundRandomNumberByCar(car);
        if (isMoving(car, currentRound)) {
            car.addScore();
            return new CarRaceResult(car, RoundStatus.GO);
        }
        return new CarRaceResult(car, RoundStatus.STOP);
    }

    private boolean isMoving(Car car, int currentRound) {
        return car.getCarNumbers().getRandomNumberByRound(currentRound) >= 4;
    }

    public RoundResult playSingleRoundByCars(Joiners joiners, int currentRound) {
        List<CarRaceResult> carRaceResults = new ArrayList<>();
        for (Car car : joiners.getCars()) {
            carRaceResults.add(playSingleRoundByCar(car, currentRound));
        }
        return RoundResult.of(currentRound, carRaceResults);
    }

    public PlayResult play(Joiners joiners, Player player) {
        for (int i = 1; i <= player.getTotalRound(); i++) {
            printRoundResult(playSingleRoundByCars(joiners, i));
        }
        return new PlayResult(joiners);
    }
}
