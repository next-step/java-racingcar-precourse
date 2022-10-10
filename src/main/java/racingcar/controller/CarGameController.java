package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.RepeatCount;
import racingcar.utils.RandomGenerator;
import racingcar.view.CarGameViewer;

public class CarGameController {
    private final CarGameViewer viewer = new CarGameViewer();
    private RepeatCount repeatCount;
    private final Cars cars = new Cars();

    public void startGame() {
        try {
            this.setCars(viewer.getCarNames());
            getRepeatCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.startGame();
        }
    }

    public void getRepeatCount() {
        try {
            this.repeatCount = new RepeatCount(viewer.getRepeatCount());
            this.proceedGame();
        } catch(IllegalArgumentException e ) {
            System.out.println(e.getMessage());
            this.getRepeatCount();
        }
    }

    public void proceedGame() {
        Integer repeatThisGame = this.repeatCount.getRepeatCount();
        while(repeatThisGame > 0) {
            this.movingCars();
            viewer.printCarsStatus(this.cars);
            repeatThisGame--;
        }
        viewer.printGameResult(this.cars.getWinners());
    }

    private void movingCars() {
        for(Car car : cars.getCars()) {
            RandomGenerator randomNumber = new RandomGenerator();
            car.moveCarPosition(randomNumber.getGeneratedNumber());
        }
    }

    private void setCars(String userCarNameInput) {
        String[] splitUserCarNameInputs = userCarNameInput.split(",");
        for(String splitUserCarNameInput : splitUserCarNameInputs) {
            CarName carName = new CarName(splitUserCarNameInput.trim());
            Car newCar = new Car(carName);
            cars.addCar(newCar);
        }
    }
}