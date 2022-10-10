package racingcar.model.race;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.strategy.MoveStrategy;
import racingcar.model.value.ErrorMsg;
import racingcar.view.Output;

/**
 * 경기 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Race implements RaceInterface {

    private final Record record;
    private final MoveStrategy moveStrategy;

    private RaceStatus raceStatus;
    private Cars cars;
    private Trial trial;

    public Race(MoveStrategy moveStrategy) {
        this.record = new Record();
        this.moveStrategy = moveStrategy;
        this.raceStatus = RaceStatus.PREPARING;
    }

    @Override
    public void start() {
        checkRaceStartCondition();
        this.raceStatus = RaceStatus.DRIVING;
        Output.printRaceStart();
        for (int i = 0; trial.biggerThan(i); i++) {
            runNthRound(i + 1);
        }
        this.raceStatus = RaceStatus.RACE_OVER;
    }

    private void checkRaceStartCondition() {
        if (this.raceStatus != RaceStatus.READY) {
            throw new IllegalStateException(ErrorMsg.CANNOT_START_RACE_NO_READY);
        }
    }

    private void runNthRound(int round) {
        cars.moveAll(moveStrategy);
        Result result = new Result(round, cars);
        record.addRecord(result);
        result.printResult();
    }

    @Override
    public void announceFinalWinner() {
        if (!isRaceOver()) {
            throw new IllegalStateException(ErrorMsg.CANNOT_ANNOUNCE_FINAL_WINNER);
        }
        Result result = record.getFinalResult();
        Winners winners = result.getWinners();
        Output.printRaceFinalWinner(winners);
    }

    @Override
    public boolean isRaceOver() {
        return this.raceStatus == RaceStatus.RACE_OVER;
    }

    @Override
    public boolean isRaceReady() {
        return this.raceStatus == RaceStatus.READY;
    }


    @Override
    public Record getRaceRecord() {
        return record;
    }

    @Override
    public void setupCars(Cars cars) {
        this.cars = cars;
        this.raceStatus = RaceStatus.CAR_SETUP;
    }

    @Override
    public void setupTrial(Trial trial) {
        this.trial = trial;
        this.raceStatus = RaceStatus.READY;
    }

    public boolean requireCarSetUp() {
        return this.raceStatus == RaceStatus.PREPARING;
    }

    public boolean requireTrialSetup() {
        return this.raceStatus == RaceStatus.CAR_SETUP;
    }
}
