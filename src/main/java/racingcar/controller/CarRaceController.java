package racingcar.controller;

import racingcar.domain.CarEntry;
import racingcar.domain.Circuit;
import racingcar.domain.Result;
import racingcar.service.*;

public class CarRaceController {
    private CarRaceService carRaceService;
    private CarEntryService carEntryService;
    private CircuitService circuitService;
    private ResultService resultService;

    public CarRaceController(CarEntryService carEntryService, CircuitService circuitService) {
        this.carEntryService = carEntryService;
        this.circuitService = circuitService;
    }

    public void run() {
        CarEntry entry = carEntryService.makeCarRaceEntity();
        Circuit circuit = circuitService.makeCarRaceCircuit();
        carRaceService = new CarRaceService(entry, circuit);
        Result result = carRaceService.start();
        resultService = new ResultService(result);
        resultService.printResult();
    }
}
