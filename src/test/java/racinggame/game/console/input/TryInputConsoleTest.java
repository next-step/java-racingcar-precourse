package racinggame.game.console.input;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class TryInputConsoleTest extends BaseTest<TryInputConsole> {

    private static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String TRY_ERROR_MESSAGE = "[ERROR] 1이상의 정수만 입력 가능합니다.";

    private static TryInputConsole tryInputConsole;

    @BeforeAll
    public static void onlyOnce() {
        tryInputConsole = new TryInputConsole(TRY_INPUT_MESSAGE, TRY_ERROR_MESSAGE);
    }


    @DisplayName("1 이상 정수인지 검증")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "0, false",
            "1.5, false",
            "-1, false",
            "a, false",
    })
    void testIsValidPolicy(String inputValue, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(tryInputConsole, "isValidPolicy", String.class);
        boolean result = (boolean) method.invoke(tryInputConsole, inputValue);
        assertThat(result == expectedResult).isTrue();
    }

}