package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.ValidationUtil.checkName;

/**
 * Created by victorsung.
 * Date: 2022/04/25
 * Time: 9:33 PM
 */
public class Game {

    public static final String INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private List<String> carName;

    public Game() {
        carName = new ArrayList<>();
        System.out.println(INPUT_MSG);
        String carNames = Console.readLine();
        System.out.println(carNames);

        String[] split = carNames.split(",");
        for (String name : split) {
            if (!checkName(name)) {
                System.out.println("[ERROR]");
//                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            carName.add(name);
        }
    }

    public List<String> getCarName() {
        return carName;
    }
}
