package domain;

public class Race {
    private Cars racingCars;

    public static Race create(String carNames) {
        return new Race(carNames);
    }

    private Race(String carNames) {
        this.racingCars = CarsGenerator.generate(carNames);
    }

    Race(Cars racingCars) {
        this.racingCars = racingCars;
    }

    public RaceReport play(Count moveCount) {
        for (int i = 0; i < moveCount.getCount(); i++) {
            racingCars.moveCars(new DiceMovingStrategy());
        }
        return createReport();
    }

    RaceReport createReport() {
        return new RaceReport(racingCars.getCarDtos());
    }
}
