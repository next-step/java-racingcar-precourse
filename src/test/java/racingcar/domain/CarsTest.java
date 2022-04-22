package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.engine.Engine;
import racingcar.generator.TestNumberGenerator;

public class CarsTest {

    private List<Car> testCars;

    @BeforeEach
    void beforeEach() {
        testCars = new ArrayList<>();
        testCars.add(Car.from(Name.from("자동차_1")));
        testCars.add(Car.from(Name.from("자동차_2")));
        testCars.add(Car.from(Name.from("자동차_3")));
        testCars.add(Car.from(Name.from("자동차_4")));
        testCars.add(Car.from(Name.from("자동차_5")));
    }

    @Test
    @DisplayName("1급 컬랙션을 이용해 여러대 자동차를 생성하여 관리할 수 있다.")
    void generate01() {
        // given
        // when
        Cars cars = Cars.from(testCars);

        // then
        Assertions.assertEquals(5, cars.size());
    }

    @Test
    @DisplayName("Cars 도메인에 Car 도메인을 동적으로 추가할 수 있다.")
    void generate02() {
        // given
        // when
        Cars cars = Cars.from(testCars);
        cars.add(Car.from(Name.from("신차_1")));
        cars.add(Car.from(Name.from("신차_2")));

        // then
        Assertions.assertEquals(7, cars.size());
    }

    @DisplayName("run() 메소드를 통해 전체 Car 도메인의 run()을 호출한다. 전진 상태 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carsRun01(Integer randomValue) {
        // given
        List<Car> list = new ArrayList<>();
        Engine engine = Engine.createBy(new TestNumberGenerator(randomValue));
        list.add(Car.of(Name.from("자동차_1"), engine));
        list.add(Car.of(Name.from("자동차_2"), engine));
        list.add(Car.of(Name.from("자동차_3"), engine));

        Cars cars = Cars.from(list);

        // when
        cars.run();

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, cars.getIdx(0).getDistance()),
                () -> Assertions.assertEquals(1, cars.getIdx(1).getDistance()),
                () -> Assertions.assertEquals(1, cars.getIdx(2).getDistance())
        );
    }

    @DisplayName("run() 메소드를 통해 전체 Car 도메인의 run()을 호출한다. 멈춤 상태 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void carsRun02(Integer randomValue) {
        // given
        List<Car> list = new ArrayList<>();
        Engine engine = Engine.createBy(new TestNumberGenerator(randomValue));
        list.add(Car.of(Name.from("자동차_1"), engine));
        list.add(Car.of(Name.from("자동차_2"), engine));
        list.add(Car.of(Name.from("자동차_3"), engine));

        Cars cars = Cars.from(list);

        // when
        cars.run();

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, cars.getIdx(0).getDistance()),
                () -> Assertions.assertEquals(0, cars.getIdx(1).getDistance()),
                () -> Assertions.assertEquals(0, cars.getIdx(2).getDistance())
        );
    }
}
