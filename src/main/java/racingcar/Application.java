package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.RacingCarModel;
import racingcar.model.RacingCarModelCommandLine;
import racingcar.view.RacingCarView;
import racingcar.view.RacingCarViewCommand;

public class Application {
    private static final RacingCarView baseballView = new RacingCarViewCommand();
    private static final RacingCarModel baseballModel = new RacingCarModelCommandLine();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController racingCarController = new RacingCarController(baseballView, baseballModel);
        racingCarController.play();
    }
}
