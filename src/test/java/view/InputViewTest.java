package view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    public InputStream originalIn;

    @BeforeEach
    void setUpStreams() {
        originalIn = System.in;
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 정상 입력")
    void inputCarNames_normal_case() {

        // given
        String input = "pobi,crong,honux";
        systemIn(input);

        // when
        List<String> expected = List.of("pobi", "crong", "honux");
        List<String> actual = InputView.inputCarNames();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - CarNameLengthException 발생")
    void inputCarNames_car_name_invaid_length() {

        // given
        String input = "pobihello,crong,honux\npobi,crong,honux";
        systemIn(input);

        // when
        List<String> expected = List.of("pobi", "crong", "honux");
        List<String> actual = InputView.inputCarNames();
        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - CarCountLessThenTwoException 발생")
    void inputCarNames_car_count_less_then_two() {

        // given
        String input = "pobi\npobi,crong";
        systemIn(input);

        // when
        List<String> expected = List.of("pobi", "crong");
        List<String> actual = InputView.inputCarNames();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - DuplicatedCarNameException 발생")
    void inputCarNames_duplicated_car_name() {

        // given
        String input = "pobi,pobi\npobi,crong,honux";
        systemIn(input);

        // when
        List<String> expected = List.of("pobi", "crong", "honux");
        List<String> actual = InputView.inputCarNames();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트 - 정상 입력")
    void inputAttemptCount_normal_case() {

        // given
        String input = "5";
        systemIn(input);

        // when
        int expected = 5;
        int actual = InputView.inputAttemptCount();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트 - NoneIntegerArgumentException 발생")
    void inputAttemptCount_none_integer() {

        // given
        String input = "hello\n5";
        systemIn(input);

        // when
        int expected = 5;
        int actual = InputView.inputAttemptCount();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트 - AttemptBelowZeroException 발생")
    void inputAttemptCount_attempt_below_zero() {

        // given
        String input = "-5\n5";
        systemIn(input);

        // when
        int expected = 5;
        int actual = InputView.inputAttemptCount();

        // then
        assertEquals(expected, actual);
    }

    private void systemIn(String input) {
        String inputString = input + "\n";
        InputView.setScanner(new Scanner(new ByteArrayInputStream(inputString.getBytes())));
    }
}