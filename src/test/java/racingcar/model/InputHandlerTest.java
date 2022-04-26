package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    private InputHandler inputHandler;

    @BeforeEach
    void create() {
        inputHandler = new InputHandler();
    }

    @Test
    void 정상적인_자동차명이_입력되었을_경우() {
        assertThat(inputHandler.toCarNames("sys,pobi,roro")).isEqualTo(Arrays.asList("sys", "pobi", "roro"));
    }

    @Test
    void 입력한_자동차명이_없을_경우() {
        assertThrows(IllegalArgumentException.class,
                () -> inputHandler.toCarNames(""));
    }

    @Test
    void 자동차명이_비어있도록_입력된_경우() {
        assertThrows(IllegalArgumentException.class,
                () -> inputHandler.toCarNames("sys,,pobi"));
    }

    @Test
    void 자동차명이_5글자를_초과한_경우() {
        assertThrows(IllegalArgumentException.class,
                () -> inputHandler.toCarNames("sysnar,pobi,roro"));
    }

    @Test
    void 자동차명이_2개_이상_입력되지_않은_경우() {
        assertThrows(IllegalArgumentException.class,
                () -> inputHandler.toCarNames("sys"));
    }

    @Test
    void 중복된_자동차명이_입력된_경우() {
        assertThrows(IllegalArgumentException.class,
                () -> inputHandler.toCarNames("pobi,pobi"));
    }

    @Test
    void 시도횟수가_정상적으로_입력되었을_경우() {
        assertThat(inputHandler.toInt("3")).isEqualTo(3);
    }

    @Test
    void 시도횟수가_정상적으로_입력되지_않은_경우() {
        assertThrows(IllegalArgumentException.class,
                () -> inputHandler.toInt("lsb"));

        assertThrows(IllegalArgumentException.class,
                () -> inputHandler.toInt("3000000000000"));
    }
}