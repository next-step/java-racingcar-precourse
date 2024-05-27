package domain.race.controller;

import domain.race.service.RaceService;

public class RaceController {

    RaceService raceService = new RaceService();

    private final static String INVALID_CAR_NAMES = "자동차 이름이 잘못 입력되었습니다. 다시 입력해 주세요.";
    private final static String INVALID_ROUND = "라운드가 잘못 입력되었습니다. 다시 입력해 주세요.";

    public void startRace(String carNames, int round) {
        raceService.startRace(carNames, round);
    }

    public boolean canUseCarNames(String carNames) {
        try {
            if (carNames.isEmpty()) throw new IllegalArgumentException(INVALID_CAR_NAMES);
            if (carNames.charAt(0) == ',') throw new IllegalArgumentException(INVALID_CAR_NAMES);
            if (carNames.charAt(carNames.length() - 1) == ',') throw new IllegalArgumentException(INVALID_CAR_NAMES);
            return true;
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] : " + exception.getMessage());
            return false;
        }
    }

    public boolean canUseRound(String roundString) {
        try {
            int round = Integer.parseInt(roundString);
            if (round <= 0) throw new IllegalArgumentException(INVALID_ROUND);
            return true;
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] : " + INVALID_ROUND);
            return false;
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] : " + exception.getMessage());
            return false;
        }
    }
}
