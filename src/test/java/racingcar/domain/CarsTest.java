package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;
    private static final Position MOVE_POSITION = new Position(1);
    private static final Position STOP_POSITION = new Position(0);

    @Test
    void 모든_차량_전진() {
        Cars cars = Cars.of(new CarNames("car1,car2,car3"));
        cars.move(() -> new Condition(MOVE));
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(MOVE_POSITION);
        }
    }

    @Test
    void 모든_차량_정지() {
        Cars cars = Cars.of(new CarNames("car1,car2,car3"));
        cars.move(() -> new Condition(STOP));
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(STOP_POSITION);
        }
    }

}