package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    public void generate_car_test() {
        //given
        String carName = "giraffelim";

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    @DisplayName("Car 이동 테스트")
    public void move_car_test(int randomNumber, int expectedCarDistance) {
        //given
        String carName = "giraffelim";

        //when
        Car car = new Car(carName);
        car.changeDistance(randomNumber);

        //then
        assertThat(car.getDistance()).isEqualTo(expectedCarDistance);
    }

    @Test
    @DisplayName("현재 Car의 거리 하이픈(-)변환 테스트")
    public void convert_distance_to_hyphen_test() {
        //given
        String carName = "giraffelim";

        //when
        Car car = new Car(carName);
        car.changeDistance(6);
        car.changeDistance(3);
        car.changeDistance(7);

        //then
        assertThat(car.convertDistanceToHyphen()).isEqualTo("--");
    }
}
