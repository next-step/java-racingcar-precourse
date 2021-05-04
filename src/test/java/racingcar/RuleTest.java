package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RuleTest {

    @Test
    void forwardTest() {

        // given
        Number firstNumber = new Number(3);
        Number secondNumber = new Number(4);

        // when
        boolean firstForward = Rule.forward(firstNumber);
        boolean secondForward = Rule.forward(secondNumber);

        //then
        assertThat(firstForward).isFalse();
        assertThat(secondForward).isTrue();
    }

}
