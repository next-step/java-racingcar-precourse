package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameMissionUtilsScannerTest {

    GameMissionUtilsScanner scanner = new GameMissionUtilsScanner();

    @DisplayName("validateNotNull 통과")
    @Test
    void ok_validateNotNull() {
        assertDoesNotThrow(() -> scanner.validateNotNull(""));
    }

    @DisplayName("validateNotNull exception")
    @Test
    void fail_validateNotNull() {
        assertThrows(IllegalArgumentException.class, () -> scanner.validateNotNull(null));
    }

    @DisplayName("validateNotEmpty 통과")
    @Test
    void ok_validateNotEmpty() {
        assertDoesNotThrow(() -> scanner.validateNotEmpty("abc"));
    }

    @DisplayName("validateNotEmpty exception")
    @Test
    void fail_validateNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> scanner.validateNotEmpty(null));
        assertThrows(IllegalArgumentException.class, () -> scanner.validateNotEmpty(""));
    }

    @DisplayName("validateIsNumberFormat 통과")
    @Test
    void ok_validateIsNumberFormat() {
        assertDoesNotThrow(() -> scanner.validateIsNumberFormat("123"));
    }

    @DisplayName("validateIsNumberFormat exception")
    @Test
    void fail_validateIsNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> scanner.validateIsNumberFormat(null));
        assertThrows(IllegalArgumentException.class, () -> scanner.validateIsNumberFormat(""));
        assertThrows(IllegalArgumentException.class, () -> scanner.validateIsNumberFormat("a"));
        assertThrows(IllegalArgumentException.class, () -> scanner.validateIsNumberFormat("a123"));
        assertThrows(IllegalArgumentException.class, () -> scanner.validateIsNumberFormat("123a"));
    }

    @DisplayName("validateCarNameLength 통과")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void ok_validateCarNameLength(String input) {
        assertDoesNotThrow(() -> scanner.validateCarNameLength(input));

    }

    @DisplayName("validateIsNumberFormat exception")
    @Test
    void fail_validateCarNameLength() {
        assertThrows(IllegalArgumentException.class, () -> scanner.validateCarNameLength(null));
        assertThrows(IllegalArgumentException.class, () -> scanner.validateCarNameLength("123456"));
    }

    @DisplayName("addIfNotEmpty 테스트")
    @Test
    void test_addIfNotEmpty() {
        List<String> stringList = new ArrayList<>();

        scanner.addIfNotEmpty(stringList, "");
        assertThat(stringList.size()).isEqualTo(0);

        scanner.addIfNotEmpty(stringList, "1");
        assertThat(stringList.size()).isEqualTo(1);
    }

    @DisplayName("splitCarName name 1개 테스트")
    @ParameterizedTest
    @CsvSource(value = {"a:a", " a :a", "  a  :a"}, delimiter = ':')
    void test_splitCarName01(String input, String carName) {
        List<String> carNameList = scanner.splitCarName(input);
        assertThat(carNameList.size()).isEqualTo(1);
        assertThat(carNameList.get(0)).isEqualTo(carName);
    }

    @DisplayName("splitCarName name 2개 테스트")
    @ParameterizedTest
    @CsvSource(value = {"a,b:a:b", "c    ,   d     :c:d"}, delimiter = ':')
    void test_splitCarName02(String input, String carName1, String carName2) {
        List<String> carNameList = scanner.splitCarName(input);
        assertThat(carNameList.size()).isEqualTo(2);
        assertThat(carNameList.get(0)).isEqualTo(carName1);
        assertThat(carNameList.get(1)).isEqualTo(carName2);
    }

    @DisplayName("splitCarName name 1개 테스트 - 글자수가 5자 초과")
    @ParameterizedTest
    @CsvSource(value = {"abcdef:abcdef"}, delimiter = ':')
    void test_splitCarName03(String input, String carName) {
        assertThrows(IllegalArgumentException.class, () -> {
            List<String> carNameList = scanner.splitCarName(input);
        });
    }
}