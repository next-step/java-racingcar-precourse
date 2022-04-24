package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.Prompt;

public class RacingGame {
    private final Prompt prompt;
    private final RacingGameLogic logic;
    public RacingGame() {
        prompt = Prompt.getInstance();
        logic = RacingGameLogic.getInstance();
    }
    public void run_game() {
        List<Car> cars = getCars();
        int loops = getLoopCount();
        for (int i = 0; i < loops; i++) {
            logic.moveCars(cars);
            prompt.printInterimResults(cars);
        }
        prompt.printFinalResults(logic.selectWinnerName(cars));
    }

    private int getLoopCount() {
        return prompt.getGameCount();
    }

    private List<Car> getCars() {
        while(true) {
            try {
                return logic.parserCarName(prompt.getCarNames());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
