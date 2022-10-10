package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameResultTest {
    private Cars cars;
    private Progress progress;

    @BeforeEach
    void setUp() {
        String[] carNames = new String[]{"test", "test2"};
        cars = new Cars(carNames);
        progress = new Progress(3);
    }

    @Test
    void 매_차수_마다_자동차_진행한_값과_동일한지_비교() {
        for (int i = 0; i < progress.getCount(); i++) {
            cars.move();
            GameResult gameResult = new GameResult(cars);

            assertThat(gameResult.geResult()).usingRecursiveComparison().isEqualTo(cars);
        }
    }

    @Test
    void 공동_우승자() {
        String[] carNames = "국내차,외제차,소형차,대형차,중형차".split(",");
        int[] moves = new int[]{3, 2, 2, 3, 2};
        Cars cars = new Cars();

        for (int i = 0; i < carNames.length; i++) {
            cars.addCar(new Car(new Name(carNames[i]), new Move(moves[i])));
        }

        GameResult gameResult = new GameResult(cars);
        Cars winners = gameResult.winners();

        Cars cars1 = new Cars();
        cars1.addCar(cars.getCar(0));
        cars1.addCar(cars.getCar(3));

        assertThat(winners).usingRecursiveComparison().isEqualTo(cars1);
    }

    @Test
    void 단일_우승자() {
        String[] carNames = "국내차,외제차,소형차,대형차,중형차".split(",");
        int[] moves = new int[]{1, 2, 2, 3, 2};
        Cars cars = new Cars();

        for (int i = 0; i < carNames.length; i++) {
            cars.addCar(new Car(new Name(carNames[i]), new Move(moves[i])));
        }

        GameResult gameResult = new GameResult(cars);
        Cars winners = gameResult.winners();

        Cars cars1 = new Cars();
        cars1.addCar(cars.getCar(3));

        assertThat(winners).usingRecursiveComparison().isEqualTo(cars1);
    }
}
