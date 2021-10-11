package racinggame;

import racinggame.controller.RacingController;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.model.Racing;
import racinggame.view.RacingView;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        Racing racing = new Racing();
        RacingView view = new RacingView();
        RacingController controller = new RacingController(racing, view);

        controller.playRacing();
    }
}
