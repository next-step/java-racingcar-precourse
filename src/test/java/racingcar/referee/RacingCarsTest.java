package racingcar.referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.domain.Car;
import racingcar.car.domain.CarName;
import racingcar.car.domain.CarPosition;
import racingcar.referee.domain.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주 자동차")
class RacingCarsTest {

    @DisplayName("경주 자동차 생성")
    @Test
    void createReferee() {
        RacingCars racingCars = new RacingCars();
        racingCars.add(new Car(new CarName("람보르기니"), new CarPosition()));
        racingCars.add(new Car(new CarName("페라리"), new CarPosition()));
        assertThat(racingCars.size()).isEqualTo(2);
    }

    @DisplayName("경주 자동차 중복된 이름 생성")
    @Test
    void createDuplicateCarName() {
        RacingCars racingCars = new RacingCars();
        racingCars.add(new Car(new CarName("람보르기니"), new CarPosition()));
        assertThatThrownBy(() -> racingCars.add(new Car(new CarName("람보르기니"), new CarPosition())))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 같은 이름의 자동차를 추가할 수 없습니다.");
    }
}
