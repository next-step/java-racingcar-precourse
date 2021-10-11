package racinggame.controller;


import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.model.Racing;
import racinggame.view.RacingView;

public class RacingController {
    private Racing racing;
    private RacingView view;

    public RacingController(Racing racing, RacingView view) {
        this.racing = racing;
        this.view = view;
    }

    public boolean inputCarsName() {
        try {
            view.printInputCarsName();
            racing.makeCarsByInputName(view.inputCarsName());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean inputTryNo() {
        try {
            view.printInputTryNumber();
            racing.setTryNum(view.inputTryNumber());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void printOneCycleResult() {
        Cars cars = racing.getCars();
        racing.playOneCycle(cars);
        view.printPlayResult();
        for(Car car : cars.getCars()) {
            view.printCarName(car.getName());
            view.printGoStatus(car.getScore());
        }
    }

    public void playRacing() {
        while (true) {
            if (inputCarsName()) break;
        }
        while (true) {
            if (inputTryNo()) break;
        }
        for(int i = 0; i < racing.getTryNum(); i++) {
            printOneCycleResult();
        }

        view.printWinner(racing.getWinner(racing.getCars()));
    }
}
