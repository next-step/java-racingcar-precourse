package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.util.RandomNumberGenerator;

class CarsTest {
    @Test
    void 경주에_참여한_자동차들을_생성_할_수_있다() {
        assertThatCode(() -> new Cars(new CarNames("pobi, sun"))).doesNotThrowAnyException();
    }

    @Test
    void 경주에_참여한_자동차들은_전략에_따라_움직일_수_있다() {
        try (MockedStatic<RandomNumberGenerator> randomMock = mockStatic(RandomNumberGenerator.class)) {
            randomMock.when(() -> RandomNumberGenerator.getRandomNumber()).thenReturn(4);
            Cars cars = new Cars(new CarNames("pobi, sun"));
            cars.move(new RandomMovableStrategy());
            assertThat(cars.toString()).contains("pobi : -", "sun : -");
        }
    }

    @Test
    void 경주에_참여한_자동차들_중_최대_거리에_있는_우승자를_찾을_수_있다() {
        try (MockedStatic<RandomNumberGenerator> randomMock = mockStatic(RandomNumberGenerator.class)) {
            randomMock.when(() -> RandomNumberGenerator.getRandomNumber()).thenReturn(1, 4);
            Cars cars = new Cars(new CarNames("pobi, sun"));
            cars.move(new RandomMovableStrategy());
            assertThat(cars.findWinners().toString()).contains("sun");
        }
    }

    @Test
    void Cars_toString_호출_시_경주에_참여한_자동차의_이름과_하이픈으로_변환된_위치가_출력된다() {
        try (MockedStatic<RandomNumberGenerator> randomMock = mockStatic(RandomNumberGenerator.class)) {
            randomMock.when(() -> RandomNumberGenerator.getRandomNumber()).thenReturn(1, 4);
            Cars cars = new Cars(new CarNames("pobi, sun"));
            cars.move(new RandomMovableStrategy());
            assertThat(cars.toString()).contains("pobi :", "sun : -");
        }
    }
}