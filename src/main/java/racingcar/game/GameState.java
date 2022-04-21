package racingcar.game;

import racingcar.game.car.Cars;

class GameState {
    private final Cars cars;

    GameState(Cars cars) {
        this.cars = cars;
    }

    Cars getCars() {
        return cars;
    }
}
