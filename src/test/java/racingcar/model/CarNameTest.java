package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.code.ErrorCode;

@DisplayName("자동차 이름 객체 단위 테스트")
class CarNameTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void constructorTest() {

        //given //when
        CarName carName = new CarName("12345");

        //then
        assertThat(carName).isInstanceOf(CarName.class);
    }

    @DisplayName("이름이 5자가 넘을 경우 에러 발생 테스트")
    @Test
    void constructorExceptionTest() {
        //given
        String longerThenFive = "123456";

        //when //then
        assertThatThrownBy(() -> new CarName(longerThenFive)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.CAR_NAVE_OVER_MAX_LENGTH.getErrorMessage());
    }

    @DisplayName("이름을 반환하는 테스트")
    @Test
    void getCarNameTest() {

        //given
        String carName = "차이름";
        CarName carNameObject = new CarName(carName);

        //when
        String result = carNameObject.getCarName();

        //then
        assertThat(result).isEqualTo(carName);
    }

    @DisplayName("이름이 null일 경우 에러 발생 테스트")
    @Test
    void carNameNullTest() {

        //given
        String carName = null;

        //when //then
        assertThatThrownBy(() -> new CarName(carName)).isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorCode.CAR_NAME_NULL.getErrorMessage());
    }

    @DisplayName("차의 이름이 공백일 경우 에러 발생 테스트")
    @Test
    void carNameEmptyTest() {

        //given
        String carName = "";

        //when//then
        assertThatThrownBy(() -> new CarName(carName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.CAR_NAME_IS_EMPTY.getErrorMessage());
    }
}
