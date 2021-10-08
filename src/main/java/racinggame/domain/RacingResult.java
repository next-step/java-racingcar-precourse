package racinggame.domain;

import static racinggame.type.StringConstants.LINE_FEED;

public class RacingResult {

    private static final String RESULT_PREFIX = "실행결과";
    private static final String RESULT_WINNERS_EXP = "최종 우승자는 %s 입니다.";

    private final RacingTimesRecord racingTimesRecord;
    private final Cars winners;

    public RacingResult() {
        winners = Cars.createCars();
        racingTimesRecord = new RacingTimesRecord();
    }

    public void record(Cars cars) {
        racingTimesRecord.record(cars);
    }

    public int resultSize() {
        return racingTimesRecord.size();
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
        return RESULT_PREFIX +
                LINE_FEED +
                racingTimesRecord.toString() +
                LINE_FEED +
                String.format(RESULT_WINNERS_EXP, winners.toString());
    }
}
