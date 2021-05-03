package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RuleTest {

    @Test
    void forwardTest() {

        // given
        int firstNumber = 3;
        int secondNumber = 4;

        // when
        boolean firstForward = Rule.forward(firstNumber);
        boolean secondForward = Rule.forward(secondNumber);

        //then
        assertThat(firstForward).isFalse();
        assertThat(secondForward).isTrue();
    }

}
