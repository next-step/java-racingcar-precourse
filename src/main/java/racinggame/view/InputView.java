package racinggame.view;

import nextstep.utils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.asList(Console.readLine().split(","));
    }

    public String inputRacingRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

}
