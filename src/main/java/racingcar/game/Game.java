package racingcar.game;

import racingcar.game.car.Car;
import racingcar.game.car.Cars;
import racingcar.game.util.Console;

class Game {
    private static boolean isMoving() {
        return GameUtil.rollDice() >= GameConfig.THRESHOLD_MOVABLE;
    }

    private static Car move(Car car) {
        return car.moved(new Distance(isMoving()? GameConfig.MOVE_INCREMENT : 0)); // 0 can be static final?
    }

    private static GameState nextState(GameState state) {
        return new GameState(state.getCars().mapAndWrap(Game::move, Cars::new));
    }

    static GameStates process(Cars cars, IntRange turns) {
        GameState initialState = new GameState(cars);
        return turns.foldLeft(new GameStates(initialState),
                (states, i) -> new GameStates(states, nextState(states.getLast()))
        ).rest();
    }

    static Cars winningCars(Cars candidates) {
        class CarsMax {
            private final Cars cars;
            private final Distance max;

            private CarsMax(Cars cars, Distance max) {
                this.cars = cars;
                this.max = max;
            }
        }
        return candidates.foldLeft(new CarsMax(new Cars(), new Distance(-1)), (carsMax, car) -> {
            Distance max = carsMax.max;
            Distance distance = car.getDistance();

            if (max.isGreaterThan(distance)) return carsMax;
            if (max.equals(distance)) return new CarsMax(new Cars(carsMax.cars, car), max);
            return new CarsMax(new Cars(car), distance);    // max is less than distance
        }).cars;
    }

    static void play() {
        Cars cars = GameInput.readCarNames().mapAndWrap(Car::new, Cars::new);
        IntRange turns = new IntRange(GameInput.readNumTurns());

        GameStates states = process(cars, turns);   // Saves each turn of racing
        Cars winningCars = winningCars(states.getLast().getCars());
        Console.println(GameMessage.resultMessage(states, winningCars));
//        Console.println(winningCars);
    }
}
