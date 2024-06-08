package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

  @Test
  public void carInitialization() {
    Car car = new Car("pobi");
    assertThat(car.getName()).isEqualTo("pobi");
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  public void carNameValidation_Null() {
    assertThatThrownBy(() -> new Car(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
  }

  @Test
  public void carNameValidation_Empty() {
    assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
  }

  @Test
  public void carNameValidation_TooLong() {
    assertThatThrownBy(() -> new Car("pobipobi"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
  }

  @Test
  public void carCanMove() {
    Car car = new Car("pobi");
    assertThat(car.canMove(4)).isTrue();
    assertThat(car.canMove(9)).isTrue();
    assertThat(car.canMove(3)).isFalse();
  }

  @Test
  public void carMovesPosition() {
    Car car = new Car("pobi");
    car.move();
    assertThat(car.getPosition()).isEqualTo(1);
  }
}
