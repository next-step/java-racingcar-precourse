package racingcar.appconfig;

import racingcar.model.service.RaceService;
import racingcar.model.service.RaceServiceImpl;

public class AppConfig {
    public RaceService raceService() {
        return new RaceServiceImpl();
    }
}



