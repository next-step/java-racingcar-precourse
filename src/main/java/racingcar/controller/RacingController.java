package racingcar.controller;

import racingcar.model.Attempts;
import racingcar.model.Racers;
import racingcar.model.Racing;
import racingcar.view.RacingView;


public class RacingController {

    Racers racers;
    Attempts attempts;
    Racing racing;

    public void run() {

        try {
            RacingView racingView = new RacingView();
            racers = racingView.getCarName();
            racing = new Racing(racers);
            initAttempts(racingView);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void initAttempts(RacingView racingView) {
        boolean check = true;
        while (check) {
            check = getAttempts(racingView);
        }
    }

    private boolean getAttempts(RacingView racingView) {
        try {
            attempts = racingView.getAttempts();
            racing.result(attempts);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
