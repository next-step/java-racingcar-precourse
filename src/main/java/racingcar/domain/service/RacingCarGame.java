package racingcar.domain.service;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.ParticipantCars;
import racingcar.utils.InputCarNames;
import racingcar.utils.InputMoveCount;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements Game {
    @Override
    public void run() {
        List<Car> cars = generateCars();
        ParticipantCars participantCars = new ParticipantCars(cars);
        int inputMoveCount = InputMoveCount.inputMoveCount();
        play(participantCars, inputMoveCount);
    }

    private List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames();
        for (String carName : carNames) {
            Car car = new Car(new CarName(carName));
            cars.add(car);
        }
        return cars;
    }

    private String[] inputCarNames() {
        String[] carNames = InputCarNames.inputCarNames();
        return carNames;
    }

    private void play(ParticipantCars participantCars, int inputMoveCount) {
        System.out.println();
        System.out.println("실행 결과");
        participantCars.moveParticipantCarsByInputCount(inputMoveCount);
        participantCars.printWinner();
    }
}
