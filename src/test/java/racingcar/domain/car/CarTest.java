package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"1234", "race", "car" })
    public void 자동차_성공(String name){
        final Car testCar = Car.of(CarName.of(name));
        assertThat(testCar).isNotNull();


    }
    @ParameterizedTest
    @ValueSource(strings = {"    ", "123456", "", })
    public void 자동차_이름_유효성_체크(String name){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> CarName.of(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "race", "car" })
    public void 자동차_이름_체크(String name){
        String carName =  Car.of(CarName.of(name)).getCarName();
        assertThat(carName).isNotNull();

    }

    @ParameterizedTest
    @ValueSource(strings = {"test" })
    public void 자동차_위치_체크(String name){
        int position =  Car.of(CarName.of(name)).getPosition();
        assertThat(position).isZero();

    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 0", "3, 0", "4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1"})
    public void 움직임_테스트 (int randomNumber, int position){
        Car car = Car.of(CarName.of("test"));
        MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
        mockedRandoms.when(()->Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomNumber);
        car.move();
        mockedRandoms.close();
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
