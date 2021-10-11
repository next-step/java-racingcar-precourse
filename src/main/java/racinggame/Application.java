package racinggame;

import racinggame.controller.RacingController;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.view.RacingView;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);
        RacingView view = new RacingView();
        RacingController controller = new RacingController(cars, view);
        // TODO 자동차 경주 게임 구현
        controller.playRacing();

        return;
    }
}
