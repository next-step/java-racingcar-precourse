package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Position;

public class PositionTest {

    @Test
    @DisplayName("Position 숫자 입력 테스트")
    void 포지션_숫자_생성_테스트() {
        //given
        int givenValue = 1;

        //when
        Position position = new Position(givenValue);

        //then
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("Position 증가 테스트")
    void 포지션_증가_테스트() {
        //given
        int givenValue = 1;

        //when
        Position position = new Position(givenValue);
        position.increase();

        //then
        assertThat(position).isEqualTo(new Position(2));

    }
}
