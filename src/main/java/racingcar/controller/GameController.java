package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGameService;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {
    RacingGameService racingCarService;

    public void play() {
        String carsName = inputCarsName();
        int tryCnt = inputTryCnt();

        racingCarService = new RacingGameService(carsName, tryCnt);
        racingCarService.play();
    }

    private int inputTryCnt() {
        int tryCnt;
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            tryCnt = Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("tryCnt is not Number");
        }

        return tryCnt;
    }

    private String inputCarsName() {
        String carsName;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        carsName = readLine();

        return carsName;
    }
}
