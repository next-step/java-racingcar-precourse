package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 이동 조건이 될 숫자
 *
 * @author suji
 * @date 2022-04-23
 **/
public class MoveNumbers {

    private static final int MOVE_NUMBER_MIN = 0;
    private static final int MOVE_NUMBER_MAX = 9;

    private final List<Integer> moveNumbers;

    private MoveNumbers(List<Integer> moveNumbers) {
        for (Integer number : moveNumbers) {
            validate(number);
        }
        this.moveNumbers = moveNumbers;
    }

    public static MoveNumbers newInstance(Integer... moveNumber) {
        List<Integer> moveNumbers = new ArrayList<>(Arrays.asList(moveNumber));
        return new MoveNumbers(moveNumbers);
    }

    public void addRandomNumbers(int addCount) {
        for (int i = 0; i < addCount; i++) {
            this.moveNumbers.add(Randoms.pickNumberInRange(MOVE_NUMBER_MIN, MOVE_NUMBER_MAX));
        }
    }

    public Integer getIndex(int index) {
        if (isEmpty()) {
            throw new IllegalStateException(ErrorMessage.ERROR_NOT_MOVE_NUMBERS);
        }
        return this.moveNumbers.get(index);
    }

    private void validate(Integer moveNumber) {
        if (moveNumber < MOVE_NUMBER_MIN || moveNumber > MOVE_NUMBER_MAX) {
            throw new IllegalStateException(ErrorMessage.ERROR_MOVE_NUMBER_RANGE);
        }
    }

    private boolean isEmpty() {
        return this.moveNumbers == null || this.moveNumbers.isEmpty();
    }
}
