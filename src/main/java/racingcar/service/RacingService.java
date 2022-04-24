package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.model.Racing;
import racingcar.util.Utils;

public class RacingService implements Service {

    Racing racingCars;
    int lap;
    String carsNameList;
    String lapStr;

    public RacingService() {
        carsNameList = "";
        lapStr = "";
    }

    @Override
    public void start() {

        while(RacingGame()){
            RacingGame();
        }

    }

    private Boolean RacingGame() {
        try {
            carsNameList = Utils.getInput("경주할자동차이름(이름은쉼표(,)기준으로구분)");
            racingCars = new Racing(carsNameList);

            lapStr = Utils.getInput("시도할 회수는 몇회인가요?");
            int lap = Integer.parseInt(lapStr);

            for (int i = 0; i < lap; i++) {
                //경기 중
                racingCars.moveCheck();
                System.out.println();
            }
            racingCars.getResult();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            return true;
        }
        return false;
    }
}
