package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.model.RandomMovement;

class RandomMovementTest {

    @RepeatedTest(10)
    public void 랜덤_값은_0에서_9사이의_숫자를_리턴한다() {
        // given
        RandomMovement randomMovement = new RandomMovement();

        // when
        int result = randomMovement.moving();

        // then
        assertThat(result).isBetween(0, 9);
    }

}