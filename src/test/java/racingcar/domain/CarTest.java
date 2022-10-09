package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car("test", 0, "");
  }

  @ParameterizedTest
  @DisplayName("4이상 일시 자동차 전진")
  @CsvSource({ "0, false", "3, false", "4, true" })
  void 자동차전진(Integer distance, boolean isMove) {
    car.isMove(distance);
    assertThat(car.getDistance() != 0).isEqualTo(isMove);
  }

  @ParameterizedTest
  @DisplayName("3이하 일시 자동차 멈춤")
  @CsvSource({ "0, true", "3, true", "4, false" })
  void 자동차멈춤(Integer distance, boolean isMove) {
    car.isMove(distance);
    assertThat(car.getDistance() == 0).isEqualTo(isMove);
  }

}
