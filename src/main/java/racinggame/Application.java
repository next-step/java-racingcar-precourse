package racinggame;

import nextstep.utils.io.Input;
import nextstep.utils.io.Output;
import racinggame.domain.RacingGameProcessor;

public class Application {
    public static void main(String[] args) {
        new RacingGameProcessor(new Input(), new Output()).start();
    }
}
