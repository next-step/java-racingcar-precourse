package camp.nextstep.edu.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    private Input input;

    @BeforeEach
    void init() {
        this.input = new Input(new Scanner(System.in));
    }

    @DisplayName("자동차 이름의 길이가 5이하인 1대 이상 자동차 이름을 쉼표로 구분하여 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,woni,jun",
            "pobi",
            "pobi, woni"
    })
    void validateCarNames(String carNames) {
        String[] arrCarNames = input.validateCarNames(carNames);
        String[] expected = carNames.replaceAll("\\s", "").split(",");
        assertArrayEquals(expected, arrCarNames);
    }

    @DisplayName("자동차 이름은 1개 이하로 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " "
    })
    void checkCarCount(String carNames) {
        assertThrows(IllegalArgumentException.class, () -> {
            input.validateCarNames(carNames);
        });
    }

    @DisplayName("길이가 5 초과인 자동차 이름은 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "aaaaaa",
            "aaaaaaa, bbbb",
            "aa,bbbbbb"
    })
    void checkCarNameLength(String carNames) {
        assertThrows(IllegalArgumentException.class, () -> {
            input.validateCarNames(carNames);
        });
    }

    @DisplayName("1 이상 숫자인 시도 횟수를 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "10",
            "100"
    })
    void validateMoveCount(String moveCount) {
        int count = input.validateMoveCount(moveCount);
        int expected = Integer.parseInt(moveCount);
        assertEquals(expected, count);
    }

    @DisplayName("숫자로 변환할 수 없는 시도 횟수는 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "a123b",
            "1ab",
            "ab45",
            " ",
            ""
    })
    void checkNumberFormat(String moveCount) {
        assertThrows(IllegalStateException.class, () -> {
            input.validateMoveCount(moveCount);
        });
    }

    @DisplayName("1보다 작은 시도 횟수는 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "0",
            "-100"
    })
    void checkMoveCount(String moveCount) {
        assertThrows(IllegalArgumentException.class, () -> {
            input.validateMoveCount(moveCount);
        });
    }
}
