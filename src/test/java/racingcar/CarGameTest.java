package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

class CarGameTest {
    @Test
    void 자동차_이름_입력() {
        Cars cars = new Cars();
        String errorNameList="car1,car1";
        String carsNameList = "car1,car2";
        try {
            cars.generateCars(errorNameList);
        } catch (IllegalArgumentException e) {
            cars.generateCars(carsNameList);
        }
        assertThat(cars.getCars().get(0).getName()).isEqualTo("car1");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("car2");
    }

    @Test
    void 라운드_횟수_입력() {
        Round round = new Round();
        try {
            round.generateRound("에러");
        } catch (IllegalArgumentException e) {
            round.generateRound("5");
        }
        assertThat(round.getCount()).isEqualTo(5);
    }

    @Test
    void 라운드_진행() {
        Cars cars = Cars_생성();
        Round round = Round_생성();
        int count = 0;
        while (count < round.getCount()) {
            라운드_회차(cars);
            count++;
        }
        assertThat(cars.getCars().get(0).getScore()).isEqualTo(5);
    }

    @Test
    void 승자_출력() {
        Cars cars = Cars_생성();
        cars.getCars().get(0).progress(1);
        cars.getCars().get(0).progress(1);
        cars.getCars().get(1).progress(4);
        cars.getCars().get(1).progress(4);
        Collections.sort(cars.getCars());
        assertThat(cars.getCars().get(0).getName()).isEqualTo("car2");
    }

    void 라운드_회차(Cars cars) {
        for (Car car : cars.getCars()) {
            int value = 5;
            car.progress(value);
        }
    }

    Cars Cars_생성() {
        Cars cars = new Cars();
        String carsNameList="car1,car2";
        cars.generateCars(carsNameList);

        return cars;
    }

    Round Round_생성() {
        String count = "5";
        Round round = new Round();
        round.generateRound(count);

        return round;
    }
}
