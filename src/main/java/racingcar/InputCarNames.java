package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;

public class InputCarNames implements Input<Cars> {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";

    @Override
    public Cars input() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        Cars cars;
        do {
            cars = make();
        } while (cars == null);

        return cars;
    }

    @Override
    public Cars make() {
        try {
            return new Cars(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
