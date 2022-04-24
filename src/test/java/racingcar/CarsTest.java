package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsTest {

    @Test
    @DisplayName("차량_여러대_이름_출력")
    void 차량_여러대_이름_출력() {
        Cars players = new Cars(Arrays.asList("pobi", "woni", "jun"));
        assertThat(players.findCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("차량_여러대_결과_출력_전진")
    void 차량_여러대_결과_출력_전진() {
        Cars players = new Cars(Arrays.asList("pobi", "woni", "jun"));
        for (Car car : players.findCars()) {
            car.setPosition(6);
        }
        assertThat(players.getResults()).isEqualTo("pobi : -\nwoni : -\njun : -");
    }

    @Test
    @DisplayName("차량_여러대_결과_출력_멈춤")
    void 차량_여러대_결과_출력_멈춤() {
        Cars players = new Cars(Arrays.asList("pobi", "woni", "jun"));
        for (Car car : players.findCars()) {
            car.setPosition(2);
        }
        assertThat(players.getResults()).isEqualTo("pobi : \nwoni : \njun : ");
    }
}
