package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    private RandomNumberGenerator randomNumberGenerator;
    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 0;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("생성 숫자 범위 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    public void number_test() {
        // Given
        int randomNumber;

        // When
        randomNumber = randomNumberGenerator.generate();

        // Then
        assertThat(randomNumber).isBetween(MIN_NUMBER, MAX_NUMBER);
    }
}