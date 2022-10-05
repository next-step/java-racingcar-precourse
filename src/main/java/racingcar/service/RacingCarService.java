package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Circuit;
import racingcar.model.Laps;
import racingcar.model.RacingCarList;
import racingcar.model.UserCarRacingRequest;
import racingcar.model.UserTrialRequest;

public class RacingCarService {

    private final Circuit circuit;

    public RacingCarService(Circuit circuit) {
        this.circuit = circuit;
    }

    /**
     * Receive UserCarRacingRequest and register the car list.
     *
     * @param userCarRacingRequest user's car list request
     */
    public void registerCarList(UserCarRacingRequest userCarRacingRequest) {
        String[] carNameArray = userCarRacingRequest.getCarNameArray();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNameArray.length; i++) {
            carList.add(Car.valueOf(carNameArray[i], 0));
        }
        circuit.setRacingCarList(RacingCarList.fromCarList(carList));
    }

    /**
     * Register laps by receiving UserTrialRequest.
     *
     * @param trialRequest user's trialRequest
     */
    public void registerLaps(UserTrialRequest trialRequest) {
        circuit.setLaps(Laps.from(trialRequest.getTrial()));
    }

    /**
     * Returns the current status of all cars.
     *
     * @return the current status of all cars.
     */
    public String[] getCurrentTrackStatus() {
        return circuit.getAllStatus();
    }

    /**
     * Returns true if there are currently remaining laps, false otherwise.
     *
     * @return about laps remaining
     */
    public boolean haveLaps() {
        return circuit.getCurrentLaps() > 0;
    }

    /**
     * Call the race of the circuit.
     */
    public void race() {
        circuit.race();
    }

    /**
     * Call the getWinnerListString of circuit.
     *
     * @return string of list of final winners car names
     */
    public String getWinnerListString() {
        return circuit.getWinnerListString();
    }
}
