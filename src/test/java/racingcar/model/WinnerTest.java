package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.model.Car.Cars;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class WinnerTest {
  @Test
  void 우승자_출력_테스트() {
    {
      Cars cars = new Cars("aaaa");
      cars.drive((car) -> true);
      Winner winner = new Winner(cars);
      assertThat(winner.print()).isEqualTo("최종 우승자 : aaaa");
    }
    {
      Cars cars = new Cars("aaaa,bbbb,ccc");
      cars.drive((car) -> true);
      Winner winner = new Winner(cars);
      assertThat(winner.print()).isEqualTo("최종 우승자 : aaaa,bbbb,ccc");
    }
  }
}