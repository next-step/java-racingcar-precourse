package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.RacingCar.RandomUtil;
import racingcar.TestUtil.FakeRandomUtil;

public class RacingCarTest {

    RacingCar makeRacingCarMovedAs(String car_name, int step) {
        RacingCar car = new RacingCar(new CarName(car_name));

        for (int i = 0; i < step; ++i) {
            car.move();
        }

        return car;
    }

    @ParameterizedTest
    @CsvSource(value = {"3:2:1", "1:4:-1", "2:2:0"}, delimiter = ':')
    @DisplayName("거리가 다른 경주 자동차과 비교할 수 있는지 검사한다")
    void compareBothRacingCars(int a_step, int b_step, int expected) {
        RacingCar a_car = makeRacingCarMovedAs("a_car", a_step);
        RacingCar b_car = makeRacingCarMovedAs("b_car", b_step);

        int result = a_car.compareTo(b_car);

        assertThat(result).isEqualTo(expected);
    }

    RacingCar makeRacingCarWithRandomValue(String car_name, int number) {
        RandomUtil fakeRandomUtil = new FakeRandomUtil(number);

        RacingCar test_car = new RacingCar(new CarName(car_name), fakeRandomUtil);

        return test_car;
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "7:1", "9:1"}, delimiter = ':')
    @DisplayName("4이상 랜덤값에서 경주 자동차가 한 칸 이동하는지 검사한다")
    void moveOneStepIfRandomIsGreaterEqualThan4(int random, int expectedDistance) {
        RacingCar test_car = makeRacingCarWithRandomValue("a_car", random);

        test_car.moveOrStop();
        Distance test_car_dist = test_car.getDistance();

        assertThat(test_car_dist.getNumericDistance()).isEqualTo(expectedDistance);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "1:0", "0:0"}, delimiter = ':')
    @DisplayName("3이하 랜던값에서 경주 자동차가 정지하는지 검사한다")
    void stopRacingCarIfRandomIsLessEqualThan3(int random, int expectedDistance) {
        RacingCar test_car = makeRacingCarWithRandomValue("a_car", random);

        test_car.moveOrStop();
        Distance test_car_dist = test_car.getDistance();

        assertThat(test_car_dist.getNumericDistance()).isEqualTo(expectedDistance);
    }
}
