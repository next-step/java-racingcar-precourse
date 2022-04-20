package racingcar.game;

import racingcar.game.car.Car;
import racingcar.game.car.Cars;

enum GameMessage {

    PROMPT_INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    PROMPT_INPUT_NUMBER_OF_TURNS("시도할 회수는 몇회인가요?\n");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    String get() {
        return this.message;
    }

    static String traces(GameStates states) {
        return String.join("",
                states.map(state ->
                        String.join("",
                                state.getCars().map(Car::toString)) + "\n"));
    }

    static String winMessage(Cars cars) {
        return "최종 우승자는 " + String.join(", ", cars.map(car -> car.getName().get())) + " 입니다.";
    }
}
