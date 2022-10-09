package racingcar.controller;

import racingcar.entity.Cars;
import racingcar.entity.Lab;
import racingcar.model.RandomForward;
import racingcar.model.RankingForward;
import racingcar.view.InputCarName;
import racingcar.view.InputLabCount;
import racingcar.view.OutputResult;

public class Official {
    private final InputCarName inputCarName;
    private final InputLabCount inputLabCount;

    public Official() {
        inputCarName = new InputCarName();
        inputLabCount = new InputLabCount();
    }
    public void startRacing() {
        Cars cars = inputCarNameAction();
        Lab labCount = inputLabCountAction();

        OutputResult.printResultMessage();
        for (int i = 0; i < labCount.getLabCount(); i++) {
            race(cars);
        }
        RankingForward.setCarsRanking(cars);
    }

    private Cars inputCarNameAction() {
        Cars cars;
        do {
            cars = inputCarName.getCars();
        } while(cars == null);

        return cars;
    }

    private Lab inputLabCountAction() {
        Lab lab;
        do {
            lab = inputLabCount.getLab();
        } while(lab == null);

        return lab;
    }

    private void race(Cars cars) {
        RandomForward.setCarsForward(cars);
    }
}
