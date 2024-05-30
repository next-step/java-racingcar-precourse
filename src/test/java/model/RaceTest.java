package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    Race race = new Race();
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void init() {
        Car car1 = new Car();
        Car car2 = new Car();
        car1.setName("kakao");
        car1.setPosition(3);
        car2.setName("pobi");
        car2.setPosition(2);

        cars.add(car1);
        cars.add(car2);

        race.setCars(cars);
    }

    @Test
    @DisplayName("이름 리스트 저장 및 조회 확인")
    public void checkGetterSetter() {
        List<Car> carList = race.getCars();

        Assertions.assertThat(carList.get(0).getName()).isEqualTo("kakao");
    }

    @Test
    @DisplayName("우승자 조회 확인")
    public void getWinners() {
        List<Car> winners = race.getWinners();

        Assertions.assertThat(winners.get(0).getName()).isEqualTo("kakao");
        Assertions.assertThat(winners.size()).isEqualTo(1);
    }
}
