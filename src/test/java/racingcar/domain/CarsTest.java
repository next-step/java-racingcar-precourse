package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CarsTest extends NsTest {
    @ParameterizedTest
    @ValueSource(strings = {"test1,test2,test1"})
    void 자동차_이름_중복_예외_처리_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> carNames = Arrays.asList(input.split(","));
            new Cars().enrollRacing(carNames);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1,over5Len,test3"})
    void 자동차_이름_길이_예외_처리_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> carNames = Arrays.asList(input.split(","));
            new Cars().enrollRacing(carNames);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "\n"})
    void 자동차_입력_개수_예외_처리_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> carNames = Arrays.asList(input.split(","));
            new Cars().enrollRacing(carNames);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1,test2,test3", "car1,car2,car3,car4"})
    void Cars_자동차_이름_등록_정상_테스트(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        Cars cars = new Cars();
        cars.enrollRacing(carNames);
        List<Car> carList = cars.getCars();
        List<String> createCarNames = new ArrayList<>();
        for (Car car : carList) {
            createCarNames.add(car.getName());
        }

        for (int i = 0; i < carNames.size(); i++) {
            assertThat(carNames.get(i)).isEqualTo(createCarNames.get(i));
        }
    }

    @Test
    void Car_정상_이동_테스트() {
        Car car = new Car("test");
        car.moveForward(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.moveForward(4);
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
