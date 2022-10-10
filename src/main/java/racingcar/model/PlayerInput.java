package racingcar.model;

public class PlayerInput {
    private final CarNames carNames;
    private final Lap lap;

    public PlayerInput(CarNames carNames, Lap lap) {
        this.carNames = carNames;
        this.lap = lap;
    }

    public CarNames getCarNames() {
        return carNames;
    }

    public Lap getLap() {
        return lap;
    }
}
