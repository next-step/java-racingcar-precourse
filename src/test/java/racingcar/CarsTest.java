package racingcar;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    MoveCondition forwardMoveCondition = () -> true;

    Cars cars = new Cars(Lists.newArrayList(
            new Car(new CarName("car-0")), new Car(new CarName("car-1")), new Car(new CarName("car-2"))));

    @Test
    void 자동차_경주__각_차수별로_이동거리를_알_수_있다() {

        cars.move(forwardMoveCondition);

        CarMovementsResults carsMovementResults = cars.getCarsMovementResult();

        assertThat(carsMovementResults.getResult().split("\n"))
                .containsExactly("car-0 : -", "car-1 : -", "car-2 : -");

        cars.move(forwardMoveCondition);

        carsMovementResults = cars.getCarsMovementResult();

        assertThat(carsMovementResults.getResult().split("\n"))
                .containsExactly("car-0 : --", "car-1 : --", "car-2 : --");
    }

    @Test
    void 자동차_경주_게임을_완료한_후_누가_우승_했는지를_알려준다() {
        cars.move(new FirstCarMoveCondition());
        cars.move(new FirstCarMoveCondition());

        CarNames winners = cars.getWinners();

        assertThat(winners).isEqualTo(new CarNames(new CarName("car-0")));
    }

    @Test
    void 우승자가_한_명_이상일_경우_쉼표_로_이름을_구분해_출력한다() {
        cars.move(forwardMoveCondition);
        cars.move(forwardMoveCondition);

        CarNames winners = cars.getWinners();

        assertThat(winners).isEqualTo(new CarNames(new CarName("car-0"), new CarName("car-1"), new CarName("car-2")));
    }

    static class FirstCarMoveCondition implements MoveCondition {
        private int tryCount = 1;

        @Override
        public boolean doMove() {
            if (tryCount > 0) {
                tryCount -= 1;
                return true;
            }
            return false;
        }
    }

}
