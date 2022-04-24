package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car.Car;
import racingcar.model.Car.Name;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
  @ParameterizedTest(name="자동차_이름_입력_생성_성공 | {0}")
  @ValueSource(strings = {"12345", "abcde"})
  @EmptySource
  void 자동차_이름_입력_생성_성공(String carName) {
    Car car = new Car(carName);
    assertThat(car).isNotNull();
    Name name = car.getName();
    assertThat(name).isEqualTo(new Name(carName));
    assertThat(name.toString()).isEqualTo(carName);
  }

  @ParameterizedTest(name="자동차_이름_생성_실패 | {0}")
  @ValueSource(strings = {"123456"})
  @NullSource
  void 자동차_이름_생성_실패(String carName) {
    assertThatThrownBy(() -> {
      Car car = new Car(carName);
    })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]");
  }

  @ParameterizedTest(name="자동차_이동후_출력  | {0} | {1}")
  @CsvSource({
      "0,        'test : '",
      "1,        'test : -'",
      "5,        'test : -----'",
  })
  void 자동차_이동후_출력(int moveCounts, String result) {
    Car car = new Car("test");
    for (int i = 0; i < moveCounts; i++) {
      car.move();
    }
    assertThat(car.toString()).isEqualTo(String.format("%s", result));
  }
}