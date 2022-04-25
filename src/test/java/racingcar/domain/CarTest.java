package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    Car leeCar;

    @BeforeEach
    void setUp(){
         leeCar = new Car(new CarName("lee"));
    }

    @Test
    @DisplayName("자동차 정보")
    void getCarData(){
        assertThat(leeCar.getName()).isEqualTo("lee");
        assertThat(leeCar.getPosition()).isEqualTo(0);

    }

    @Test
    @DisplayName("이름이 같으면 동일한 차")
    void equalCar(){
        Car leeCar2 = new Car(new CarName("lee"));
        assertTrue(leeCar.isEqual(leeCar2));
    }

    @Test
    @DisplayName("Random 숫자가 4 이상일 경우 전진 ")
    void move(){
        leeCar.move(4);
        assertThat(leeCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("Random 숫자가 4미만 일 경우 정지 ")
    void stop(){
        Car leeCar = new Car(new CarName("lee"));
        leeCar.move(3);
        assertThat(leeCar.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 위치를 기반으로 이름과 위치 출력")
    void printCarPosition(){
        for (int count=0 ; count <3; count++){
            leeCar.move(5);
        }
        String printCar = leeCar.print();
        assertThat(leeCar.getPosition()).isEqualTo(3);
        assertThat(printCar).isEqualTo("lee : ---");
    }

}