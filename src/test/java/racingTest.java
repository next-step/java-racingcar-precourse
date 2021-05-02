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
        racing = new Racing("test1");
    }

    @DisplayName("자동차 이름 길이 체크.")
    @Test
    void checkCarNameLengthTest() {
        Car carOverLength = new Car("asdfd");
        assertThat(carOverLength.getCarName().getName().length()).isGreaterThan(5);
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

    @DisplayName("0~9 랜덤 한자리수 생성 체크.")
    @Test
    void checkRandomValueTest() {
        cars = new Cars("Test1");
        assertThat(cars.getRandomValue()).isLessThanOrEqualTo(9).isGreaterThanOrEqualTo(0);
    }

    @Test
    void checkMoveCarTest() {
        Car testCar = new Car("test1");
        testCar.moveCar();
        assertThat(testCar.getCarDistance().getDistance()).isEqualTo(1);
    }
}
