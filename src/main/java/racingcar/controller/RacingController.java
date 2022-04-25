package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.service.Service;

public class RacingController {

    public void run(){
        Service service = new RacingService();
        service.start();
    }
}
