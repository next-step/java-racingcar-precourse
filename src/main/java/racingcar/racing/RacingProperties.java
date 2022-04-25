package racingcar.racing;

public class RacingProperties {
    private RacingMoveCount moveCount;
    private RacingCarNames carNames;

    public RacingProperties(RacingMoveCount moveCount, RacingCarNames carNames) {
        this.moveCount = moveCount;
        this.carNames = carNames;
    }

    public boolean isEndMove(RacingMoveCount nowMove) {
        if (nowMove.lessThen(moveCount)) {
            return false;
        }
        if (this.moveCount.equals(nowMove)) {
            return true;
        }
        throw new IllegalArgumentException(
                "[ERROR] 현재 이동 횟수는 정해진 이동 횟수보다 클 수 없습니다. now : " + nowMove.moveCount() + " max : " + this.moveCount
                        .moveCount());
    }

    public RacingCarNames racingCarNames() {
        return this.carNames;
    }

}
