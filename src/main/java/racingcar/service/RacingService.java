package racingcar.service;

import racingcar.domain.*;
import racingcar.value.OutputMessage;
import racingcar.dto.CarsDto;
import racingcar.dto.TrackDto;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final CarService carservice;
    private final InputService inputService;
    private final Racing racing;

    public RacingService(InputService inputService) {
        this.carservice = new CarService();
        this.inputService = inputService;
        this.racing = ready();
    }

    public Racing ready() {
        return Racing.of(initCars(), initTrack());
    }

    public Cars initCars() {
        try {
            OutputService.printInput(OutputMessage.INPUT_CAR);
            return new CarsDto(inputService.getCars()).toDomain();
        } catch (IllegalArgumentException e) {
            OutputService.inputArgumentError(e);
            return initCars();
        }
    }

    public Track initTrack() {
        try {
            OutputService.printInput(OutputMessage.INPUT_TRACK);
            return new TrackDto(inputService.getTrack()).toDomain();
        } catch (IllegalArgumentException e) {
            OutputService.inputArgumentError(e);
            return initTrack();
        }
    }

    public void start() {
        OutputService.printExecute();

        do {
            carRacing();
            OutputService.printLine();
        } while (!racing.isEnd());

        OutputService.printWinner(racing.getWinners());
    }

    public void carRacing() {
        List<Car> cars = new ArrayList<>();

        for (Car car : racing.getCars().getCars()) {
            moveCar(car);
            if (winnerCar(car)) cars.add(car);
        }

        racing.setWinners(Winners.of(cars));
    }

    private boolean winnerCar(Car car) {
        return car.getMove().getDistance() == racing.getTrack().getCount();
    }

    private void moveCar(Car car) {
        carservice.move(car);
    }
}
