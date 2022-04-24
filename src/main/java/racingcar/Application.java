package racingcar;

import racingcar.applilcation.RacingGameProcessor;
import racingcar.service.RacingGameOrganizer;

public class Application {

    public static void main(String[] args) {
        final RacingGameProcessor racingGameProcessor = new RacingGameProcessor(new RacingGameOrganizer());
        racingGameProcessor.prepareGame();
        racingGameProcessor.playGame();
    }

}
