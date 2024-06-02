import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        String[] carNames = {"a", "b", "c"};
        // 유효한 자동차 이름(영문자만,공백x,중복x) 사용, car1,car2,car3 같은 경우, 동작x
        race = new Race(carNames);
    }

    //자동차가 1칸 잘 이동했는지 test
    @Test
    void testMoveCars() {
        race.moveCars(new PredictableRandom());

        Car[] cars = race.getCars();
        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
    //공동 우승자 발생의 경우 test
    @Test
    void testFindWinnersWithSingleWinner() {
        Car[] cars = race.getCars();
        cars[0].move(4); // a자동차 이동 1회
        cars[1].move(3); // b자동차 이동 0회
        cars[2].move(4); // c자동차 이동 1회

        String winners = race.findWinners();
        assertThat(winners).isEqualTo("a, c");
    }

    private static class PredictableRandom extends Random {

    }
    //단독 우승자 발생 경우 test
    @Test
    void testFindWinnersWithMultipleWinners() {
        Car[] cars = race.getCars();
        cars[0].move(4); // a자동차 이동 1회
        cars[0].move(4); // a자동차 이동 2회
        cars[1].move(4); // b자동차 이동 1회
        cars[2].move(4); // c자동차 이동 1회

        String winners = race.findWinners();
        assertThat(winners).isEqualTo("a");
    }
}
