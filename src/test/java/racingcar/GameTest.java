package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Game;
import racingcar.model.RandomMovement;

class GameTest {

    Game game = new Game();

    @Test
    void 정상적인_데이터가_들어오는_경우_게임_객체가_생성된다() {
        // given & when
        game.init(Arrays.asList("pobi", "jason"), 5);

        // then
        assertThat(game.getCars()).isNotNull();
    }

    @Test
    void 자동차_이름이_5글자_초과인_경우_게임_객체가_생성되지_않는다() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> game.init(Arrays.asList("pobi", "jason2"), 5));
    }

    @Test
    void 경주_횟수가_0인_경우_게임_객체가_생성되지_않는다() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> game.init(Arrays.asList("pobi", "jason"), 0));
    }

    @Test
    void 자동차_이름이_5글자를_초과하고_경주_횟수가_음수인_경우_게임_객체가_생성되지_않는다() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> game.init(Arrays.asList("pobi", "jason2"), -4));
    }

    @Test
    public void 레이스_횟수만큼_게임이_진행된_후_상태값은_True이다() {
        // given
        List<String> cars = Arrays.asList("pobi", "jason");
        int count = 5;
        Game game = new Game();

        // when
        game.init(cars, count);
        for (int i = 0; i < count; i++) {
            game.playGame(new RandomMovement());
        }

        // then
        assertThat(game.isFinished()).isTrue();
    }

    @Test
    public void 레이스_결과로_우승자를_반환한다() {
        // given
        List<String> cars = Arrays.asList("pobi", "jason", "mins");
        int count = 5;
        Game game = new Game();

        // when
        game.init(cars, count);
        for (int i = 0; i < count; i++) {
            game.playGame(new RandomMovement());
        }

        // then
        assertThat(game.result().size()).isGreaterThan(0);
    }
}