package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.NameUtils;
import racingcar.Names;

import java.util.NoSuchElementException;

public class NameInput {
    private static final String NAME_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static Names input() {
        View.println(NAME_INPUT_GUIDE_MESSAGE);
        String name = Console.readLine();
        try {
            return new Names(NameUtils.mapToList(name));
        } catch (NoSuchElementException e){
            View.println("다시 입력하세요.");
            return input();
        }
    }
}
