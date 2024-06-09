package controller;

import java.util.ArrayList;
import model.Car;
import view.InputView;
import view.OutputView;

public class RacingCarGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final int MAX_NAME_LENGTH = 5;

    public void racingGame() {
        ArrayList<Car> cars = new ArrayList<>();
        input(cars);
        System.out.println();
        output(cars);
    }

    private ArrayList<Car> input(ArrayList<Car> cars) throws IllegalArgumentException {
        inputView.inputName();

        for (String name : inputView.getCarNames()) {
            if (!checkNameLength(name)) {
                return input(cars);
            }
            cars.add(new Car(name));
        }

        inputView.inputIteration();

        return cars;
    }

    private boolean checkNameLength(String name) {
        try {
            if (name.length() > MAX_NAME_LENGTH + 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 이름은 " + MAX_NAME_LENGTH + "자 이하만 가능합니다." + name + " 부분부터 다시 입력해 주세요.");
            return false;
        }

        return true;
    }

    private void output(ArrayList<Car> cars){
        outputView.showExecutionResult();

        for (int i = 0; i < inputView.getIteration(); i++) {
            for (Car car : cars) {
                car.moveForward();
                outputView.showCarMove(car);
            }
            System.out.println();
        }

        outputView.showWinner(cars);
    }

}
