package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeRandomNumberGeneratorTest {
    private static final int DUMMY = Integer.MIN_VALUE;

    @Test
    void testPickNumber() {
        int[] numbers = {3, 6, 1, 2, 0};
        FakeRandomNumberGenerator fakeRandomNumberGenerator = new FakeRandomNumberGenerator(numbers);
        for (int number : numbers) {
            assertThat(fakeRandomNumberGenerator.pickNumberInRange(DUMMY, DUMMY)).isEqualTo(number);
        }
    }
}
