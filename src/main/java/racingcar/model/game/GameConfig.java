package racingcar.model.game;

import racingcar.model.car.Cars;
import racingcar.model.player.Player;
import racingcar.view.ConsoleView;

public class GameConfig {
    protected ConsoleView view = new ConsoleView();
    protected Player player = new Player();
    protected Cars cars = new Cars();
}
