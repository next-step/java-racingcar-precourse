package domainTest;

import racinggame.domain.Cars;
import racinggame.domain.Racing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private Cars cars;

    @ParameterizedTest
    @DisplayName("Random값이 4인 게임 시도 횟수가 5개일 경우 모든 자동차의 moveCount = 5 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    public void attemptCountFiveRandomNumberFour(int index) {
        cars = new Cars("lee,kim,park,hye") {
            @Override
            protected int getRandomNumber() {
                return 4;
            }
        };

        Racing racing = new Racing(cars, 5);
        racing.start();

        Cars carsResult = racing.carsResult();
        int resultCount = carsResult.getCar(index).getMoveCount();

        assertThat(resultCount).isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("Random값이 3인 게임 시도 횟수가 5개일 경우 모든 자동차의 moveCount = 0 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    public void attemptCountFiveRandomNumberThree(int index) {
        cars = new Cars("lee,kim,park,hye") {
            @Override
            protected int getRandomNumber() {
                return 3;
            }
        };

        Racing racing = new Racing(cars, 5);

        racing.start();

        Cars carsResult = racing.carsResult();
        int resultCount = carsResult.getCar(index).getMoveCount();

        assertThat(resultCount).isEqualTo(0);
    }

}
