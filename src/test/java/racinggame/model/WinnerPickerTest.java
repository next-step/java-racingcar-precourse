package racinggame.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.enums.RANDOM_MOVE_RESULT;
import racinggame.vo.Car;
import racinggame.vo.CarLocation;
import racinggame.vo.Cars;
import racinggame.vo.PlayerName;

public class WinnerPickerTest {
    private WinnerPicker winnerPicker;

    @BeforeEach
    void setup() {
        this.winnerPicker = new WinnerPicker();

        Cars cars = new Cars();
        cars.add(new Car(new PlayerName("defaultCar1"), new CarLocation()));
        cars.add(new Car(new PlayerName("defaultCar2"), new CarLocation()));
        cars.add(new Car(new PlayerName("defaultCar3"), new CarLocation()));

        this.winnerPicker.standBy(cars);
    }

    @Test
    void 우승자_후보_자동차의_위치값이_현재_우승자들의_위치값과_동일하면_우승자_목록에_입력된_후보를_추가하고_TRUE를_리턴한다() {
        int prevWinnerCount = this.winnerPicker.getWinnerCars().size();

        Assertions.assertThat(this.winnerPicker.tryPick(new Car(new PlayerName("testCar"), new CarLocation()), RANDOM_MOVE_RESULT.FORWARD)).isTrue();
        Assertions.assertThat(this.winnerPicker.getWinnerCars().size()).isEqualTo(prevWinnerCount + 1);
    }

    @Test
    void 우승자_후보_자동차의_위치값이_현재_우승자들의_위치값보다_크면_우승자_목록을_초기화하고_입력된_후보만_추가한_후_TRUE를_리턴한다() {
        int prevWinnerCount = this.winnerPicker.getWinnerCars().size();

        Assertions.assertThat(this.winnerPicker.tryPick(new Car(new PlayerName("testCar"), new CarLocation(10)), RANDOM_MOVE_RESULT.FORWARD)).isTrue();
        Assertions.assertThat(this.winnerPicker.getWinnerCars().size()).isEqualTo(1);
    }

    @Test
    void 우승자_후보_자동차의_위치값이_현재_우승자들의_위치값보다_작으면_우승자_목록에_넣지_않고_FALSE를_리턴한다() {
        int prevWinnerCount = this.winnerPicker.getWinnerCars().size();

        Assertions.assertThat(this.winnerPicker.tryPick(new Car(new PlayerName("testCar"), new CarLocation(-10)), RANDOM_MOVE_RESULT.STAY)).isFalse();
        Assertions.assertThat(this.winnerPicker.getWinnerCars().size()).isEqualTo(prevWinnerCount);
    }
}
