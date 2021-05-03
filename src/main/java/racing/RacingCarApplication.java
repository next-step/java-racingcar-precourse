package racing;

import racing.model.Cars;
import racing.model.strategy.RandomMoving;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarApplication {

    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_MOVING_RANGE = 4;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.getCarNames());

        for (int i = 0; i < inputView.getRaceCount(); i++) {
            cars.race(new RandomMoving(MAX_RANDOM_VALUE, MIN_MOVING_RANGE));
            ResultView.printRoundResult(cars.getList());
        }

        ResultView.printWinners(cars.getWinners());
    }

}
