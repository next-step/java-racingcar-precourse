package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validators.CarNameValidator;
import racingcar.validators.GameCountValidator;

import java.util.HashMap;

public class GameLandingView extends View {

    @Override
    public void render() {
        System.out.println("경주할 자동차의 이름(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        for (String carName : carNames.split(",")) {
            new CarNameValidator(carName).validate();
        }
        this.getRequestData().put("carNames", carNames);
        System.out.println("시도할 횟수는 몇회인가요?");

        String gameCount = Console.readLine();
        new GameCountValidator(gameCount).validate();
        this.getRequestData().put("gameCount", gameCount);
    }
}
