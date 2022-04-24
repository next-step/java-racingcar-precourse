package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.*;

public class ValidTest {

    @Test
    void numberInputValidTest(){
        assertThat(ValidUtils.isNumber("asd")).isEqualTo(false);
    }
}
