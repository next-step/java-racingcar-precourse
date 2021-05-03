import domain.Car;
import domain.Cars;
import domain.MoveCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Racing;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class racingTest {

    private Racing racing;

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
        Cars cars = new Cars("Test1");
        MoveCalculator moveCalculator = new MoveCalculator();
        assertThat(moveCalculator.getRandomValue()).isLessThanOrEqualTo(9).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("차량 이동에 따른 거리값 설정 체크.")
    @Test
    void checkMoveCarTest() {
        Car testCar = new Car("test1");
        testCar.moveCar();
        assertThat(testCar.getCarDistance().getDistance()).isEqualTo(1);
    }

    @DisplayName("승자확인 체크")
    @Test
    void checkWinnerTest() {
        Car testCar1 = new Car("test1");
        testCar1.moveCar();
        testCar1.moveCar();

        Car testCar2 = new Car("test2");
        testCar2.moveCar();
        testCar2.moveCar();
        testCar2.moveCar();

        Car testCar3 = new Car("test3");
        testCar3.moveCar();
        testCar3.moveCar();

        racing.getRaceWinner();
    }
}
