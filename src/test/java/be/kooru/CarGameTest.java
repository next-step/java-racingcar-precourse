package be.kooru;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarGameTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("ABC"));
        cars.add(new Car("DEF"));
        cars.add(new Car("GHI"));
        cars.add(new Car("KLM"));
    }

    @Test
    public void CAR_GAME_생성() {
        //given
        CarGame carGame = new CarGame(cars);

        // cars 외부 삭제 작업
        int size = cars.size();
        for (int i = 0; i < size; i++) {
            cars.remove(0);
        }
        //when 1회 시행
        carGame.start();

        //then
        Assertions.assertThat(carGame.maxScoreCarList())
                .isNotNull()
                .hasSizeBetween(1, size);
    }


    @Test
    public void CAR_GAME_한번_수행() {
        //given
        CarGame carGame = new CarGame(Arrays.asList(new Car("ABC")));

        //when
        carGame.start();

        //then
        Assertions.assertThat(carGame.maxScoreCarList().get(0))
                .isNotNull()
                .isEqualTo("ABC");
        carGame.printCarWinner();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    public void CAR_GAME_생성_및_여러번수행(int nums) {
        //given
        CarGame carGame = new CarGame(cars);

        //when
        for (int i = 0; i < nums; i++) {
            carGame.start();
        }

        //then
        Assertions.assertThat(carGame.maxScoreCarList())
                .isNotNull()
                .hasSizeBetween(1, cars.size());
        carGame.printCarWinner();
    }
}