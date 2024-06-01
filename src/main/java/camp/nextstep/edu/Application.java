package camp.nextstep.edu;

import camp.nextstep.edu.presenter.RacingCarInputDispatcherListener;

public class Application {
    public static void main(String[] args) {
        new RacingCarInputDispatcherListener(Config.getRacingCarApi()).run();
    }
}
