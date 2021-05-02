import domain.Car;
import domain.Cars;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Racing;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class racingTest {

    private Racing racing;

    private Cars cars;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("자동차 이름 길이 체크.")
    @Test
    void checkCarNameLengthTest() {
        Car carOverLength = new Car("asdfd");
        assertThat(carOverLength.getCarName().getName().length()).isGreaterThan(4);
    }

    @DisplayName("자동차 이름 목록을 특수문자로 각각 나누기 체크.")
    @Test
    void getDeviceValueTest() {
        racing = new Racing("a,b");
        assertThat(racing.getCars().getCars().get(0).getCarName().getName()).isEqualTo("a");
    }

    @DisplayName("자동차 기본 이동거리값 0 설정 체크.")
    @Test
    void checkCarDistanceTest() {
        Car carOverLength = new Car("asdfd");
        assertThat(carOverLength.getCarDistance().getDistance()).isEqualTo(0);
    }

    @DisplayName("랜덤수를 기준값 기준으로 비교한뒤 boolean으로 리턴이 정상적으로 되는지 체크.")
    @Test
    void checkRandomValue() {
        Car testCar = new Car("test1");
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(testCar);
        Cars testCars = new Cars(testCarList);

        assertThat(testCars.isGreaterThanCheckValue()).isFalse();
    }
}
