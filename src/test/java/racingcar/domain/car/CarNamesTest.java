package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racingcar.domain.ErrorMessage.DUPLICATE_CAR_NAME;

class CarNamesTest {

    @Test
    @DisplayName("자동차들의 문자열 이름이 담긴 일급컬렉션을 생성한다.")
    void test_createWinnerStringCarNames() {
        //given
        String winner1 = "car1";
        String winner2 = "car2";

        List<String> carNameList = Arrays.asList(winner1, winner2);

        //when
        CarNames carNames = CarNames.createCarNamesWithStringCarName(carNameList);

        //then
        assertAll(
                () -> assertThat(carNames.getCarNames().get(0).isEquals(CarName.createCarName(winner1))).isTrue(),
                () -> assertThat(carNames.getCarNames().get(1).isEquals(CarName.createCarName(winner2))).isTrue()
        );
    }

    @Test
    @DisplayName("자동차들의 이름이 담긴 일급컬렉션을 생성한다.")
    void test_createWinnerCarNames() {
        //given
        CarName winner1 = CarName.createCarName("car1");
        CarName winner2 = CarName.createCarName("car2");

        List<CarName> carNameList = Arrays.asList(winner1, winner2);

        //when
        CarNames carNames = CarNames.createCarNamesWithCarName(carNameList);

        //then
        assertAll(
                () -> assertThat(carNames.getCarNames().get(0)).isEqualTo(winner1),
                () -> assertThat(carNames.getCarNames().get(1)).isEqualTo(winner2)
        );
    }

    @Test
    @DisplayName("같은 이름의 자동차로 자동치 이름 일급컬렉션을 생성하려고 하면 IllegalArgumentException을 반환한다.")
    void test_duplicateCarName() {
        //given
        List<String> duplicateName = Arrays.asList("car", "car");

        //when then
        assertThatThrownBy(() -> CarNames.createCarNamesWithStringCarName(duplicateName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("같은 자동차 이름은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("반환받은 자동차 이름들은 수정하려고 하면 UnsupportedOperationException을 반환한다.")
    void test_cannotModify() {
        //given
        String winner1 = "car1";
        String winner2 = "car2";

        CarNames carNames = CarNames.createCarNamesWithStringCarName(Arrays.asList(winner1, winner2));

        //when
        List<CarName> carNameList = carNames.getCarNames();

        //then
        assertThatThrownBy(() -> carNameList.add(CarName.createCarName("car3")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
