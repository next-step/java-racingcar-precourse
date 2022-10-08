package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import racingcar.util.RandomNumberGenerator;

class CarTest {
    @Test
    void 자동차_생성_테스트() {
        assertThatCode(() -> new Car(new CarName("sun"))).doesNotThrowAnyException();
    }

    @Test
    void 자동차_이동_테스트() {
        try (MockedStatic<RandomNumberGenerator> randomNumberMock = mockStatic(RandomNumberGenerator.class)) {
            randomNumberMock.when(() -> RandomNumberGenerator.getRandomNumber()).thenReturn(4);
            Car car = new Car(new CarName("sun"));
            car.move(new RandomMovableStrategy());
            assertThat(car.getPosition()).isEqualTo(new CarPosition(1));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"4:4:true", "4:5:false"}, delimiter = ':')
    void 차가_특정_차와_같은_위치에_있는지_확인할_수_있다(int position1, int position2, boolean isSamePosition) {
        Car car = new Car(new CarName("sun"), new CarPosition(position1));
        Car anotherCar = new Car(new CarName("yang"), new CarPosition(position2));
        assertThat(car.isSamePosition(anotherCar)).isEqualTo(isSamePosition);
    }

    @Test
    void Car_toString_호출_시_차의_이름과_위치가_하이픈으로_변환되어_출력된다() {
        Car car = new Car(new CarName("sun"), new CarPosition(5));
        assertThat(car.toString()).contains("sun : -----");
    }

    @ParameterizedTest
    @CsvSource(value = {"3:4:-1", "3:3:0", "4:3:1"}, delimiter = ':')
    void Car_는_CarPosition_을_기준으로_비교할_수_있다(int position1, int position2, int expectedValue) {
        Car car1 = new Car(new CarName("sun"), new CarPosition(position1));
        Car car2 = new Car(new CarName("yang"), new CarPosition(position2));
        assertThat(car1.compareTo(car2)).isEqualTo(expectedValue);
    }
}