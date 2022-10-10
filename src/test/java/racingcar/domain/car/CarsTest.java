package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.*;
import racingcar.domain.game.GameRoundResult;
import racingcar.domain.strategy.CarMovingStrategy;
import racingcar.domain.strategy.RandomNumberGenerateStrategy;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.domain.Fixtures.car1;
import static racingcar.domain.Fixtures.car2;

public class CarsTest {

    @Test
    @DisplayName("자동차 리스트로 일급컬렉션 Cars를 생성한다.")
    void test_createCars() {
        assertDoesNotThrow(() -> Cars.createCarsWithCarList(Arrays.asList(car1(), car2())));
    }

    @ParameterizedTest
    @MethodSource("invalidSizeCarList")
    @DisplayName("자동차가 1개 이하인 리스트로 일급컬렉션 Cars를 생성하면 IllegalArgumentExceptiond을 반환한다. ")
    void createCars_withEmptyList(List<Car> cars) {
        assertThatThrownBy(() -> Cars.createCarsWithCarList(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최소 2대가 필요합니다.");
    }

    private static Stream<Arguments> invalidSizeCarList() {
        return Stream.of(
                Arguments.of(new ArrayList<>()),
                Arguments.of(Collections.singletonList(Car.createCar("1")))
        );
    }

    @Test
    @DisplayName("자동차들을 게임 한라운드 플레이한다.")
    void testMoveCars() {
        //given
        Cars cars = Cars.createCarsWithCarList(Arrays.asList(car1(), car2()));

        //when
        cars.carsPlayRound();

        //then
        assertAll(
                () -> assertThat(car1().getPosition().getIntPosition()).isBetween(0, 1),
                () -> assertThat(car2().getPosition().getIntPosition()).isBetween(0, 1)
        );
    }

    @Test
    @DisplayName("자동차들을 게임 한라운드 플레이하면 GameRoundResult을 반환한다.")
    void testMoveCars_returnWithGameRoundResult() {
        //given
        Cars cars = Cars.createCarsWithCarList(Arrays.asList(car1(), car2()));
        GameRoundResult gameRoundResult = cars.carsPlayRound();

        //when
        Map<CarName, CarPosition> playedOneRoundResultMap = gameRoundResult.getGameRoundResultMap();
        //then
        assertAll(
                () -> assertThat(playedOneRoundResultMap.size()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("최종 우승자들의 이름을 반환한다.")
    void test_getWinners() {
        //given
        Car car1 = car1();
        car1.playRound(CarStatus.MOVE);
        car1.playRound(CarStatus.MOVE);

        Car car2 = car2();
        car2.playRound(CarStatus.MOVE);
        car2.playRound(CarStatus.STOP);

        Car car3 = Car.createCar("3");
        car3.playRound(CarStatus.MOVE);
        car3.playRound(CarStatus.MOVE);

        Cars cars = Cars.createCarsWithCarList(Arrays.asList(car1, car2, car3));

        //when
        List<CarName> winnerCarNames = cars.getWinnerCarNames().getCarNames();

        //then
        assertAll(
                () -> assertThat(winnerCarNames.contains(car1.getName())).isTrue(),
                () -> assertThat(winnerCarNames.contains(car3.getName())).isTrue()
        );
    }

    @Test
    @DisplayName("반환받은 자동차들의 정보들은 수정하려고 하면 UnsupportedOperationException을 반환한다.")
    void test_cannotModify() {
        //given
        Cars cars = Cars.createCarsWithCarList(Arrays.asList(car1(), car2()));

        //when
        List<Car> carList = cars.getCars();

        //then
        assertThatThrownBy(() -> carList.add(Car.createCar("car3")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
