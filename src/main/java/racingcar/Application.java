package racingcar;

import racingcar.contoller.GameController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameController game = new GameController();
        game.play();
    }
}
