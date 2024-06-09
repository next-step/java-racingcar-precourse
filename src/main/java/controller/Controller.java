package controller;

import domain.Game;
import repository.CarRepository;
import util.Input;
import view.OutputView;

public class Controller {

    private final Input input = new Input();
    private final CarRepository carRepository = new CarRepository();
    private final OutputView outputView = new OutputView();

    public void run() {
        carRepository.saveCars(input.getCarNames());
        Game game = new Game(carRepository.findAll(), input.getNumberOfAttempts());
        game.playGame();
        outputView.printWinners(game.getWinners());
    }

}
