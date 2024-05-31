package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidationTest {
    @Test
    @DisplayName("is validation class singleton pattern")
    void testGetInstance() {
        Validation validation1 = Validation.getInstance();
        Validation validation2 = Validation.getInstance();
        assertTrue(validation1.equals(validation2));
    }

    static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of(List.of("aaaa", "bbbb", "cccc"), true), // 정상 케이스
                Arguments.of(List.of("a", "a", "aa"), false), // 중복되는 이름이 있는 케이스
                Arguments.of(List.of("aaaaaa", "a", "aaa"), false), // 이름의 길이가 5글자를 넘어간 케이스
                Arguments.of(List.of(), false), // 한명도 참가하지 않은 케이스

                // 특수문자 및 escape 문자도 정상적으로 String안에 포함되므로 true가 나와야 한다.
                Arguments.of(List.of("@!~", "!@ds", "a\nb", "a\rb", "----", "::::", "^^^^", "\n", "\b", " "), true));
    }

    @ParameterizedTest
    @DisplayName("car name validation test")
    @MethodSource("generateCarNames")
    void testValidationCarName(List<String> carNames, boolean isNotValidated) {
        Validation validation = Validation.getInstance();
        assertTrue(validation.validationCarName(carNames) == isNotValidated);
    }

    static Stream<Arguments> generateTryCount() {
        return Stream.of(
                Arguments.of("1234", true),
                Arguments.of("5", true),
                Arguments.of("aaaa", false), // 문자열이 입력된 케이스
                Arguments.of("2147483648", false), // 정수의 최대 범위를 넘어간 케이스
                Arguments.of("-1", false), // 음수가 입력된 케이스
                Arguments.of("1.1", false), // 정수가 아닌 값이 입력된 케이스
                Arguments.of("-1.1", false)); // 정수가 아닌 값이 입력된 케이스
    }

    @ParameterizedTest
    @DisplayName("try count validation test")
    @MethodSource("generateTryCount")
    void testValidationTryCount(String tryCount, boolean isNotValidated) {
        Validation validation = Validation.getInstance();
        assertTrue(validation.validationTryCount(tryCount) == isNotValidated);
    }
}
