package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.CarMessengerService;
import racingcar.service.RacingCarFacade;
import racingcar.service.RacingCarService;

public class AppConfig {

    public RacingCarController racingCarController() {
        return new RacingCarController(racingCarFacade());
    }

    public RacingCarFacade racingCarFacade() {
        return new RacingCarFacade(carMessengerService(), racingCarService());
    }

    public CarMessengerService carMessengerService() {
        return new CarMessengerService();
    }

    public RacingCarService racingCarService() {
        return new RacingCarService();
    }

}
