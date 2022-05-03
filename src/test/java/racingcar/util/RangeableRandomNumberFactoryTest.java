package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RangeableRandomNumberFactory 단위 테스트")
class RangeableRandomNumberFactoryTest {

    private AbstractRandomNumberFactory randomNumberFactory;

    @Test
    void produce_는_범위가_지정되어_있을_경우_해당_범위내의_난수를_생성하여_반환합니다() {
        int max = 11;
        int min = 5;
        randomNumberFactory = new RangeableRandomNumberFactory(max, min);

        AbstractRandomNumber randomNumber = randomNumberFactory.produce();
        assertAll(
                () -> assertTrue(randomNumber.isLessThan(max)),
                () -> assertTrue(randomNumber.isMoreThan(min))
        );
    }

    @Test
    void produce_는_범위가_지정되어_있지_않을_경우_0이상_9이하의_난수를_생성하여_반환합니다() {
        randomNumberFactory = new RangeableRandomNumberFactory();

        AbstractRandomNumber randomNumber = randomNumberFactory.produce();
        assertAll(
                () -> assertTrue(randomNumber.isLessThan(RangeableRandomNumberFactory.DEFAULT_MAX_RANDOM_NUMBER)),
                () -> assertTrue(randomNumber.isMoreThan(RangeableRandomNumberFactory.DEFAULT_MIN_RANDOM_NUMBER))
        );
    }

}
