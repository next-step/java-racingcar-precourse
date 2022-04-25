package racingcar.utils;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Collections;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarGame {
    public void start() {
        Cars cars = new Cars();
        inputCarNameList(cars);
        Round round = new Round();
        inputRoundCount(round);
        OutputView.printResult();
        startRound(cars, round);
        finalResult(cars);
    }

    public void inputCarNameList(Cars cars) {
        try {
            cars.generateCars(InputView.printCarNameRequest());
        } catch (IllegalArgumentException e) {
            inputCarNameList(cars);
        }
    }

    public void inputRoundCount(Round round) {
        try {
            round.generateRound(InputView.printCountRequest());
        } catch (IllegalArgumentException e) {
            inputRoundCount(round);
        }
    }

    public void startRound(Cars cars, Round round) {
        int count = 0;
        while (count < round.getCount()) {
            progressGame(cars);
            count++;
        }
    }

    public void progressGame(Cars cars) {
        for (Car car : cars.getCars()) {
            car.progress(pickNumberInRange(0, 9));
            OutputView.printCarPosition(car);
        }
        OutputView.printNewLine();
    }

    public void finalResult(Cars cars) {
        Collections.sort(cars.getCars());
        int finalScore = cars.getCars().get(0).getScore();
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.getCars()) {
            sb.append(getWinnerString(car, finalScore));
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        OutputView.printWinner(sb.toString());
    }

    public String getWinnerString(Car car, int finalScore) {
        String result = "";
        if (Validation.isSameScore(finalScore, car.getScore())) {
            result = car.getName() + ", ";
        }
        return result;
    }
}
