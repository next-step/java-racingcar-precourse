package racingcar.model.cars.factory;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private static final MoveEventAnalyzer ANALYZER = MoveEventAnalyzer.getInstance();

    public MoveEvent run() {
        return MoveEvent.of(this.getRandom());
    }

    private int getRandom() {
        return Randoms.pickNumberInRange(Engine.ANALYZER.getMaxNumber(), Engine.ANALYZER.getMaxNumber());
    }
}
