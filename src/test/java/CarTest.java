import static org.junit.jupiter.api.Assertions.*;

import DTO.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("4미만의 값이 들오올 경우")
    void DontUpdateNum() {
//        given
//        자동차 객체는 이름을 주면 생성자에 의해 해당이름과 0을 갖는 객체가 생성된다.
        Car car = new Car("test");
//        when
//        경계값
//        updateNum의 입력으로 사용되는 값은 Util.Util.generateRandomNumber에 의해 생성되므로 입력값 검증은 따로 하지 않는다.
        car.updateNum(3);
//        then
        assertEquals(car.getNum(), 0);
    }

    @Test
    @DisplayName("4이상의 값이 들오올 경우")
    void UpdateNum() {
//        given
//        자동차 객체는 이름을 주면 생성자에 의해 해당이름과 0을 갖는 객체가 생성된다.
        Car car = new Car("test");
//        when
//        경계값
//        updateNum의 입력으로 사용되는 값은 Util.Util.generateRandomNumber에 의해 생성되므로 입력값 검증은 따로 하지 않는다.
        car.updateNum(4);
//        then
        assertEquals(car.getNum(), 1);
    }
}