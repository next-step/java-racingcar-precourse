package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RacingOrganizer;
import racingcar.view.ErrorView;
import racingcar.view.QuestionView;

import java.util.List;

public class RacingGameController {
    private List<Car> cars = null;
    private Integer nRound = null;

    public RacingGameController() {
        while (cars == null || cars.isEmpty())
            setCars();
        while (nRound == null)
            setRound();
    }

    private void setCars() {
        // 자동차 생성
        try {
            QuestionView.carNames();
            String names = Console.readLine();
            cars = RacingOrganizer.createCars(names);
        } catch (IllegalArgumentException e) {
            ErrorView.nameError();
        }
    }

    private void setRound() {
        // 자동차 생성
        try {
            QuestionView.howManyRound();
            nRound = Integer.parseUnsignedInt(Console.readLine());
        } catch (NumberFormatException e) {
            ErrorView.roundError();
        }
    }
}
