package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.MoveCount;
import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RaceTest {

    @DisplayName("이름으로 자동차들을 만든다")
    @Test
    void create() {
        //given
        String name1 = "pobi";
        String name2 = "crong";

        //when
        List<Car> cars = Race.mapCars(name1, name2);

        //then
        assertThat(cars).hasSize(2);
    }

    @DisplayName("우승자가 한 명일 때")
    @Test
    void winner() {
        //given
        Car car1 = Car.of("pobi", 1);
        Car car2 = Car.of("crong", 3);
        Car car3 = Car.of("honux", 2);
        Race race = Race.from(car1, car2, car3);

        //when
        List<String> actual = race.getWinner();

        //then
        assertThat(actual).containsOnly("crong");
    }

    @DisplayName("우승자가 여러 명일 때")
    @Test
    void winners() {
        //given
        Car car1 = Car.of("pobi", 3);
        Car car2 = Car.of("crong", 4);
        Car car3 = Car.of("honux", 4);
        Race race = Race.from(car1, car2, car3);

        //when
        List<String> actual = race.getWinner();

        //then
        assertThat(actual).containsOnly("crong", "honux");
    }

    @DisplayName("이동 횟수만큼 자동차가 움직인다")
    @Test
    void startRaceWith() {
        //given
        Car car = mock(Car.class);
        MoveCount moveCount = MoveCount.fromString("5");
        given(car.name()).willReturn(new Name("pobi"));
        given(car.position()).willReturn(new Position(3));

        //when
        Race.from(car).startWith(moveCount);

        //then
        verify(car, times(moveCount.get())).moveBy(any());
    }


    @DisplayName("빈 목록인 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenEmpty() {
        //given
        String[] empty = ",,".split(",");

        //when
        Throwable thrown = catchThrowable(() -> Race.from(empty));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차는 1대 이상이어야 한다.");
    }

    @DisplayName("경주할 자동차는 최대 10대까지 가능하다")
    @Test
    void thrownExceptionWhenMaxCars() {
        //given
        String[] carNames = longCarsNames();

        //when
        Throwable thrown = catchThrowable(() -> Race.from(carNames));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차는 10대 이하여야 한다.");
    }

    private String[] longCarsNames() {
        final int GRATER_THAN_CAR_LIST_SIZE = 11;
        final String[] names = new String[GRATER_THAN_CAR_LIST_SIZE];
        for (int i = 0; i < GRATER_THAN_CAR_LIST_SIZE; i++) {
            names[i] = String.format("car%d", i);
        }
        return names;
    }
}
