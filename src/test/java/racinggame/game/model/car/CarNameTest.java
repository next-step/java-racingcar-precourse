package racinggame.game.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameTest extends BaseTest<CarName> {

    @DisplayName("입력값에서 이름 추출")
    @Test
    void test() {
        String name = "car";
        CarName carName = new CarName(name);
        assertThat(name.equals(carName.getCarName())).isTrue();
    }

    @DisplayName("입력값 공백인지 검증")
    @ParameterizedTest
    @CsvSource({
            "'ab', false",
            "' ', true",
    })
    void testIsWhiteSpace(String inputValue, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        CarName carName = new CarName(inputValue);
        Method method = super.getPrivateMethod(carName, "isWhiteSpace", String.class);
        boolean result = (boolean) method.invoke(carName, inputValue);
        assertThat(result == expectedResult).isTrue();
    }

    @DisplayName("입력값 6자 이상인지 검증")
    @ParameterizedTest
    @CsvSource({
            "abcde, false",
            "abcdef, true",
    })
    void testIsOverMaxLength(String inputValue, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        CarName carName = new CarName(inputValue);
        Method method = super.getPrivateMethod(carName, "isOverMaxLength", String.class);
        boolean result = (boolean) method.invoke(carName, inputValue);
        assertThat(result == expectedResult).isTrue();
    }
}