package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class StandardInput implements Input {

    @Override
    public List<String> insertCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.asList(Console.readLine().split(","));
    }

    @Override
    public String insertTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

}
