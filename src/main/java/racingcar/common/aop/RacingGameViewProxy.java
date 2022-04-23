package racingcar.common.aop;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.ErrorMessageView;
import racingcar.view.RacingGameView;

import java.util.List;
import java.util.function.Supplier;

public class RacingGameViewProxy implements RacingGameView {

    private final RacingGameView racingGameView;
    private final ErrorMessageView errorMessageView;

    public RacingGameViewProxy(RacingGameView racingGameView, ErrorMessageView errorMessageView) {
        this.racingGameView = racingGameView;
        this.errorMessageView = errorMessageView;
    }

    @Override
    public Cars createCars() {
        return this.retryInsert(racingGameView::createCars);
    }

    @Override
    public int insertTryCount() {
        return this.retryInsert(racingGameView::insertTryCount);
    }

    @Override
    public void printExecute() {
        racingGameView.printExecute();
    }

    @Override
    public void printExecuteResult(List<Car> carList) {
        racingGameView.printExecuteResult(carList);
    }

    @Override
    public void printWinner(List<Car> carList) {
        racingGameView.printWinner(carList);
    }

    private <T> T retryInsert(Supplier<T> exec) {
        T result = null;
        while (result == null) {
            result = this.executeWithFailMessage(exec);
        }
        return result;
    }

    private <T> T executeWithFailMessage(Supplier<T> exec) {
        try {
            return exec.get();
        } catch (IllegalArgumentException e) {
            this.errorMessageView.printException(e);
        }
        return null;
    }
}
