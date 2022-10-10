package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveTest {

    @Test
    void 전진_테스트() {
        //given
        Move move = new Move();

        //when
        move.goDistance();

        //then
        assertThat(move.getDistance()).isEqualTo(1);
    }

    @Test
    void 연속_전진_테스트() {
        //given
        Move move = new Move();

        //when
        move.goDistance();
        move.goDistance();

        //then
        assertThat(move.getDistance()).isEqualTo(2);
    }
}