package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingManager {

    private RacingCar racingCar;
    int raceCount;

    public void play() {
        setUpRacingCar();
        setUpRaceCount();
        race();
        displayAward();
    }

    private void displayAward() {
        List<String> cars = RacingUtils.getWinners(racingCar.getCars());
        String winners = String.join(",", cars);
        System.out.println("최종 우승자 : " + winners);
    }

    private void race() {
        System.out.println();
        System.out.println("실행결과");
        for (int i = 0; i < raceCount; i++) {
            racingCar.racing();
        }
    }

    private void setUpRaceCount() {
        while(true) {
            try {
                String raceCount = getRaceCountByInput();
                isValidRaceCount(raceCount);
                this.raceCount =  Integer.parseInt(raceCount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidRaceCount(String raceCount) throws IllegalArgumentException {
        String regExpIsContainAnyNonNumber = ".*\\D.*";
        if(raceCount.matches(regExpIsContainAnyNonNumber))
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 0 이상의 숫자여야 합니다.");
    }

    private void setUpRacingCar() {
        while(true) {
            try {
                String carNames = getCarNameByInput();
                racingCar = new RacingCar(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private String getCarNameByInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }

    private static String getRaceCountByInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
