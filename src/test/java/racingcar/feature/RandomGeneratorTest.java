package racingcar.feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @DisplayName("난수 생성기 - 한 자리 수 생성 테스트")
    @Test
    void generateSingleTest() {
        //given:
        List<Integer> numberList;
        //when:
        numberList = Arrays.asList(
                RandomGenerator.generate(0, 9),
                RandomGenerator.generate(0, 9),
                RandomGenerator.generate(0, 9));
        //then:
        assertThat(numberList)
                .containsAnyOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @DisplayName("난수 생성기 - 네 자리 수 생성 테스트")
    @Test
    void generateTrebleFigureTest() {
        //given:
        List<Integer> numberList;
        //when:
        numberList = Arrays.asList(
                RandomGenerator.generate(1000, 1005),
                RandomGenerator.generate(1000, 1005),
                RandomGenerator.generate(1000, 1005));
        //then:
        assertThat(numberList)
                .containsAnyOf(1000, 1001, 1002, 1003, 1004, 1005);
    }
}
