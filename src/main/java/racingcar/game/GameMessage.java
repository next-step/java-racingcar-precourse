package racingcar.game;

import racingcar.game.car.Cars;

import java.util.function.Function;

enum GameMessage {
    PROMPT_INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    PROMPT_INPUT_NUMBER_OF_TURNS("시도할 회수는 몇회인가요?\n");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    private static String carTraces(GameStates states) {
        return String.join("",
                states.map(state ->
                        String.join("",
                                state.getCars().map(car -> car.getName() + " : " +
                                        GameUtil.repeatString(car.getDistance().get(), "-") + "\n"
                                )
                        ) + "\n"
                )
        );
    }

    private static String winMessage(Cars cars) {
        return "최종 우승자: " + String.join(", ", cars.map(car -> car.getName().get()));
    }

    static String resultMessage(GameStates states, Cars winningCars) {
        return carTraces(states) + winMessage(winningCars);
    }

    String get() {
        return this.message;
    }
}
