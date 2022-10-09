package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Cars;

public class InputCarName {
    private static final String INPUT_DRIVER_NAME_MSG = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";

    public Cars getCars() {
        Cars cars = null;
        try {
            System.out.println(INPUT_DRIVER_NAME_MSG);
            cars = new Cars(Console.readLine());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }
}
