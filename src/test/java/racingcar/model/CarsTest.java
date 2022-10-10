package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
    @Test
    void 자동차_2대_생성() {
        String[] carNames = "국내차,외제차".split(",");

        Cars cars = new Cars(carNames);

        assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    void 자동차_이름_없음() {
        String[] carNames = "".split(",");

        assertThatThrownBy(() -> {
            Cars cars = new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 자동차_이름_중복_에러() {
        String[] carNames = "국내차,국내차".split(",");

        assertThatThrownBy(() -> {
            Cars cars = new Cars(carNames);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 실행결과중_가장_큰_move_도출() {
        String[] carNames = "국내차,외제차,소형차,대형차,중형차".split(",");
        int[] moves = new int[]{1, 2, 2, 2, 1};
        Cars cars = new Cars();

        for (int i = 0; i < carNames.length; i++) {
            cars.addCar(new Car(new Name(carNames[i]), new Move(moves[i])));
        }

        Move highestMove = cars.highestMove();

        assertThat(highestMove.moveCount()).isEqualTo(2);
    }

    @Test
    void 자동차_전체_이름_문자열_출력() {
        String[] carNames = "국내차,외제차".split(",");
        Cars cars = new Cars(carNames);

        String carNamesSplitByComma = cars.totalCarNames();

        assertThat(carNamesSplitByComma).contains("국내차, 외제차");
    }

    @Test
    void 자동차_이름_문자열_출력() {
        String[] carNames = "국내차".split(",");
        Cars cars = new Cars(carNames);

        String carNamesSplitByComma = cars.totalCarNames();

        assertThat(carNamesSplitByComma).contains("국내차");
    }
}
