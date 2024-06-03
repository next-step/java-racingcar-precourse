package controller;

import model.CarFactory;
import view.InputView;
import view.OutputView;
import vo.Car;

import java.util.List;

public class GameController {

    private final static OutputView outputView = new OutputView();
    private final static InputView inputView = new InputView();
    private final static CarFactory carFactory = new CarFactory();
    private final static Validation validation = new Validation();

    public void run() {
        startGame();
    }

    public void startGame() {
        List<String> carNameList = getValidCarName();
        List<Car> cars = carFactory.createCars(carNameList);

        int tryCount = getValidTryCount();

        // Game logic
        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            outputView.printDistance(cars);
        }

    }

    private List<String> getValidCarName() {
        List<String> carNameList;
        boolean isValid;
        do {
            outputView.askCarNameMessage();
            String carNames = inputView.getName();
            carNameList = carFactory.splitByComma(carNames);
            isValid = validation.validationCarName(carNameList);
        } while (!isValid);
        return carNameList;
    }

    private int getValidTryCount() {
        boolean isValid;
        String inputTryCount;
        do {
            outputView.askTryCountMessage();
            inputTryCount = inputView.getTryCount();
            isValid = validation.validationTryCount(inputTryCount);
        } while (!isValid);
        return Integer.parseInt(inputTryCount);
    }

}
