package racingcar.nextstep.global.config;

import racingcar.nextstep.domain.car.service.CarCreator;
import racingcar.nextstep.domain.car.service.CarService;
import racingcar.nextstep.domain.racing.service.*;
import racingcar.nextstep.infrastructure.car.CarCreatorImpl;
import racingcar.nextstep.infrastructure.car.CarServiceImpl;
import racingcar.nextstep.infrastructure.racing.*;
import racingcar.nextstep.interfaces.RacingController;

public class AppConfig {

    public RacingController racingController() {
        return new RacingController(carService(), racingService());
    }

    public RacingService racingService() {
        return new RacingServiceImpl(racingMessenger(), racingValidator(), racingFactory(), racingReferee());
    }

    public RacingMessenger racingMessenger() {
        return new RacingMessengerImpl();
    }

    public RacingValidator racingValidator() {
        return new RacingValidatorImpl();
    }

    public RacingFactory racingFactory() {
        return new RacingFactoryImpl();
    }

    public RacingReferee racingReferee() {
        return new RacingRefereeImpl();
    }

    public CarService carService() {
        return new CarServiceImpl(carCreator());
    }

    public CarCreator carCreator() {
        return new CarCreatorImpl();
    }

}
