package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.rule.MoveRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundTest {

  @Test
  @DisplayName("라운드마다 자동차들의 레이스 결과를 기록한다.")
  void record() {
    // given
    Cars cars = Cars.generateFromInputString("gmoon");
    MoveRule alwaysForward = () -> true;

    // when
    cars = cars.race(alwaysForward);
    Round roundOne = Round.record(cars, 3);
    cars = cars.race(alwaysForward);
    Round roundTwo = Round.record(cars, 2);
    cars = cars.race(alwaysForward);
    Round roundThree = Round.record(cars, 1);

    // then
    assertAll(
            () -> assertThat(roundOne.getCars().getValues()).contains(new Car("gmoon").move(alwaysForward)),
            () -> assertThat(roundTwo.getCars().getValues()).contains(new Car("gmoon").move(alwaysForward).move(alwaysForward)),
            () -> assertThat(roundThree.getCars().getValues()).contains(new Car("gmoon").move(alwaysForward).move(alwaysForward).move(alwaysForward))
    );
  }
}