import static org.junit.jupiter.api.Assertions.assertEquals;

import DTO.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("생성시 이름을 초기화")
    void checkName() {
//        given
//        자동차 객체는 이름을 주면 생성자에 의해 해당이름과 0을 갖는 객체가 생성된다.
        Car car = new Car("test");
//        when

//        then
        assertEquals(car.getName(), "test");
    }

    @Test
    @DisplayName("plusNum 실행시 num이 1 증가")
    void plusNum() {
//        given
//        자동차 객체는 이름을 주면 생성자에 의해 해당이름과 0을 갖는 객체가 생성된다.
        Car car = new Car("test");
//        when
//        경계값
//        updateNum의 입력으로 사용되는 값은 Util.Util.generateRandomNumber에 의해 생성되므로 입력값 검증은 따로 하지 않는다.
        car.plusNum();
        car.plusNum();
        car.plusNum();

//        then
        assertEquals(car.getNum(), 3);
    }
}