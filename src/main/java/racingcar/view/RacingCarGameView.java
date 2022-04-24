package racingcar.view;

import static racingcar.view.constant.ViewConstant.GET_CAR_NAMES;
import static racingcar.view.constant.ViewConstant.GET_TRY_COUNT;
import static racingcar.view.constant.ViewConstant.SHOW_RESULT;
import static racingcar.view.constant.ViewConstant.SHOW_TRY_RESULT;
import static racingcar.view.constant.ViewConstant.SHOW_WINNERS;

import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;
import racingcar.dto.response.RacingTryResult;
import racingcar.dto.response.WinnerNames;
import racingcar.view.userinferface.GameUserInterface;

public class RacingCarGameView {
    private final GameUserInterface gameUserInterface;

    public RacingCarGameView(GameUserInterface gameUserInterface) {
        this.gameUserInterface = gameUserInterface;
    }

    public CarNames getCarNames() {
        return CarNames.from(gameUserInterface.getUserInput(GET_CAR_NAMES));
    }

    public TryCount getTryCount() {
        return TryCount.from(gameUserInterface.getUserInput(GET_TRY_COUNT));
    }

    public void showResult() {
        gameUserInterface.show(SHOW_RESULT);
    }

    public void showTryResult(RacingTryResult tryResult) {
        gameUserInterface.show(String.format(SHOW_TRY_RESULT, tryResult.toString()));
    }

    public void showWinners(WinnerNames winnerNames) {
        gameUserInterface.show(String.format(SHOW_WINNERS, winnerNames.get()));
    }

    public void showError(String error) {
        gameUserInterface.error(error);
    }
}
