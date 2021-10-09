package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Name : InputView <br/>
 * Description : 입력 화면 클래스
 */
public class InputView {

    public static final String INPUT_USER_NAME_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ROUND_TEXT = "시도할 회수는 몇회인가요?";

    public List<Car> inputUserName() {
        System.out.println(INPUT_USER_NAME_TEXT);
        return setRacingGameUsers(Console.readLine());
    }

    List<Car> setRacingGameUsers(String userNames) {
        List<Car> users = new ArrayList<>();
        for (String userName : userNames.split(",")) {
            users.add(new Car(userName));
        }
        return users;
    }

    public int inputRound() {
        System.out.println(INPUT_ROUND_TEXT);
        return Integer.parseInt(Console.readLine());
    }
}
