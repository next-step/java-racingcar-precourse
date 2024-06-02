package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  @DisplayName("Create CarDTO Test")
  public void Create_CarDTO_Test() {
    //given
    CarDTO car = new CarDTO("abc");
    //when
    //then
    Assertions.assertThat(car.getName()).isEqualTo("abc");
    Assertions.assertThat(car.getDistance()).isEqualTo(0);
  }

  @Test
  @DisplayName("Move Car Test")
  public void Move_Car_Test() {
    //given
    CarDTO car = new CarDTO("abc");
    //when
    car.move(true);
    car.move(false);
    car.move(true);
    car.move(false);
    car.move(true);
    //then
    Assertions.assertThat(car.getDistance()).isEqualTo(3);
  }
}
