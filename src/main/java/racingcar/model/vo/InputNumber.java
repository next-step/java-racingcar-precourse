package racingcar.model.vo;

import racingcar.service.ValidateService;
import racingcar.service.impl.ValidateServiceImpl;

public class InputNumber {

    private int gameCount;

    public InputNumber(String gameCount) {
        ValidateService validateService = new ValidateServiceImpl();
        validateService.validateInputNumber(gameCount);
        this.gameCount = Integer.parseInt(gameCount);
    }

    public int getGameCount() {
        return gameCount;
    }
}
