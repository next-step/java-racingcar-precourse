package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputProvider;
import racingcar.view.OutputProvider;

/**
 * RacingCarGame
 *
 * @author suji
 * @date 2022-04-23
 **/
public class RacingCarGame {

    public void start() {
        Cars cars = getCars();
        RacingCount racingCount = getRacingCount();
        execute(cars, racingCount);
    }

    public void execute(Cars cars, RacingCount racingCount) {
        OutputProvider.printExecuteResultTitle();
        int tryCount = 0;
        // #. 입력 받은 경주 횟수와 시도한 횟수로 완료 여부를 확인한다.
        while (!racingCount.isEnd(tryCount)) {
            tryCount++;
            play(cars);
        }
        gameResult(cars);
    }

    public void play(Cars cars) {
        // #. 이동 조건이 될 숫자를 Random 으로 값을 구한다.
        MoveNumbers moveNumbers = MoveNumbers.newInstance();
        moveNumbers.addRandomNumbers(cars.size());

        // #. Random 값에 따라 자동차를 전진 또는 멈춤 처리한다.
        cars.moveCars(moveNumbers);

        // #. 시도 회차별 실행 결과를 출력한다.
        OutputProvider.printExecuteResult(cars);
    }

    public void gameResult(Cars cars) {
        // #. 자동차 별 랭킹을 구하고 최종 우승자를 추출하여 출력한다.
        Ranking ranking = new Ranking(cars);
        FinalWinners finalWinners = new FinalWinners(ranking);
        OutputProvider.printFinalWinners(finalWinners);
    }

    /**
     * 사용자에게 입력 받은 자동차 이름으로 자동차를 생성하고 리스트 객체를 가져온다.
     * @return 자동차 리스트 객체
     */
    private Cars getCars() {
        Cars cars = null;
        while (isEmptyCars(cars)) {
            cars = createCars(cars);
        }
        return cars;
    }

    private Cars createCars(Cars cars) {
        try {
            String carNames = InputProvider.inputCarNames();
            cars = Cars.newInstance(carNames);
        } catch (IllegalArgumentException e) {
            OutputProvider.printExceptionMessage(e);
        }
        return cars;
    }

    private boolean isEmptyCars(Cars cars) {
        return cars == null || cars.isEmpty();
    }

    /**
     * 사용자에게 입력 받은 시도 횟수를 객체로 생성하고 가져온다.
     * @return 경주 시도 횟수 객체
     */
    private RacingCount getRacingCount() {
        RacingCount racingCount = null;
        while (isEmptyRacingCount(racingCount)) {
            racingCount = createRacingCount(racingCount);
        }
        return racingCount;
    }

    private RacingCount createRacingCount(RacingCount racingCount) {
        try {
            String inputCount = InputProvider.inputRacingCount();
            racingCount = new RacingCount(inputCount);
        } catch (IllegalArgumentException e) {
            OutputProvider.printExceptionMessage(e);
        }
        return racingCount;
    }

    private boolean isEmptyRacingCount(RacingCount racingCount) {
        return racingCount == null || racingCount.getCount() == 0;
    }
}
