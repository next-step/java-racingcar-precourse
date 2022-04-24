package racingcar.Controller;

import racingcar.model.Car;
import racingcar.model.Game;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public List<Car> makeCarList(String[] str) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            carList.add(new Car(str[i].trim()));
        }
        return carList;
    }

    public void startGame(List<Car> makeCarList, String numberOfExecution) {
        Game game = new Game(numberOfExecution, makeCarList);
        game.start();
    }
}
