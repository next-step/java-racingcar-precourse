package racingcar.model;

public class GameResult {
    private final Cars cars;

    public GameResult(Cars cars) {
        this.cars = report(cars);
    }

    private Cars report(Cars cars) {
        Cars result = new Cars();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.getCar(i);

            Car copiedCar = new Car(new Name(car.getName()), new Move(car.getMove().moveCount()));
            result.addCar(copiedCar);
        }

        return result;
    }

    public Cars winners() {
        Cars winners = new Cars();

        for (int i = 0; i < cars.size(); i++) {
            Car winner = cars.getCar(i).compareEqualMove(cars.highestMove());

            winners.addCar(winner);
        }

        return winners;
    }

    public Cars geResult() {
        return cars;
    }


    public int size() {
        return cars.size();
    }
}