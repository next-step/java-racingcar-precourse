package racingcar.domain;

import racingcar.ui.View;

public class RacingCarGame {

    private final View view;
    private final MovingStrategy movingStrategy;
    private final NumberGenerator numberGenerator;
    private RacingCars racingCars;
    private TryCount tryCount;


    public RacingCarGame(View view, NumberGenerator numberGenerator, MovingStrategy movingStrategy) {
        this.view = view;
        this.movingStrategy = movingStrategy;
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        init();
        run();
        findWinners();
    }

    public void init() {
        initRacingCars();
        initTryCounts();
    }

    private void initRacingCars() {
        this.racingCars = new RacingCars(view.insertCarNames(), numberGenerator, movingStrategy);
    }

    private void initTryCounts() {
        this.tryCount = new TryCount(view.insertTryCount());
    }


    private void run() {
        view.printResultNotice();
        while (tryCount.hasTryCount()) {
            racingCars.moveCars();
            view.printMovingResults(racingCars.toString());
            tryCount.tryOnce();
        }
    }

    private void findWinners() {
        view.printWinners(racingCars.findWinners());
    }

}
