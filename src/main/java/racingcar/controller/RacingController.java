package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Racing;
import racingcar.util.Constants;

public class RacingController {
    private Racing racing = new Racing();

    public void initRacing() {
        System.out.println(Constants.MSG_GET_ENTRY);

        try {
            racing.initRacing(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initRacing();
        }
    }

    public void doRacing() {
        System.out.println(Constants.MSG_GET_ROUND);

        try {
            racing.doRacing(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            doRacing();
        }
    }

    public String endRacing() {
        return racing.endRacing();
    }
}
