package racingcar;

import racingcar.console.Input;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.Referee;
import racingcar.domain.racing.Turn;
import racingcar.domain.car.CarGenerator;
import racingcar.domain.car.Cars;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Cars cars = new Cars(CarGenerator.registerCars(input.getNames()));
        Referee referee = new Referee(cars);
        Turn turn = new Turn(input.getTurn());
        Racing game = new Racing(cars, referee, turn);
        game.start();
    }
}
