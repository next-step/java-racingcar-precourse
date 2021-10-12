package racinggame.game.console.input;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameInputConsoleTest extends BaseTest<CarNameInputConsole> {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자리 이하 문자만 입력 가능합니다.(공백 입력 불가)";

    private static CarNameInputConsole carNameInputConsole;

    @BeforeAll
    public static void onlyOnce() {
        carNameInputConsole = new CarNameInputConsole(CAR_NAME_INPUT_MESSAGE, CAR_NAME_ERROR_MESSAGE);
    }

    @DisplayName("유효한 입력값인지 검증")
    @ParameterizedTest
    @CsvSource({
            "'ab,cd', true",
            "'ab,cd,ef,gh,ij', true",
            "'ab', true",
            "' ', false",
            "'abcdef', false",
            "'abcdef,ab', false",
    })
    void testIsValidPolicy(String inputValue, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(carNameInputConsole, "isValidPolicy", String.class);
        boolean result = (boolean) method.invoke(carNameInputConsole, inputValue);
        assertThat(result == expectedResult).isTrue();
    }

    @DisplayName("입력값에서 이름 추출")
    @ParameterizedTest
    @CsvSource({
            "'ab,cd', 2",
            "'ab,cd,ef,gh,ij', 5",
            "'ab', 1",
            "' ', 1",
            "'abcdef', 1",
            "'abcdef,ab', 2",
    })
    void testMakeCarNames(String inputValue, int expectedResultSize) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(carNameInputConsole, "makeCarNames", String.class);
        List<String> result = (List<String>) method.invoke(carNameInputConsole, inputValue);
        assertThat(result.size() == expectedResultSize).isTrue();
    }

    @DisplayName("입력값 공백인지 검증")
    @ParameterizedTest
    @CsvSource({
            "'ab', false",
            "' ', true",
    })
    void testIsWhiteSpace(String inputValue, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(carNameInputConsole, "isWhiteSpace", String.class);
        boolean result = (boolean) method.invoke(carNameInputConsole, inputValue);
        assertThat(result == expectedResult).isTrue();
    }

    @DisplayName("입력값 6자 이상인지 검증")
    @ParameterizedTest
    @CsvSource({
            "abcde, false",
            "abcdef, true",
    })
    void testIsOverMaxLength(String inputValue, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(carNameInputConsole, "isOverMaxLength", String.class);
        boolean result = (boolean) method.invoke(carNameInputConsole, inputValue);
        assertThat(result == expectedResult).isTrue();
    }

}