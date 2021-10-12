package racinggame.game.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarNamesTest extends BaseTest<CarNames> {

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
        CarNames carNames = new CarNames(inputValue);
        Method method = super.getPrivateMethod(carNames, "makeCarNames", String.class);
        List<String> result = (List<String>) method.invoke(carNames, inputValue);
        assertThat(result.size() == expectedResultSize).isTrue();
    }


    @DisplayName("입력값 검증")
    @ParameterizedTest
    @CsvSource({
            "'ab,cd', true",
            "'ab,cd,ef,gh,ij', true",
            "' ', false",
            "'abcdefg', false",
    })
    void testIsValid(String inputValue, boolean expectedResult) {
        CarNames carNames = new CarNames(inputValue);
        assertThat(carNames.isValid() == expectedResult).isTrue();
    }
}