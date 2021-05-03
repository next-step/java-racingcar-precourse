package racingcar.domain.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomIntegerProviderTest {

    @ParameterizedTest(name = "minNumber이상 maxNumber이하의 랜덤 정수 생성")
    @CsvSource({
            "1, 9"
            , "2, 100"
            , "2, 2"
    })
    void 범위내_랜덤_정수_생성테스트(int minNumber, int maxNumber) {
        int randomNumber = RandomIntegerProvider.provideRandomNumber(minNumber, maxNumber);
        assertThat(randomNumber).isBetween(minNumber, maxNumber);
    }

}