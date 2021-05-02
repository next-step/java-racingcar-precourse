package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.NameLengthExceedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

  @Test
  @DisplayName("자동차는 5자 이상의 이름을 가질 수 없다.")
  void newInstance() {
    assertAll(
            () -> assertThat(new Car("gmoon")).isEqualTo(new Car("gmoon")),
            () -> assertThatExceptionOfType(NameLengthExceedException.class)
                    .isThrownBy(() -> new Car("123456"))
                    .withMessageMatching("자동차 이름은 \\d+자 이하만 가능하다."));
  }

  @Test
  @DisplayName("자동차가 이동할 경우 position 값 증가된다.")
  void move() {
    // given
    String name = "gmoon";

    // when
    Car moveCar = new Car(name).move(() -> true);

    // then
    assertThat(moveCar).isEqualTo(new Car(new Name(name), new Position(1)));
  }
}