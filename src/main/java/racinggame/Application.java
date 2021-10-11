package racinggame;

import nextstep.controller.RaceController;
import nextstep.view.RaceView;

public class Application {
    public static void main(String[] args) {
        RaceController race = new RaceController(new RaceView());
        race.start();
    }
}
