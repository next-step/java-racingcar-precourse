package racingcar.game;

import racingcar.game.car.Car;
import racingcar.game.car.Cars;
import racingcar.game.util.Console;

class Game {
    private final GameStates states = new GameStates(); // Saves each turn of racing

    private GameState lastState() {
        return states.getLast();
    }

    private static boolean isMoving() {
        return GameUtil.rollDice() >= GameConfig.THRESHOLD_MOVE;
    }

    private static Car move(Car car) {
        return car.moved(isMoving()? GameConfig.MOVE_INCREMENT : 0); // 0 can be static final?
    }

    static GameState nextState(GameState state) {
        return new GameState(state.getCars().mapAndThen(Game::move, Cars::new));
    }

    void process(Cars cars, IntRange turns) {
        states.add(new GameState(cars));    // mutation
        turns.forEach(i -> states.add(nextState(lastState()))); // mutation
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
        process(cars, turns);
        Console.print(GameMessage.traces(states));
        Console.println(GameMessage.winMessage(winningCars(lastState().getCars())));
    }
}
