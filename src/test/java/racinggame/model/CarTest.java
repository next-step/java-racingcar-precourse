package racinggame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private String carName;
    private int nowPosition;
    private Car car;

    @BeforeEach
    @DisplayName("객체 생성 기본 조건 set_up")
    void setUp() {
        this.carName = "carName";
        this.nowPosition = 0;
        this.car = new Car(carName);
    }


    @Test
    @DisplayName("Car 객체 기본 생성 조건 확인")
    void Car_객체_기본_생성_조건_확인() {

        String carName = "carName";

        Car car = new Car(carName);

        assertThat(this.car).isNotNull();
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("Car 객체 기본 생성 조건 확인")
    void Car_객체_메소드를_통한_변수_불러오기() {

        String testCarName = "carName";
        int testNowPosition = 0;

        assertThat(car.confirmCarName()).isEqualTo(testCarName);
        assertThat(car.confirmNowPosition()).isEqualTo(testNowPosition);
    }

    @Test
    @DisplayName("Car 객체 앞으로 한 칸 이동")
    void Car_객체_앞으로_한_칸_이동() {
        //given
        car.moveForward();

        //when

        //then
        assertThat(car.confirmNowPosition()).isEqualTo(++nowPosition);
        assertThat(car.confirmNowPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car 객체 앞으로 세 칸 이동")
    void Car_객체_앞으로_세_칸_이동() {
        //given
        car.moveForward();
        car.moveForward();
        car.moveForward();

        //when

        //then
        assertThat(car.confirmNowPosition()).isEqualTo(3);
    }
    @Test
    @DisplayName("Car 객체 멈춤 상태 유지")
    void Car_객체_멈춤_상태_유지() {
        //given
        car.stayHere();

        //when

        //then
        assertThat(car.confirmNowPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 객체 멈춤 상태 유지")
    void 멈춘_후_이동() {
        //given
        car.stayHere();
        car.moveForward();

        //when

        //then
        assertThat(car.confirmNowPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car 객체 멈춤 상태 유지")
    void 이동_후_멈춤_후_이동() {
        //given
        car.moveForward();
        car.stayHere();
        car.moveForward();

        //when

        //then
        assertThat(car.confirmNowPosition()).isEqualTo(2);
    }


}