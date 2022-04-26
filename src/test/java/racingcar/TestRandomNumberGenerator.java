package racingcar;

import racingcar.support.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class TestRandomNumberGenerator implements RandomNumberGenerator {
    private final List<Integer> numbers = new ArrayList<>();


    public TestRandomNumberGenerator(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    @Override
    public List<Integer> generate(int count) {
        return this.numbers;
    }
}
