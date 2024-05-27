package domain.race.controller;

import domain.race.service.RaceService;

public class RaceController {

    RaceService raceService = new RaceService();

    private final static String INVALID_CAR_NAMES = "자동차 이름이 잘못 입력되었습니다. 다시 입력해 주세요.";
    private final static String CAR_NAME_OVER_LENGTH = "자동차 이름의 길이는 5 이하여야 합니다. 다시 입력해 주세요.";
    private final static String INVALID_ROUND = "라운드가 잘못 입력되었습니다. 다시 입력해 주세요.";

    // 정상적인 입력이 주어졌을 때 경주를 시작하는 함수
    public void startRace(String carNames, int round) {
        raceService.startRace(carNames, round);
    }

    // carNames 입력값이 정상인지 validation 수행하는 함수
    public boolean canUseCarNames(String carNames) {
        try {
            if (carNames.isEmpty()) throw new IllegalArgumentException(INVALID_CAR_NAMES);
            if (carNames.charAt(0) == ',') throw new IllegalArgumentException(INVALID_CAR_NAMES);
            if (carNames.charAt(carNames.length() - 1) == ',') throw new IllegalArgumentException(INVALID_CAR_NAMES);
            allLengthIsLessThanFive(carNames);
            return true;
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] : " + exception.getMessage());
            return false;
        }
    }

    // carName 각각이 길이가 5 이하인지 검증하는 함수
    public void allLengthIsLessThanFive(String carNames){
        String[] names = carNames.split(",");
        for(String name : names){
            if(name.length() > 5){
                throw new IllegalArgumentException(CAR_NAME_OVER_LENGTH);
            }
        }
    }

    // round 입력값이 정상인지 validation 수행하는 함수
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
