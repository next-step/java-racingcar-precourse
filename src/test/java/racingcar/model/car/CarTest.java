package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.vo.CarName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @DisplayName("Position은 Config.MOVING_STANDARD_NUM 값 기준으로 이상일시, distance 1증가 시키고, 증가 갯수만큼 '-'를 생성한여 string으로 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "1, 0, ''",
            "3, 0, ''",
            "5, 1, -"
    })
    void getPosition_검증(int input, int distance, String position) {
        //given
        Car car = new Car(new CarName("Test"));

        //when
        car.setDistance(input);

        //then
        assertThat(car.getDistance()).isEqualTo(distance);
        assertThat(car.getPosition()).isEqualTo(position);
    }}
