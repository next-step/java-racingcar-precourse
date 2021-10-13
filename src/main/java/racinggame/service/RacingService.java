package racinggame.service;

import racinggame.model.Car;
import racinggame.model.CarGroup;
import racinggame.model.Round;
import racinggame.model.Winner;
import racinggame.view.OutputView;

public class RacingService {
    CarGroup group;
    Round round;

    public RacingService(CarGroup group, Round round) {
        this.group = group;
        this.round = round;
    }

    public void run() {
        System.out.println(OutputView.RESULT_NOTICE_STR);
        for (int i=0; i < round.getRound(); i++) {
            startRacing();
        }
        String winnerNames = new Winner(group).getWinnerNames();
        System.out.println(OutputView.getFinalWinnerStr(winnerNames));
    }

    public void startRacing() {
        for (Car car : group.getCarGroup()) {
            car.decideMovement();
        }
        group.printCarGroup();
    }

}
