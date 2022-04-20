package racingcar.game;

import racingcar.game.car.Car;

public class GameMessage {
    static String traces(GameStates states) {
        return String.join("",
                states.map(state ->
                        String.join("",
                                state.getCars().map(Car::toString)) + "\n"));
    }
}
