package racingcar.contoller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Cars cars;
    private int tryNumber;
    private List<Integer> randomDistances;

    public void play() {
        cars = createCars();
        tryNumber = getTryNumber();
        int raceCount = 0;
        OutputView.printExecutionResultInstruction();
        while(raceCount < tryNumber) {
            randomDistances = makeRandomDistances(cars.getNumberOfCars());
            cars.moveCars(randomDistances);
            OutputView.printExecutionResult(cars);
            raceCount += 1;
        }
        List<Car> winners = getWinners(cars);
        OutputView.printFinalWinners(winners);
    }

    private List<Integer> makeRandomDistances(int numberOfCars) {
        List<Integer> randomDistances = new ArrayList<>();
        for(int i=0; i<numberOfCars; i++){
            randomDistances.add(Randoms.pickNumberInRange(0,9));
        }
        return randomDistances;
    }

    private int getTryNumber() {
        return InputView.requestTryNumber();
    }

    private static Cars createCars() {
        List<Car> cars = new ArrayList();
        String[] inputCarNames = InputView.requestCarNames();
        for(String carName : inputCarNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<Car> getWinners(Cars cars) {
        int max = 0;
        List<Car> winners = new ArrayList<>();
        for(Car car: cars.getCars()) {
            if(max < car.getPosition())
                max = car.getPosition();
        }
        for(Car car: cars.getCars()) {
            if(max == car.getPosition())
                winners.add(car);
        }
        return winners;
    }
}
