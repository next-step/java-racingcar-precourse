package domainTest;

import racinggame.domain.Car;
import racinggame.domain.exceptions.CarException;
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
        assertThat(carMoveCount).isEqualTo(0);
    }

    @Test
    @DisplayName("이름이 5자 초과인 자동차 생성시 에러 발생")
    public void errorCarNameOverFive(){
        assertThatThrownBy(()->{
            Car car = new Car("leeyoungjun");
        }).isInstanceOf(CarException.class);
    }

    @Test
    @DisplayName("Random 값이 4일 경우 전진")
    public void carMoveRandomValueFour(){
        Car car = new Car("lee");
        car.move(4);

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("Random 값이 3일 경우 정지")
    public void carMoveRandomValueThree(){
        Car car = new Car("lee");

        car.move(3);

        assertThat(car.getMoveCount()).isEqualTo(0);
    }

}
