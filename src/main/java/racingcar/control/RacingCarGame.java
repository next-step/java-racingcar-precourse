package racingcar.control;

import java.util.Arrays;
import racingcar.model.Cars;
import racingcar.model.Turn;
import racingcar.view.GameView;

public class RacingCarGame implements Game {

    public static final String CAR_NAME_DELIMITER = ",";

    private final GameView view;
    private Cars cars;
    private Turn turn;

    public RacingCarGame(GameView gameView) {
        this.view = gameView;
    }

    @Override
    public void init() {
        initCar();
        initTurn();
    }

    private void initCar() {
        String carNames = view.inputCarNames();
        try {
            this.cars = new Cars(Arrays.asList(carNames.split(CAR_NAME_DELIMITER)));
        } catch (IllegalArgumentException iae) {
            view.responseError(iae);
            initCar();
        }
    }

    private void initTurn() {
        String turn = view.inputTurn();
        try {
            this.turn = new Turn(turnToInt(turn));
        } catch (IllegalArgumentException iae) {
            view.responseError(iae);
            initTurn();
        }
    }

    private int turnToInt(String turn) {
        try {
            return Integer.parseInt(turn);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("회수는 숫자로 입력해주세요.");
        }
    }

    @Override
    public void start() {
        view.notifyStartGame();
        while (turn.hasNextTurn()) {
            cars.moveAll();
            view.showGameProgress(cars);
            turn.next();
        }
        view.responseWinner(cars.getWinner());
    }

    @Override
    public void quit() {

    }


}
