package racingcar.controller;

import racingcar.common.NaturalNumber;
import racingcar.domain.DriveRecord;
import racingcar.domain.RaceCars;
import racingcar.domain.RaceResult;
import racingcar.view.BillBoard;
import racingcar.view.RaceCarView;
import racingcar.view.RaceCarViews;
import racingcar.view.WinnerRacingCarViews;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final BillBoard billBoard;
    private final RaceCars cars;
    private final NaturalNumber raceCount;
    private RaceResult result;

    public Race(BillBoard billBoard, RaceCars cars, NaturalNumber raceCount) {
        this.billBoard = billBoard;
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public void run() {
        this.billBoard.showResultHeader();
        start();
        finish();
    }

    private void start() {
        for (int i = 0; i < raceCount.get(); i++) {
            cars.raceOneTime();
            result = cars.getDriveRecords();
            RaceCarViews currentView = transResultToView(result);
            this.billBoard.showRace(currentView);
        }
    }

    private void finish() {
        WinnerRacingCarViews winnerViews = transWinnerToView(result);
        this.billBoard.showWinner(winnerViews);
    }

    private WinnerRacingCarViews transWinnerToView(RaceResult result) {
        List<RaceCarView> views = new ArrayList<>();
        for (DriveRecord record : result.getWinner()) {
            views.add(RaceCarView.of(record.getName(), record.getCarPosition()));
        }
        return WinnerRacingCarViews.of(views);
    }

    private RaceCarViews transResultToView(RaceResult currentResult) {
        List<RaceCarView> views = new ArrayList<>();
        for (DriveRecord record : currentResult) {
            views.add(RaceCarView.of(record.getName(), record.getCarPosition()));
        }
        return RaceCarViews.of(views);
    }
}
