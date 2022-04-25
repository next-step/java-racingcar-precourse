package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RandomNumberPicker.MAX_NUMBER;
import static racingcar.utils.RandomNumberPicker.MIN_NUMBER;

class RandomNumberPickerTest {

    @DisplayName("0과 9사이의 랜덤 숫자를 리턴한다.")
    @Test
    public void pick() {
        // when
        RandomNumberPicker picker = new RandomNumberPicker();
        int pick = picker.pick();
        // then
        assertThat(pick).isBetween(MIN_NUMBER, MAX_NUMBER);
    }

}