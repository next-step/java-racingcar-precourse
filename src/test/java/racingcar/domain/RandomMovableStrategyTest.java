package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import racingcar.util.RandomNumberGenerator;

class RandomMovableStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
    void 랜덤_이동_전략은_랜덤으로_뽑힌_수가_4_이상일_때_이동한다(int randomNumber, boolean expectedValue) {
        try (MockedStatic<RandomNumberGenerator> randomMock = mockStatic(RandomNumberGenerator.class)) {
            randomMock.when(() -> RandomNumberGenerator.getRandomNumber()).thenReturn(randomNumber);
            assertThat(new RandomMovableStrategy().isMove()).isEqualTo(expectedValue);
        }
    }
}