package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.model.Car.Cars;
import racingcar.utils.Message;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarsTest {
  @Test
  void Cars_생성후_결과_출력() {
    {
      Cars cars = new Cars("test1,test2,test3");
      String report = cars.print();
      assertThat(report).isEqualTo(
          "test1 : \n" +
          "test2 : \n" +
          "test3 : "
      );
    }
  }

  @ParameterizedTest(name = "Cars_생성_오류: | {0}")
  @NullAndEmptySource
  void CarsCreateTest(String val) {
    {
      assertThatThrownBy(() -> {
        Cars cars = new Cars(val);
      })
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(Message.ASK_CAR_NAMES);
    }
  }

  @Test
  void Cars_Move_결과_출력() {
    {
      Cars cars = new Cars("test1,test2,test3");
      for (int i = 0; i < 5; i++) {
        cars.drive((car) -> true);
      }
      String report = cars.print();
      assertThat(report).isEqualTo(
          "test1 : -----\n" +
              "test2 : -----\n" +
              "test3 : -----"
      );
      assertThat(cars.getLastPosition().getValue()).isEqualTo(5);
      assertThat(
          cars.getCarsOnPosition(cars.getLastPosition()).size()
      ).isEqualTo(3);
    }
    {
      Cars cars = new Cars("test1,test2,test3");
      for (int i = 0; i < 3; i++) {
        cars.drive((car) -> "test1".equals(car.getName().toString()));
      }
      for (int i = 0; i < 5; i++) {
        cars.drive((car) -> "test2".equals(car.getName().toString()));
      }
      String report = cars.print();
      assertThat(report).isEqualTo(
          "test1 : ---\n" +
              "test2 : -----\n" +
              "test3 : "
      );
      assertThat(cars.getLastPosition().getValue()).isEqualTo(5);
      assertThat(
          cars.getCarsOnPosition(cars.getLastPosition()).size()
      ).isEqualTo(1);
    }
  }
}