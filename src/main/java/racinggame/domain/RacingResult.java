package racinggame.domain;

public class RacingResult {

    private final RacingRecords racingRecords;
    private final Cars winners;

    public RacingResult() {
        racingRecords = new RacingRecords();
        winners = Cars.createCars();

    }

    public void record(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            racingRecords.addResult(RacingRecord.from(cars.get(i)));
        }
    }

    public int resultSize() {
        return racingRecords.size();
    }

    public void addWinner(Car car) {
        winners.add(car);
    }

    public void addWinners(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            addWinner(cars.get(i));
        }
    }

    @Override
    public String toString() {
        return "RacingResult{" +
                "racingRecords=" + racingRecords +
                ", winners=" + winners +
                '}';
    }
}
