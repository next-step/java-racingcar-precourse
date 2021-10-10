package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.Car;
import racinggame.domain.CarNames;
import racinggame.domain.Laps;
import racinggame.utils.GameValidator;
import racinggame.utils.ValidateStatus;

public class InputView {

    public static CarNames inputCarNames() {
        CarNames carNames;
        ValidateStatus status;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNames = new CarNames(Console.readLine());
            status = GameValidator.validateCarName(carNames);
        } while (!status.isStatus());
        return carNames;
    }

    public static Laps inputLaps() {
        Laps laps;
        ValidateStatus status;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            laps = new Laps(Integer.parseInt(Console.readLine()));
            status = GameValidator.validateLaps(laps);
        } while (!status.isStatus());
        return laps;
    }
}
