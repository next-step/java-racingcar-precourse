package racingcar.view.status;

import static racingcar.view.port.inbound.StandardInput.readLine;

import racingcar.game.GameContext;
import racingcar.game.status.MakeCarList;
import racingcar.game.status.Status;
import racingcar.view.port.outbound.StandardOutput;

public class EnterCarNameList implements Status {
    @Override
    public Status next(GameContext gameContext) {
        StandardOutput.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String carNameList = readLine();
        gameContext.setCarNameList(carNameList);
        return new MakeCarList();
    }
}
