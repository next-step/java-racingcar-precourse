package racingcar.model.race;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;
import racingcar.constant.Racing;
import racingcar.model.car.Car;
import racingcar.model.car.collection.Cars;
import racingcar.model.race.wrap_variable.Input;
import racingcar.model.race.wrap_variable.NumberOfAttemptMove;
import racingcar.model.race.wrap_variable.WinnerDistance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {
    private Cars cars;
    private NumberOfAttemptMove numberOfAttemptMove;

    public Race() {
        this.cars = new Cars();
    }

    public void initCars() {
        this.cars = new Cars();
    }

    public void inputCars() {
        System.out.println(Message.INPUT_RACE_CARS_NAME);
        Input input = new Input(Console.readLine());
        generateCars(input);
    }

    public void inputNumberOfAttemptMove() {
        System.out.println(Message.INPUT_NUMBER_OF_ATTEMPT);
        Input input = new Input(Console.readLine());
        numberOfAttemptMove = new NumberOfAttemptMove(input.getInput());
    }

    public void start() {
        System.out.println(Message.RACE_RESULT);
        for (int i = 0; i < numberOfAttemptMove.getNumberOfAttemptMove(); i++) {
            carMove(cars.getCars());
        }
        raceResult(cars.getCars());
    }

    public void raceResult(List<Car> cars) {
        WinnerDistance winnerDistance = winnerDistance(cars);
        List<Car> winners = winners(cars, winnerDistance);

        printRaceDistance(cars);
        System.out.print(", ");
        printRaceWinner(winners);
    }

    private void printRaceDistance(List<Car> cars) {
        Iterator<Car> carIterator = cars.iterator();
        Car car = carIterator.next();
        System.out.print(car.getName() + " : " + car.getDistance().getStrDistance());
        while (carIterator.hasNext()) {
            car = carIterator.next();
            System.out.print(", " + car.getName() + " : " + car.getDistance().getStrDistance());
        }
    }

    private void printRaceWinner(List<Car> winners) {
        Iterator<Car> winnerIterator = winners.iterator();
        System.out.print(Message.FINAL_WINNER + winnerIterator.next().getName());
        while (winnerIterator.hasNext()) {
            System.out.print(", " + winnerIterator.next().getName());
        }
    }

    private WinnerDistance winnerDistance(List<Car> cars) {
        WinnerDistance winnerDistance = new WinnerDistance();
        for (Car car : cars) {
            setHighestWinnerDistance(winnerDistance, car);
        }
        return winnerDistance;
    }

    private static void setHighestWinnerDistance(WinnerDistance winnerDistance, Car car) {
        if (winnerDistance.getWinnerDistance() < car.getDistance().getIntDistance()) {
            winnerDistance.setWinnerDistance(car.getDistance().getIntDistance());
        }
    }

    private List<Car> winners(List<Car> cars, WinnerDistance winnerDistance) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            selectWinnerByWinnerDistance(winnerDistance, winners, car);
        }
        return winners;
    }

    private static void selectWinnerByWinnerDistance(WinnerDistance winnerDistance, List<Car> winners, Car car) {
        if (winnerDistance.getWinnerDistance() == car.getDistance().getIntDistance()) {
            winners.add(car);
        }
    }

    private void carMove(List<Car> cars) {
        for (Car car : cars) {
            randomMove(car);
        }
    }

    private void randomMove(Car car) {
        if (pickNumberInRange(0, 9) >= Racing.MOVING_FORWARD) {
            car.move();
        }
    }

    private void generateCars(Input input) {
        for (String token : input.getInput().split(",")) {
            cars.addCar(new Car(token));
        }
    }
}
