package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.CarName;
import racingcar.domain.Round;
import racingcar.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private CarList carList;
    private Round round;
    private final GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void playing() {
        initCars();
        initRound();
        start();
    }

    private void initCars() {
        while (this.carList == null) {
            inputCars();
        }
    }

    private void inputCars() {
        try {
            gameView.printInputCarName();
            this.carList = new CarList(setCars(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Car> setCars(String readLine) {
        List<Car> carList = new ArrayList<>();
        for (String carName : readLine.trim().split(",")) {
            carList.add(new Car(new CarName(carName.trim())));
        }
        return carList;
    }

    private void initRound() {
        while (this.round == null) {
            inputRound();
        }
    }

    private void inputRound() {
        try {
            gameView.printInputRound();
            this.round = new Round(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void start() {
        gameView.printResult();
        for (int i = 0; i < round.getRound(); i++) {
            carList.progress();
            printCarsPosition(carList.getCarList());
            System.out.println();
        }
        List<String> winnerList = carList.getWinnerList();
        gameView.printWinnerCars(winnerList);
    }

    private void printCarsPosition(List<Car> cars) {
        cars.forEach(car -> gameView.printCarPosition(car.getCarName().getCarName(), car.getPosition()));
    }

}
