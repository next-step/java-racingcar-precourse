package racingcar.application.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import racingcar.application.port.in.PlayRacingCommand;
import racingcar.application.port.in.PlayRacingUsecase;
import racingcar.application.port.out.GetRacingCarPort;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.domain.RoundResult;

@AllArgsConstructor
public class PlayRacingService implements PlayRacingUsecase {
    private static final int MIN_MOVABLE_NUM = 4;
    private final GetRacingCarPort getRacingCarPort;

    @Override
    public RacingResult playRacing(PlayRacingCommand command) {
        List<RoundResult> roundResultList = new ArrayList<>();
        int totalRaceRound = command.getTotalRaceRound().getValue();
        int currentRound = 0;

        while (currentRound < totalRaceRound) {
            roundResultList.add(startRacing(currentRound++));
        }

        return new RacingResult(roundResultList);
    }

    private RoundResult startRacing(int roundNum) {
        RacingCars racingCars = getRacingCarPort.getRacingCars();

        for (RacingCar car : racingCars.getSortedRacingCars()) {
            moveCar(car);
        }

        return new RoundResult(roundNum, RacingCars.newInstance(racingCars));
    }

    private void moveCar(RacingCar car) {
        int randomValue = Randoms.pickNumberInRange(0, 9);

        if (randomValue >= MIN_MOVABLE_NUM) {
            car.move();
        }

    }
}
