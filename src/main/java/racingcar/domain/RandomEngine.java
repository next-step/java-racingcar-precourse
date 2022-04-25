package racingcar.domain;

import racingcar.constants.EngineOperateType;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomEngine implements Engine {
    private static final RandomEngine engine = new RandomEngine();
    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int CLASSIFY_NUM = 4;

    private RandomEngine() {}

    public static RandomEngine getInstance() {
        return engine;
    }

    @Override
    public EngineOperateType operate() {
        return isAccelerate(getRandomNumber())
                ? EngineOperateType.ACCELERATE : EngineOperateType.BREAK;
    }

    public int getRandomNumber() {
        return pickNumberInRange(MIN, MAX);
    }

    public boolean isAccelerate(int number) {
        return number >= CLASSIFY_NUM;
    }

}
