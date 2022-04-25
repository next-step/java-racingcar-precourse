package racingcar;

public class NextStepRandomNumberGenerator implements RandomNumberPickable {
    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
