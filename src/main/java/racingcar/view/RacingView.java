package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Attempts;
import racingcar.model.Racer;
import racingcar.model.Racers;

import java.util.ArrayList;

public class RacingView {


    public String getReadLine() {
        String readLine = Console.readLine();
        System.out.println(readLine);
        System.out.println();
        return readLine;
    }

    public Racers getCarName() {
        ArrayList<Racer> racer = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String readLine = getReadLine();
        for (String s : readLine.split(",")) {
            racer.add(new Racer(s, 0));
        }
        return new Racers(racer);
    }

    public Attempts getAttempts() {

        System.out.println("시도할 회수는 몇회인가요?");
        String readLine = getReadLine();
        return new Attempts(readLine);
    }

}
