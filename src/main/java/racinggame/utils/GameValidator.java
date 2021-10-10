package racinggame.utils;

import racinggame.domain.CarNames;
import racinggame.domain.Laps;

public class GameValidator {

    private static final int MIN_LAPS = 1;

    public static final int CAR_NAME_MAX_LENGTH = 5;

    public static final int MIN_ENTRY = 2;

    public static final String ERROR_CAR_NAME_MAX_LENGTH = "[ERROR] 자동차의 이름은 5글자 이하여야 합니다.";

    public static final String ERROR_ENTRY_MIN = "[ERROR] 최소 2대 이상의 참가자가 필요합나다.";

    public static final String ERROR_LAPS_MIN = "[ERROR] 최소 1바퀴 이상을 진행해야 합니다.";

    public static ValidateStatus validateCarName(CarNames carNames) {
        try {
            GameValidator.validateCarName(carNames.entryCarNameArray());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ValidateStatus(false);
        }
        return new ValidateStatus(true);
    }

    public static ValidateStatus validateLaps(Laps laps) {
        try {
            GameValidator.checkLaps(laps);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ValidateStatus(false);
        }
        return new ValidateStatus(true);
    }

    private static void validateCarName(String[] carNames) throws Exception {
        if (carNames.length < MIN_ENTRY) {
            throw new Exception(ERROR_ENTRY_MIN);
        }
        for (String carName : carNames) {
            checkCarNameLength(carName);
        }
    }

    private static void checkCarNameLength(String carName) throws Exception {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new Exception(ERROR_CAR_NAME_MAX_LENGTH);
        }
    }

    private static void checkLaps(Laps laps) throws Exception {
        if (laps.getLaps() < MIN_LAPS) {
            throw new Exception(ERROR_LAPS_MIN);
        }
    }
}
