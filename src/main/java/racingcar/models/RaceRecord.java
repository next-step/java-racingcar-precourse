package racingcar.models;

public class RaceRecord {

    private int turn;
    private final RacingCar car;
    private final RaceResult result;

    public RaceRecord(int turn, RacingCar car, RaceResult result) {
        this.turn = turn;
        this.car = car;
        this.result = result;
    }

    public boolean isEqualCarByName(String carName) {
        return this.car.getName().equals(carName);
    }

    public boolean isEqualResult(RaceResult result) {
        return this.result.equals(result);
    }
}
