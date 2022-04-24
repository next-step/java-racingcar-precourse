package racingcar.core.infrastructure.config;

import racingcar.controller.RacingGameController;
import racingcar.controller.RacingGameControllerImpl;
import racingcar.core.common.helper.NsPickNumberStrategy;
import racingcar.core.common.helper.PickNumberStrategy;
import racingcar.service.RacingGameService;
import racingcar.service.RacingGameServiceImpl;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameInputViewImpl;
import racingcar.view.RacingGameOutputView;
import racingcar.view.RacingGameOutputViewImpl;

public class AppConfig {

    public RacingGameInputView racingGameInputView() {
        return new RacingGameInputViewImpl();
    }

    public RacingGameOutputView racingGameOutputView() {
        return new RacingGameOutputViewImpl();
    }

    public PickNumberStrategy pickNumberStrategy() {
        return new NsPickNumberStrategy();
    }

    public RacingGameService racingGameService() {
        return new RacingGameServiceImpl(pickNumberStrategy());
    }

    public RacingGameController racingGameController() {
        return new RacingGameControllerImpl(racingGameInputView(), racingGameOutputView(), racingGameService());
    }
}