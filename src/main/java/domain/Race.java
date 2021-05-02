package domain;

public class Race {
    private Cars racingCars;
    private Count remainMoveCount = Count.zero();
    private RaceStatus raceStatus = RaceStatus.YET;

    public static Race create(String carNames, Count remainMoveCount) {
        return new Race(carNames, remainMoveCount);
    }

    private Race(String carNames, Count remainMoveCount) {
        this.racingCars = CarsGenerator.generate(carNames);
        this.remainMoveCount = remainMoveCount;
    }

    Race(Cars racingCars, Count remainMoveCount) {
        this.racingCars = racingCars;
        this.remainMoveCount = remainMoveCount;
    }

    public RaceReport playOneCount() {
        racingCars.moveCars(new DiceMovingStrategy());
        this.remainMoveCount = remainMoveCount.add(Count.minusOne());
        modifyStatus();
        return report();
    }

    private void modifyStatus() {
        if (this.remainMoveCount.equals(Count.zero())) {
            this.raceStatus = RaceStatus.END;
        }
    }

    public RaceReport report() {
        return new RaceReport(racingCars.getCarDtos(), raceStatus);
    }

    Count getRemainMoveCount() {
        return remainMoveCount;
    }

    public void end() {
        this.remainMoveCount = Count.zero();
        this.raceStatus = RaceStatus.END;
    }

    public boolean isEnd() {
        return this.raceStatus.isEnd();
    }
}
