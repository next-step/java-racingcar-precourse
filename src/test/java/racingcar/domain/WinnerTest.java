package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    @DisplayName("우승자 값 검증1")
    void winnerList1(){
        int maxScore = 3;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("car1"),new Position(3)));
        cars.add(new Car(new CarName("car2"),new Position(2)));
        cars.add(new Car(new CarName("car3"),new Position(1)));

        Winner winner = new Winner();

        Assertions.assertThat(winner.getCarName(cars,maxScore)).isEqualTo("최종 우승자 : car1");

    }

    @Test
    @DisplayName("우승자 값 검증2")
    void winnerList2(){
        int maxScore = 4;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("car1"),new Position(4)));
        cars.add(new Car(new CarName("car2"),new Position(4)));
        cars.add(new Car(new CarName("car3"),new Position(2)));

        Winner winner = new Winner();

        Assertions.assertThat(winner.getCarName(cars,maxScore)).isEqualTo("최종 우승자 : car1, car2");

    }

    @Test
    @DisplayName("우승자 값 검증3")
    void winnerList3(){
        int maxScore = 5;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("car1"),new Position(5)));
        cars.add(new Car(new CarName("car2"),new Position(5)));
        cars.add(new Car(new CarName("car3"),new Position(5)));

        Winner winner = new Winner();

        Assertions.assertThat(winner.getCarName(cars,maxScore)).isEqualTo("최종 우승자 : car1, car2, car3");

    }
}