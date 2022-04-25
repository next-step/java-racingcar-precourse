package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @DisplayName("Winner 생성")
    @Test
    public void create() {
        Winner winner = new Winner(Arrays.asList("abc"));
    }

    @DisplayName("Winner 생성 예외 : 1명 이상 입력")
    @Test
    public void create_invalid_size() {
        assertThatThrownBy(() -> new Winner(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}