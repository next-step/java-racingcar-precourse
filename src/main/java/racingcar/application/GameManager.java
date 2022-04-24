package racingcar.application;

import racingcar.domain.Cars;

public class GameManager {

    private static final int START_ROUND_NUMBER = 1;
    private static final String ERROR_MESSAGE = "[ERROR] ";

    private final InputCommand inputCommand;
    private final OutputCommand outputCommand;
    private Cars cars;

    public GameManager() {
        this.inputCommand = new InputCommand();
        this.outputCommand = new OutputCommand();
    }

    public void play() {
        try {
            carsInit();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            carsInit();
        }

        Integer tryNumber = inputCommand.askTryNumber();

        for (int round = START_ROUND_NUMBER; round <= tryNumber; round++) {
            cars.playRound();
            outputCommand.printCarPosition(cars);
        }

        cars.findWinners();
        outputCommand.printWinners(cars.getWinnerNames());

    }

    private void carsInit() {
        String[] carNames;
        carNames = new CarsDTO(inputCommand.askCarNames()).toCarNames();
        cars = new Cars(carNames);
    }

}
