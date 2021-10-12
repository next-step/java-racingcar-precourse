package racinggame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("Car 객체 기본 생성 조건 확인")
    void Car_객체_기본_생성_조건_확인() {

        String carName = "carName";
        int nowPosition = 0;

        Car car = new Car(carName, nowPosition);


    }

    @Test
    @DisplayName("Car 객체 기본 생성 조건 확인")
    void Car_객체_메소드를_통한_변수_불러오기() {

        String carName = "carName";
        int nowPosition = 0;

        Car car = new Car(carName, nowPosition);

        assertThat(car.confirmCarName()).isEqualTo(carName);
        assertThat(car.confirmNowPosition()).isEqualTo(nowPosition);
    }

}