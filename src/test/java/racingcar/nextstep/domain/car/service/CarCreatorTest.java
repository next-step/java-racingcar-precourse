package racingcar.nextstep.domain.car.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.car.CarsName;
import racingcar.nextstep.domain.racing.service.RacingFactory;
import racingcar.nextstep.infrastructure.car.CarCreatorImpl;
import racingcar.nextstep.infrastructure.racing.RacingFactoryImpl;

class CarCreatorTest {

    RacingFactory racingFactory = new RacingFactoryImpl();
    CarCreator carCreator = new CarCreatorImpl();

    @Test
    @DisplayName("자동차 일급 컬렉션 만드는 메소드")
    void createCars() {
        //given
        final String carNameList = "pobi,crong,honux";
        final CarsName carsName = racingFactory.createCarsName(racingFactory.splitCarsNameWithComma(carNameList));
        //when
        final Cars cars = carCreator.createCars(carsName);
        //then
        Assertions.assertThat(cars.getCars().size()).isEqualTo(3);
    }

}