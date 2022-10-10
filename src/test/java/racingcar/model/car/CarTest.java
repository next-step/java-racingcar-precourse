package racingcar.model.car;

import org.junit.jupiter.api.Test;
import racingcar.model.strategy.RandomNumberMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 이동전략에_따라_자동차_전진_정지_테스트() {
        RandomNumberMoveStrategy strategy = new RandomNumberMoveStrategy();
        Car moveCar = new Car("move");
        Car stopCar = new Car("stop");

        strategy.setMoveLimit(0);
        moveCar.move(strategy);
        assertThat(moveCar.getCarPosition().equals(new CarPosition(1)));

        strategy.setMoveLimit(10);
        stopCar.move(strategy);
        assertThat(stopCar.getCarPosition().equals(new CarPosition(0)));
    }

}
