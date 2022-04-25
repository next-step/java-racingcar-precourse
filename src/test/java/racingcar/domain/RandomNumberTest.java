package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumberTest {

    private RandomNumber randomNumber;

    @BeforeEach
    void 랜덤숫자_초기화() {
        randomNumber = new RandomNumber();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤_숫자_4미만일경우_false_리턴(int randomValue) {
        assertThat(randomNumber.canMove(randomValue)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤_숫자_4이상일경우_true_리턴(int randomValue) {
        assertThat(randomNumber.canMove(randomValue)).isEqualTo(true);
    }
}