package racingcar.domain.wrap;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constants.ErrorMessage.INVALID_NUMBER_BOUNDARY_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022/04/21 7:12 오후
 */
public class CarNumbers {
    private List<Integer> numbers = new ArrayList<>();
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;

    public void addNumber(int randomNumber) {
        if (randomNumber < START_NUMBER || randomNumber > END_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_BOUNDARY_MESSAGE);
        }
        this.numbers.add(randomNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getRandomNumberByRound(int round) {
        return numbers.get(round - 1);
    }
}
