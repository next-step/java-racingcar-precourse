package racingcar.model.player;

import camp.nextstep.edu.missionutils.Console;
import racingcar.vo.CarName;
import racingcar.vo.Count;
import racingcar.vo.CarNames;

import java.util.List;

public class Player {
    private CarNames carNames;
    private Count count;

    public List<CarName> getCarNames() {
        return this.carNames.getCarNames();
    }

    public int getCount() {
        return count.getCount();
    }

    public void inputCarNames() {
        this.carNames = new CarNames(Console.readLine());
    }

    public void inputCount() {
        this.count = new Count(Console.readLine());
    }
}
