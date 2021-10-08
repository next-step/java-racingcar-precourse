package domain;

import domain.exceptions.CarException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("이름과 전진 횟수를 가진 자동차 생성")
    public void createCar(){
        Car car = new Car("lee");

        String carName = car.getName();
        int carMoveCount = car.getMoveCount();

        assertThat(carName).isEqualTo("lee");
        assertThat(carMoveCount).isEqualTo(1);
    }

    @Test
    @DisplayName("이름이 5자 초과인 자동차 생성시 에러 발생")
    public void errorCarNameOverFive(){
        assertThatThrownBy(()->{
            Car car = new Car("leeyoungjun");
        }).isInstanceOf(CarException.class);
    }

}
