package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.Validator;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.utils.Parser.parseTrialNumber;

public class Controller {
    private final Validator validator = new Validator();
    private final InputView inputView = new InputView();

    public void run(){
        play(createGame());
    }

    private Game createGame(){
        Game game = new Game();
        registerRaceCar(game);
        setTrial(game);
        return game;
    }

    private void play(Game game){
        OutputView.printHead();
        while(!game.isGameEnd()){
            game.moveForward();
            game.increaseTrialNumber();
            OutputView.printScore(game.getRaceCars());
        }
        OutputView.printWinners(game.getWinners());
    }

    private void registerRaceCar(Game game){
        game.setRaceCars(Parser.parseCarName(getCarNamesUserInput()));
    }

    private void setTrial(Game game){
        game.setTrial(parseTrialNumber(getTrialNumberUserInput()));
    }

    private String getCarNamesUserInput() {
        String input = inputView.requestCarNamesMessage();
        return checkValidationCarNames(input);
    }

    private String checkValidationCarNames(String input) {
        try {
            validator.checkCarsName(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getCarNamesUserInput();
        }
    }

    private String getTrialNumberUserInput() {
        String input = inputView.requestTrialNumberMessage();
        return checkValidationTrialNumber(input);
    }

    private String checkValidationTrialNumber(String input) {
        try {
            validator.checkTrialNumber(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getTrialNumberUserInput();
        }
    }
}
