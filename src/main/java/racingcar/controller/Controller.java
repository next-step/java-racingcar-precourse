package racingcar.controller;

import racingcar.model.Attempts;
import racingcar.model.Names;

public interface Controller {
    void start();

    Names inputCarNames();

    Attempts inputAttempts();
}
