package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.RandomNumber;

public class RandomNumberTest {

    @Test
    @DisplayName("무작위 숫자 생성 테스트")
    void random_number_generate_test() {
        RandomNumber randomNumber = new RandomNumber();

        int number = randomNumber.getNumber();

        assertThat(number).isBetween(1, 9);
    }
}
