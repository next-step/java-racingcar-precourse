package domain.race.controller;

import domain.race.service.RaceService;

public class RaceController {

    RaceService raceService = new RaceService();

    public void startRace(String carNames, int round) {
        raceService.startRace(carNames, round);
    }

    public boolean canRace(String carNames, int round) {
        try {
            if (!validationCarNames(carNames)) {
                throw new IllegalArgumentException("자동차 이름이 잘못 입력되었습니다. 다시 입력해 주세요.");
            }
            if (!validationRound(round)) {
                throw new IllegalArgumentException("라운드가 잘못 입력되었습니다.. 다시 입력해 주세요.");
            }
            return true;
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
            return false;
        }
    }

    public boolean validationCarNames(String carNames) {
        if (carNames.isEmpty()) return false;
        if (carNames.charAt(0) == ',') return false;
        if (carNames.charAt(carNames.length() - 1) == ',') return false;
        return true;
    }

    public boolean validationRound(int round) {
        if (round <= 0) return false;
        return true;
    }
}
