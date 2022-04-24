package racingcar.service;

import java.util.List;
import racingcar.constant.Delimiter;
import racingcar.constant.MoveStatus;
import racingcar.utils.RandomNumberUtils;
import racingcar.utils.SplitUtils;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

public class RacingCarPlayService {

    private final RacingCarMoveService racingCarMoveService;

    public RacingCarPlayService() {
        racingCarMoveService = new RacingCarMoveService();
    }

    public RacingCars registerRacingCars(String inputCarNames) {
        List<String> inputCarNameList = SplitUtils.splitToList(inputCarNames, Delimiter.COMMA);
        return new RacingCars(inputCarNameList);
    }

    public RacingCars proceedGame(RacingCars racingCars, int round) {
        for (int count = 0; count < round; count++) {
            playRacingCarRound(racingCars);
        }
        return racingCars;
    }

    private void playRacingCarRound(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCarList()) {
            MoveStatus moveStatus = racingCarMoveService
                    .getMoveStatus(RandomNumberUtils.getRandomNumberFromZeroToNine());
            racingCar.updateLocation(moveStatus);
        }
    }
}
