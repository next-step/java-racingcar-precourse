package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceController race = new RaceController();
        race.start();
    }
}
