package racingcar.car.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {


  @DisplayName("문자열로 Car 객체를 만들 수 있다")
  @Test
  void carTest() {
    // given
    String input = "abc";

    // when
    Car car = new Car(input);

    // then
    assertThat(car.getName()).isEqualTo(input);
  }


  @DisplayName("Car 객체의 이름은 5자 이하여야 한다.")
  @Test
  void inputIndependenceNumberTest() {
    // given
    String wrongInput = "abcdef";

    // when, then
    assertThatThrownBy(() -> {
      new Car(wrongInput);
    }).isInstanceOf(IllegalArgumentException.class);

  }

  @DisplayName("Car 객체는 값이 4 이상이면 전진한다.")
  @Test
  void runTest() {
    // given
    Car car = new Car("ab");

    // when
    car.runOrStopByNumber(4);

    // then
    assertThat(car.getHistorySize()).isEqualTo(1);
  }

  @DisplayName("Car 객체는 값이 3 이하면 멈춘.")
  @Test
  void stopTest() {
    // given
    Car car = new Car("ab");

    // when
    car.runOrStopByNumber(2);

    // then
    assertThat(car.getHistorySize()).isEqualTo(0);
  }


}