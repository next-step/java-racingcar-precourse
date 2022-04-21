package racingcar.game;

import racingcar.game.car.Car;
import racingcar.game.car.Cars;
import racingcar.game.util.Console;

class Game {
    private static boolean isMoving() {
        return GameUtil.rollDice() >= GameConfig.THRESHOLD_MOVE;
    }

    private static Car move(Car car) {
        return car.moved(isMoving()? GameConfig.MOVE_INCREMENT : 0); // 0 can be static final?
    }

    private static GameState nextState(GameState state) {
        return new GameState(state.getCars().mapAndCollect(Game::move, Cars::new));
    }

    static GameStates process(Cars cars, IntRange turns) {
        return turns.foldLeft(new GameStates(new GameState(cars)),
                (states, i) -> new GameStates(states, nextState(states.getLast())));
    }

    private static class CarsMax {
        private final Cars cars;
        private final Distance max;

        public CarsMax(Cars cars, Distance max) {
            this.cars = cars;
            this.max = max;
        }
    }

    static Cars winningCars(Cars candidates) {
        return candidates.foldLeft(new CarsMax(new Cars(), new Distance(-1)), (carsMax, car) -> {
            Distance max = carsMax.max;
            Distance distance = car.getDistance();

            if (max.greaterThan(distance)) return carsMax;
            if (max.equals(distance)) return new CarsMax(new Cars(carsMax.cars, car), max);
            return new CarsMax(new Cars(car), distance);    // max is less than distance
        }).cars;
    }

    void play() {
        String line = GameUtil.readLineWithPrompt(GameMessage.PROMPT_INPUT_CAR_NAMES.get());
        Cars cars = GameUtil.parseCars(line);
        if (cars == null) return;

        line = GameUtil.readLineWithPrompt(GameMessage.PROMPT_INPUT_NUMBER_OF_TURNS.get());
        IntRange turns = GameUtil.parseIntRange(line);
        GameStates states = process(cars, turns);   // Saves each turn of racing
        Console.println(GameMessage.resultMessage(states, Game::winningCars));
    }
}
