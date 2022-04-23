package racingcar;

import racingcar.constants.ErrorMessage;
import racingcar.enums.MoveStatus;
import racingcar.model.Move;
import racingcar.model.RacingCars;
import racingcar.utils.ValidationUtils;
import racingcar.view.GameView;

import java.util.Map;

public class RacingGame {

    private final RacingCars cars;
    private final Move move;

    public RacingGame(RacingCars cars, Move move) {
        this.cars = cars;
        this.move = move;
    }

    public boolean ableToPlay() {
        return !move.immovable();
    }

    public void outputFinalResult() {
        final String finalChampionshipCarNames = cars.getFinalChampionshipCarNames();
        GameView.printFinalResultMessage(finalChampionshipCarNames);
    }

    public void start() {
        ValidationUtils.validConditionThrowIfTrue(!ableToPlay(), ErrorMessage.MUST_HAVE_A_COUNT_TO_MOVE);
        final Map<String, Integer> movableNumberMap = cars.getMovableNumberMap();
        final Map<String, MoveStatus> moveStatusMap = move.moveStatus(movableNumberMap);
        cars.moveCar(moveStatusMap);
        cars.outputResult();
        GameView.println();
    }

}
