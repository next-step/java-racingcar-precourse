package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameLengthValidTest {

    ValidCheck validcheck;
    @BeforeEach
    void setup(){
        validcheck = new ValidCheck();
    }
    @Test
    void NameValidCheck(){
        String testName = "abcde";
        assertThat(validcheck.SizeCheck(testName)).isTrue();

    }
}
