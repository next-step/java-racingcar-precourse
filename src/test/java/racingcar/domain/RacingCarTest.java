package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @DisplayName("동일하게 이동한 RacingCar 은 동일한 이동거리를 갖는다.")
    @Test
    void sameDistance() {
        RacingCar fistCar = new RacingCar("one", (n) -> true);
        RacingCar secondCar = new RacingCar("two", (n) -> true);

        fistCar.move(0);
        secondCar.move(0);

        assertThat(fistCar.hasSameDistance(secondCar)).isTrue();
    }

    @DisplayName("표준 이동 전력을 사용시 값이 4이상이면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    void go(int number) {

        RacingCar actual = new RacingCar("act", new StandardMovingStrategy());
        RacingCar expect = new RacingCar("exp", (n) -> true);

        actual.move(number);
        expect.move(number);

        assertThat(actual.hasSameDistance(expect)).isTrue();
    }

    @DisplayName("표준 이동 전력을 사용시 값이 3이하이면 정지한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void stop(int number) {

        RacingCar actual = new RacingCar("act", new StandardMovingStrategy());
        RacingCar expect = new RacingCar("exp", (n) -> true);

        actual.move(number);
        expect.move(number);

        assertThat(actual.hasSameDistance(expect)).isFalse();
    }

    @DisplayName("자동차를 출력하면 '이름 : 이동거리' 로 출력된다.")
    @ParameterizedTest
    @CsvSource(value = {"one:1:-", "two:2:--", "three:3:---"}, delimiter = ':')
    void print(String name, int movingDistance, String positionString) {

        RacingCar racingCar = new RacingCar(name, (number) -> true);

        for (int i = 0; i < movingDistance; i++) {
            racingCar.move(0);
        }

        assertThat(racingCar.toString()).isEqualTo(name + " : " + positionString);
    }

    @DisplayName("자동차의 이동거리 순으로 정렬이 가능하다.")
    @Test
    void sort() {
        List<RacingCar> cars = new ArrayList<>();

        cars.add(new RacingCar("zero", (n) -> true));
        cars.add(new RacingCar("one", (n) -> true));
        cars.add(new RacingCar("two", (n) -> true));

        cars.get(2).move(0);
        cars.get(2).move(0);
        cars.get(2).move(0);
        cars.get(1).move(0);
        cars.get(0).move(0);
        cars.get(0).move(0);
        cars.sort(RacingCar::compareTo);

        List<String> carNames = new ArrayList<>();

        for (RacingCar car : cars) {
            carNames.add(car.getRacingCarName());
        }

        assertThat(carNames).containsExactly("one", "zero", "two");
    }
}
