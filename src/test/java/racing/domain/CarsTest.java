package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.rule.MoveRule;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

  @Test
  @DisplayName("자동차 일급 컬렉션 생성 테스트, 자동차 이름은 쉼표(\",\")로 구분한다.")
  void generateFromInputString() {
    // given
    String input = "gmoon,guest";

    // when
    Cars actual = Cars.generateFromInputString(input);

    // then
    assertThat(actual.getValues())
            .containsExactly(new Car("gmoon"), new Car("guest"));
  }

  @Test
  @DisplayName("자동차 경주 테스트")
  void race() {
    // given
    String input = "gmoon,guest";
    Cars newCars = Cars.generateFromInputString(input);

    // when
    MoveRule alwaysForward = () -> true;
    Cars actual = newCars.race(alwaysForward);

    // then
    assertThat(actual.getValues())
            .containsExactly(new Car("gmoon").move(alwaysForward),
                    new Car("guest").move(alwaysForward));
  }

  @Test
  @DisplayName("자동차들의 최대 위치 값을 반환한다.")
  void getMaxPosition() {
    // given
    String input = "gmoon,guest";
    Cars newCars = Cars.generateFromInputString(input);

    // when
    MoveRule alwaysForward = () -> true;
    Cars actual = newCars.race(alwaysForward);

    // then
    assertThat(actual.getMaxPosition()).isEqualTo(Position.create().move());
  }
}