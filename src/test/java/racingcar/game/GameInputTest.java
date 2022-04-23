package racingcar.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.game.car.CarNames;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class GameInputTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    @DisplayName("readCarNames() 적당한 이름을 2개 입력하면, CarNames 사이즈 2개")
    void readCarNames_InputProperCarNames_CarNamesSize2() {
        CarNames carNames = null;
        try {
            command("a,b");
            carNames = GameInput.readCarNames();
        } catch (NoSuchElementException ignore) {
        }
        assertThat(carNames).isNotNull();
        assertThat(carNames.size()).isEqualTo(2);
        assertThat(carNames.get(0).get()).isEqualTo("a");
        assertThat(carNames.get(1).get()).isEqualTo("b");
    }

    @ParameterizedTest(name = "readCarNames() 너무 긴 이름({arguments})을 입력하면, 에러 메시지 출력")
    @ValueSource(strings = {"aaaaaa", "a,bbbbbb"})
    void readCarNames_InputTooLongCarNames_ErrorMessagePrints(String input) {
        try {
            command(input);
            GameInput.readCarNames();
        } catch (NoSuchElementException ignore) {
        }
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "readCarNames() 너무 짧은 이름({arguments})을 입력하면, 에러 메시지 출력")
    @ValueSource(strings = {" , "})
    void readCarNames_InputTooShortCarNames_ErrorMessagePrints(String input) {
        try {
            command(input);
            GameInput.readCarNames();
        } catch (NoSuchElementException ignore) {
        }
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "readCarNames() 2개 미만의 이름({arguments})을 입력하면, 에러 메시지 출력")
    @ValueSource(strings = {"a", "a,", ",b", ","})
    void readCarNames_InputCarNamesLessThan2_ErrorMessagePrints(String input) {
        try {
            command(input);
            GameInput.readCarNames();
        } catch (NoSuchElementException ignore) {
        }
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("readNumTurns() 3을 입력하면, 3")
    void readNumTurns_InputNumTurns3_Int3() {
        int num = 0;
        try {
            command("3");
            num = GameInput.readNumTurns();
        } catch (NoSuchElementException ignore) {
        }
        assertThat(num).isEqualTo(3);
    }

    @ParameterizedTest(name = "readNumTurns() 1 미만의 수({arguments})를 입력하면, 에러 메시지 출력")
    @ValueSource(strings = {"-1", "0"})
    void readNumTurns_InputTooLongCarNames_ErrorMessagePrints(String input) {
        try {
            command(input);
            GameInput.readNumTurns();
        } catch (NoSuchElementException ignore) {
        }
        assertThat(output()).contains(ERROR_MESSAGE);
    }
}
