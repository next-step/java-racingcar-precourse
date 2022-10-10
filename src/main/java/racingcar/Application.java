package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceView view = new RaceView();
        RaceService service = new RaceService();
        RaceController controller = new RaceController(view, service);
        controller.run();
    }
}
