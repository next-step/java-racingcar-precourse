package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.constant.ErrorConstants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGarageTest {

    private RaceGarage garage;

    @BeforeEach
    void setUp() {
        garage = new RaceGarage();
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,,,", ",,"})
    @DisplayName("비어있는 이름이 끼어있을 경우 IllegalArgumentException이 발생함")
    void test8(String userInput) {
        assertThatThrownBy(() -> garage.createCars(UserString.of(userInput))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.ERROR_EMPTY_NAME_IS_EXIST);
    }

    @Test
    @DisplayName("중복된 이름이 전달될 경우 IllegalArgumentException이 발생함")
    void test7() {
        assertThatThrownBy(() -> garage.createCars(UserString.of("car1,car1"))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.ERROR_CAR_NAME_DUPLICATED);
    }

    @Test
    @DisplayName("자동차는 20대를 초과할 수 없음")
    void test6() {
        assertThatThrownBy(() -> garage.createCars(UserString.of("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.ERROR_CAR_COUNT_IS_OVER_MAX_COUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("비어있는 문자열이 입력되면 IllegalArgumentException이 발생함")
    void test5(String value) {
        assertThatThrownBy(() -> garage.createCars(UserString.of(value))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.ERROR_USER_INPUT_BLANK);
    }

    @Test
    @DisplayName("이름이 하나일 때도 정상적으로 생성됨")
    void test3() {
        RaceCars car1 = garage.createCars(UserString.of("car1"));

        assertThat(car1.getCarCount().isSame(NaturalNumber.of(1))).isTrue();
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하여야 함")
    void test2() {
        assertThatThrownBy(() -> garage.createCars(UserString.of("car1:car2:car3"))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.ERROR_CAR_NAME_IS_TOO_LONG);
    }

    @Test
    @DisplayName("이름의 목록을 입력받아 경주 자동차들의 일급컬렉션인 RacingCars를 반환")
    void test1() {
        RaceCars racingCars = garage.createCars(UserString.of("car1,car2,car3"));

        assertThat(racingCars.getCarCount().isSame(NaturalNumber.of(3))).isTrue();
    }
}