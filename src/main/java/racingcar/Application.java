package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.fuel.FuelGenerator;
import racingcar.domain.fuel.RandomFuelGenerateStrategy;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(
                new FuelGenerator(new RandomFuelGenerateStrategy()),
                new RacingCarInput(),
                new RacingCarView()
        );
        racingCarController.play();
    }
}
