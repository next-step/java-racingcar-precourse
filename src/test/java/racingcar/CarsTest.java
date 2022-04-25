package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    Cars cars;
    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.addCar(new String[]{"K3","K4","K5","K6","K8","K7"},5);
    }

    @Test
    void Cars에_Car여러개담기(){
        assertThat(cars.carList).isInstanceOf(List.class);
    };
    @Test
    void 게임시작하기(){
        assertThat(cars.startGame())
                .isInstanceOf(String.class)
                .isNotEmpty();
    }
    @Test
    void 우승자_가져오기(){
        assertThat(cars.getWinner())
                .contains("최종 우승자:");
    }
}