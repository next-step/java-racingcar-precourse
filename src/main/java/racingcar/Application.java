package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.service.CarEntryService;
import racingcar.service.CircuitService;

public class Application {
    public static void main(String[] args) {
        CarEntryService carEntryService = new CarEntryService();
        CircuitService circuitService = new CircuitService();

        CarRaceController carRaceController = new CarRaceController(carEntryService, circuitService);
        carRaceController.run();
    }
}
