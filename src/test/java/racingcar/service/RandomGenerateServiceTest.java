package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerateServiceTest {
    @Test
    public void generateRandomIntegerTest(){
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        Assertions.assertThat(RandomGenerateService.generateRandomInteger())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);

    }
}
