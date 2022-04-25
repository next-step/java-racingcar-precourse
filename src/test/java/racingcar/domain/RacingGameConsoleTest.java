package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameConsoleTest {
    @DisplayName("자동차_이름을_입력받는다")
    @Test
    void 자동차_이름을_입력받는다() {
        RacingCarPart expected = new RacingCarPart();
        expected.addName("pobi");
        expected.addName("woni");
        expected.addName("jun");

        System.setIn(new ByteArrayInputStream("pobi,woni,jun".getBytes(StandardCharsets.UTF_8)));
        RacingGameConsole console = new RacingGameConsole();
        RacingCarPart actual = console.readCarNames();

        assertEquals(expected.getNames(), actual.getNames());
    }

    @DisplayName("비정상적인_자동차_이름을_입력받는다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {" ", "wo rld", "자동차이름", "!@#"})
    void 비정상적인_자동차_이름을_입력받는다(String name) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(name.getBytes(StandardCharsets.UTF_8)));
            RacingGameConsole console = new RacingGameConsole();
            console.readCarNames();
        }).isInstanceOfAny(NullPointerException.class, IllegalArgumentException.class);
    }

    @DisplayName("이동_횟수를_입력받는다")
    @Test
    void 이동_횟수를_입력받는다() {
        int expected = 5;

        System.setIn(new ByteArrayInputStream("5".getBytes(StandardCharsets.UTF_8)));
        RacingGameConsole console = new RacingGameConsole();
        int actual = console.readMovingCount();

        assertEquals(expected, actual);
    }

    @DisplayName("비정상적인_이동_횟수를_입력받는다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {" ", "-1", "0", "ㄱ", "a", "1  0"})
    void 비정상적인_이동_횟수를_입력받는다(String count) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(count.getBytes(StandardCharsets.UTF_8)));
            RacingGameConsole console = new RacingGameConsole();
            console.readMovingCount();
        }).isInstanceOfAny(NullPointerException.class, IllegalArgumentException.class, NumberFormatException.class);
    }
}
