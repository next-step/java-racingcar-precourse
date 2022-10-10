package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value={"4,1", "3,0"}, delimiter = ',')
    @DisplayName("자동차 전진 멈춤 테스트 (4이상 포지션++, 3이하 멈춤)")
    public void carMoveTest(int given, int expected){
        //when
        Car car = new Car("jpp");
        car.move(given);

        //then
        assertThat(car.getCarPosition().getPosition()).isEqualTo(expected);
    }

}
