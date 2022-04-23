package racingcar.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ForwardTest {

    @Test
    void _4_이상의_숫자가_입력되어야_전진_할_수_있다() {
        Forward forward = new Forward(4);

        assertThat(forward.isAvailableForward()).isTrue();
    }

    @Test
    void _4_미만의_숫자가_입력되면_전진_할_수_없다() {
        Forward forward = new Forward(3);

        assertThat(forward.isAvailableForward()).isFalse();
    }

    @Test
    void _0_에서_9_사이의_정수가_아닌_숫자를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Forward(10)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Forward(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}