package racingcar.domain;

import racingcar.domain.Car.RaceCar;

import java.util.Scanner;

public class RaceManager {

    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT = "시도할 회수는 몇회인가요?";

    private RaceCar raceCar;

    public void run() {
        final Scanner scanner = new Scanner(System.in);
        // 자동차 생성
        raceCar.generateRaceCars(scanner);


    }

}
