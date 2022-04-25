package racingcar;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    @RepeatedTest(100)
    void generate(){
        int number = NumberGenerator.generate();
        assertThat(number).isGreaterThan(-1);
        assertThat(number).isLessThan(10);
    }
}
