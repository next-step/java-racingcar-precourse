package racingcar.nextstep.domain.racing;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.nextstep.domain.car.Car;
import racingcar.nextstep.domain.car.CarName;
import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;
import racingcar.nextstep.domain.racing.chart.RacingCharts;
import racingcar.nextstep.domain.racing.service.RacingFactory;
import racingcar.nextstep.infrastructure.racing.RacingFactoryImpl;

import static org.assertj.core.api.Assertions.*;

class RacingFactoryTest {

    RacingFactory racingFactory = new RacingFactoryImpl();

    @Test
    @DisplayName("입력 받은 자동차 이름들을 쉼표 기준으로 구분하기")
    void splitCarsNameWithComma() {
        //given
        final String carNameList = "pobi,crong,honux";
        //when
        final String[] result = racingFactory.splitCarsNameWithComma(carNameList);
        //then
        assertThat(result).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("String 배열을 CarsName 객체로 변환하기")
    void createCarsName() {
        //given
        final String[] carNameList = {"pobi", "crong", "honux"};
        //when
        final CarsName carsName = racingFactory.createCarsName(carNameList);
        //then
        assertThat(carsName.getCarNames().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("RacingCharts 일급 컬렉션 객체를 만들기")
    void createRacingCharts() {
        //given
        final Cars cars = Cars.of(Lists.newArrayList(Car.of(CarName.of("aaa")), Car.of(CarName.of("bbb")), Car.of(CarName.of("ccc"))));
        //when
        final RacingCharts racingCharts = racingFactory.createRacingCharts(cars);
        //then
        assertThat(racingCharts.getRacingResults().size()).isEqualTo(3);
        assertThat(racingCharts.getRacingResults().get(0).getCar().getCarName().getValue()).isEqualTo("aaa");

    }
}