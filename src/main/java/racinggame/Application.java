package racinggame;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        new Application().play();
    }

    public void play() {
        Map<String, Object> playerInput = new Player().setUserInput();
        Cars cars = new Cars((List<String>)playerInput.get("carNames"), (int)playerInput.get("numberOfAttempt"));
        cars.play();
    }
}
