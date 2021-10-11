package racinggame.controller;

import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;

import java.util.List;

import static nextstep.utils.Console.readLine;
import static nextstep.utils.Randoms.pickNumberInRange;
import static racinggame.domain.GameConfig.END_INCLUSIVE;
import static racinggame.domain.GameConfig.START_INCLUSIVE;
import static racinggame.utils.RacingGameUtils.*;

public class GameController {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        RacingCars racingCars = new RacingCars(getRacingCarList(readLine()));

        System.out.println("시도할 회수는 몇회인가요?");
        int validTryCount = isValidTryCount(readLine());

        System.out.println("실행 결과");
        List<RacingCar> racingCarList = racingCars.getRacingCars();

        for (int i = 0; i < validTryCount; i++) {
            racingCarList.forEach(racingCar -> {
                if (isMoved(pickNumberInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue()))) {
                    racingCar.move();
                }
            });

            racingCarList.forEach(System.out::println);
        }

        System.out.println(racingCars);
    }
}
