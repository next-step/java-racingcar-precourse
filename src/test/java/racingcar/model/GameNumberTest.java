package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.InfoMessage;

class GameNumberTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    @Test
    void lessThanZeroShouldThrowException() {
        assertSimpleTest(
                () -> {
                    GameNumber.of("-1");
                    assertThat(captor.toString().trim()).contains(InfoMessage.ERROR_MESSAGE_BEGIN);
                }
        );
    }

    @Test
    @DisplayName("should return proper gameNumber if we provide proper number in string form")
    void of() {
        assertAll(
                () -> assertThat(GameNumber.of("1")).isInstanceOf(GameNumber.class),
                () -> assertThat(Objects.requireNonNull(GameNumber.of("1")).getValue()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("should return null if we pass inappropriate parameter ")
    void of_return_null() {
        assertNull(GameNumber.of("a"));
    }
}