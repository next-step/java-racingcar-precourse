package com.tjnam.racingcargame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void initializeTest(){
        List<CarName> carNames = new ArrayList<CarName>();
        carNames.add(new CarName("Car1"));
        carNames.add(new CarName("Car2"));
        carNames.add(new CarName("Car3"));
        assertThat(carNames.size()).isEqualTo(3);
    }

    @Test
    public void getWinnerTest(){
        List<Car> carList = new ArrayList<Car>();
        Car car1 = new Car(new CarName("car1"));
        int moveCnt = 10;
        for (int i=0 ; i<moveCnt * 3 ; i++) {
            car1.moveCar();
        }

        Car car2 = new Car(new CarName("car2"));
        for (int i=0 ; i<moveCnt * 2 ; i++) {
            car2.moveCar();
        }

        Car car3 = new Car(new CarName("car3"));
        for (int i=0 ; i<moveCnt * 1 ; i++) {
            car3.moveCar();
        }
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        Cars cars = new Cars(carList);

        List<Car> winners = cars.getWinner();
        assertThat(winners.get(0).getCarName()).isEqualTo("car3");
        assertThat(winners.get(0).getPosition()).isEqualTo(moveCnt * 3);

        for (int i=0 ; i<moveCnt * 1 ; i++) {
            car2.moveCar();
        }

        winners = cars.getWinner();
        assertThat(winners.size()).isEqualTo(2);
    }

}
