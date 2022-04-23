package racingcar;

import racingcar.racing.Entry;
import racingcar.racing.Lap;
import racingcar.racing.Racing;

public class RacingController {

    public static void start() {
        RacingController.progress(RacingView.inputCarName(), RacingView.inputLapCount());
    }

    private static void progress(Entry entry, Lap lap) {
        Racing racing = new Racing(entry);
        for (int i = 0; i < lap.getCount(); i++) {
            RacingView.printLapResult(racing.lapResult());
        }
        RacingController.result(racing);
    }

    private static void result(Racing racing) {
        RacingView.printWinners(racing.winners());
    }
}
