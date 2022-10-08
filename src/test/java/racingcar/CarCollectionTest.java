package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.CarCollection;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarCollectionTest {

    @Nested
    @DisplayName("자동차컬렉션을 생성하는 create메소드는")
    class Create {

        @Test
        @DisplayName("입력값검증에서 null값이면 예외발생")
        void throw_NullPointException_when_null() {
            //given
            String carNames = null;

            //when,then
            assertThatThrownBy(() -> CarCollection.create(carNames))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessageContaining("[ERROR] 자동차이름이 존재해야합니다");
        }

        @Test
        @DisplayName("입력값검증에서 쉼표로 구분한 문자열개수가 쉼표+1개수보다 적으면 예외발생")
        void throw_IllegalArgumentException_when_not_separation_by_commas() {
            //given
            String carNames = "awfwaf,";

            //when,then
            assertThatThrownBy(() -> CarCollection.create(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 자동차이름은 쉼표를 기준으로 구분할 수 있어야합니다");
        }

        @Test
        @DisplayName("입력값검증에서 쉼표로 구분한 문자열중 중복이 있으면 예외발생")
        void throw_IllegalArgumentException_when_exist_duplicate_name() {
            //given
            String carNames = "awfwaf,awfwaf,VAWE";

            //when,then
            assertThatThrownBy(() -> CarCollection.create(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 자동차이름은 중복될 수 없습니다");
        }

    }


    @Test
    @DisplayName("자동자객체를 담은 리스트생성")
    void returns_carlist() {
        //given
        String carNames = "aw,aawV,VOW";

        //when
        CarCollection carCollection = CarCollection.create(carNames);
        List<Car> cars = carCollection.getCars();

        //then
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열을 입력하면 쉼표개수+1만큼 자동자객체생성")
    void returns_carlist_when_input_string_separated_by_commas() {
        //given
        String carNames = "awfek,vawe,wab";

        //when
        CarCollection carCollection = CarCollection.create(carNames);
        List<Car> cars = carCollection.getCars();

        //then
        assertThat(cars.size()).isEqualTo(3);
    }


}
