package racingcar.service;

import java.util.List;
import racingcar.constant.Delimiter;
import racingcar.constant.ErrorMessage;
import racingcar.constant.MoveStatus;
import racingcar.utils.RandomNumberUtils;
import racingcar.utils.SplitUtils;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

public class RacingCarPlayService {

    private static final String INPUT_ZERO = "0";

    private final RacingCarMoveService racingCarMoveService;

    public RacingCarPlayService() {
        racingCarMoveService = new RacingCarMoveService();
    }

    public RacingCars registerRacingCars(String inputCarNames) {
        List<String> inputCarNameList = SplitUtils.splitToList(inputCarNames, Delimiter.COMMA);
        return new RacingCars(inputCarNameList);
    }

    public RacingCars proceedGame(RacingCars racingCars, String inputRound) {
        validateRoundPositiveNumber(inputRound);
        int round = parseRoundCount(inputRound);
        for (int count = 0; count < round; count++) {
            playRacingCarRound(racingCars);
        }
        return racingCars;
    }

    private void validateRoundPositiveNumber(String inputRound) {
        if (!inputRound.matches("\\p{Digit}+") || INPUT_ZERO.equals(inputRound)) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_NOT_POSITIVE_NUMBER);
        }
    }

    private int parseRoundCount(String inputRound) {
        int round;
        try {
            round = Integer.parseInt(inputRound);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ROUND_NOT_RANGE);
        }
        return round;
    }

    private void playRacingCarRound(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCarList()) {
            MoveStatus moveStatus = racingCarMoveService
                    .getMoveStatus(RandomNumberUtils.getRandomNumberFromZeroToNine());
            racingCar.updateLocation(moveStatus);
        }
    }
}
