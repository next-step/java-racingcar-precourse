package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    void 우승자_조회_한명일경우() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi",3));
        carList.add(new Car("woni",2));
        carList.add(new Car("bubb",4));

        List<Car> winnerList = Winners.getWinners(carList);
        assertThat(winnerList.size()).isEqualTo(1);
        assertThat(winnerList.get(0)).isEqualTo(new Car("bubb",4));
    }

    @Test
    void 우승자_조회_여러명일경우() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi",3));
        carList.add(new Car("woni",2));
        carList.add(new Car("bubb",3));

        List<Car> winnerList = Winners.getWinners(carList);
        assertThat(winnerList.size()).isEqualTo(2);
        assertThat(winnerList)
                .isEqualTo(Arrays.asList(new Car("pobi",3), new Car("bubb",3)));
    }

}
