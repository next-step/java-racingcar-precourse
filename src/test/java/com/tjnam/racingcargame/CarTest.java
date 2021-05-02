package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static String testCarName = "Testing car";
    private static Car car;

    @BeforeAll
    public static void setUp(){
        car = new Car(new CarName(testCarName));
    }

    @Test
    public void constructCarPositionTest(){
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void moveCarTest(){
        Car newTestCar = new Car(new CarName("New Test Car"));
        newTestCar.moveCar();
        assertThat(newTestCar.getPosition()).isEqualTo(1);

        int movingTime = 10;
        for (int i=0 ; i<movingTime ; i++) {
            newTestCar.moveCar();
        }
        assertThat(newTestCar.getPosition()).isEqualTo(11);
    }

    @Test
    public void getCarName(){
        assertThat(car.getCarName()).isEqualTo(testCarName);
    }

}
