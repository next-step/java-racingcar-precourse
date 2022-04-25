package racingcar;

public class RaceModel {
    private final Cars cars;
    private final Counter counter;
    private final RaceActionGenerator raceActionGenerator;

    public RaceModel(final Cars cars, final Counter counter, final RandomNumberPickable randomNumberPickable) {
        this.cars = cars;
        this.counter = counter;
        this.raceActionGenerator = new RaceActionGenerator(randomNumberPickable);
    }

    public Cars nextRace() {
        race();
        counter.countDown();
        return cars;
    }

    public Cars getWinners() {
        if (!counter.isFinish()) {
            throw new IllegalStateException("경주가 아직 끝나지 않았습니다.");
        }
        return cars.getFarthestTraveledCars();
    }

    public boolean isFinished() {
        return counter.isFinish();
    }

    private void race() {
        for (Car car : cars.asList()) {
            RaceAction raceAction = raceActionGenerator.nextAction();
            travelOrStop(car, raceAction);
        }
    }

    private void travelOrStop(final Car car, final RaceAction raceAction) {
        if (raceAction == RaceAction.TRAVEL) {
            car.travel();
        }
    }
}
