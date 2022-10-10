package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {
    @Test
    @DisplayName("자동차 일급콜렉션이 정상 생성(사이즈 및 값 일치)을 확인한다.")
    void initTest() {
        // given
        List<String> carNames = Lists.list("car1", "car2", "car3");

        // when
        Cars cars = Cars.fromStringList(carNames);

        //then
        assertThat(cars.getCarList()).as("일급콜렉션의 자동차 목록 사이즈가 입력한 자동차 목록 사이즈와 일치하는지 확인")
                .hasSameSizeAs(carNames);

        for (Car car : cars.getCarList()) {
            assertThat(carNames).contains(car.getCarName());
        }
    }

    @Test
    @DisplayName("(예외 테스트) 자동차 일급콜렉션에 중복된 자동차 이름을 입력하면 IllegalArgumentException이 발생한다.")
    void exception() {
        // given
        List<String> carNames = Lists.list("same", "same");

        //then
        assertThatIllegalArgumentException().as("Exception 클래스 및 에러 메시지 일치 여부 확인")
                .isThrownBy(
                        // when
                        () -> Cars.fromStringList(carNames)
                )
                .withMessage("중복된 자동차 이름이 존재합니다.");
    }

    @ParameterizedTest(name = "자동차 일급콜렉션 내 우승한 자동차 목록을 반환한다.[자동차 별 이동횟수: {0}, {1}, {2} / 우승한 차 번호: {3}]")
    @CsvSource(value = {
            "3,2,1, 0",
            "1,3,2, 1",
            "1,2,3, 2",
            "3,3,1, 01",
            "3,1,3, 02",
            "1,3,3, 12",
            "3,3,3, 012",
    })
    void getWinnerCarNames(int moveCountCar0, int moveCountCar1, int moveCountCar2, String winnerCarIndexesString) {
        // given
        List<String> carNames = Lists.list("car0", "car1", "car2");
        Cars cars = Cars.fromStringList(carNames);
        List<Car> carList = cars.getCarList();

        moveCarByInputPower(carList.get(0), moveCountCar0);
        moveCarByInputPower(carList.get(1), moveCountCar1);
        moveCarByInputPower(carList.get(2), moveCountCar2);

        List<Integer> winnerCarIndexes = transferStringToIntegerList(winnerCarIndexesString);
        List<Car> expectedWinnerCars = getExpectedWinnerCars(carList, winnerCarIndexes);

        // when
        List<String> winnerCarNames = cars.getWinnerCarNames();

        //then
        assertThat(winnerCarNames).as("실제 우승 자동차 목록과 예상 우승 자동차 목록의 사이즈가 같은지 확인")
                .hasSameSizeAs(expectedWinnerCars);

        for (Car expectedWinnerCar : expectedWinnerCars) {
            boolean isWinnerCarsContainExpected = winnerCarNames.contains(expectedWinnerCar.getCarName());

            assertThat(isWinnerCarsContainExpected).as("예상되는 우승 자동차가 실제 우승한 자동차 목록에 포함되는지 확인한다.")
                    .isTrue();
        }
    }

    private List<Integer> transferStringToIntegerList(String targetString) {
        List<String> strings = Lists.list(targetString.split(""));
        List<Integer> integers = new ArrayList<>();
        strings.forEach(s -> integers.add(Integer.parseInt(s)));
        return integers;
    }

    private List<Car> getExpectedWinnerCars(List<Car> carList, List<Integer> winnerCarIndexes) {
        List<Car> winnerCars = new ArrayList<>();
        for (int winnerCarIndex : winnerCarIndexes) {
            winnerCars.add(
                    carList.get(winnerCarIndex)
            );
        }

        return winnerCars;
    }

    void moveCarByInputPower(Car car, int count) {
        for (int i = 0; i < count; i++) {
            car.moveByAccelPower(AccelPower.from(
                    AccelPower.MIN_POWER_TO_MOVE
            ));
        }
    }
}
