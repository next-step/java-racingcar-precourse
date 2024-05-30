package kim.half.controller;

import kim.half.model.Cars;
import kim.half.view.InputView;
import kim.half.view.OutputView;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;

    public GameManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        Cars cars = createCars();
        int tryCount = getTryCount();

        playGame(cars, tryCount);
        outputView.printWinners(cars.getWinners());
    }

    private Cars createCars() {
        while (true) {
            try {
                String names = inputView.enterCarNames();
                return new Cars(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getTryCount() {
        while (true) {
            try {
                String inputTryCount = inputView.enterTryCount();
                return validateTryCount(inputTryCount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateTryCount(String tryCount) {
        if (!isNumeric(tryCount) || Integer.parseInt(tryCount) < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
        return Integer.parseInt(tryCount);
    }

    private boolean isNumeric(String inputString) {
        return inputString.matches("\\d+");
    }

    private void playGame(Cars cars, int tryCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            cars.runCars();
            outputView.printProgressStatus(cars.getCars());
        }
    }
}
