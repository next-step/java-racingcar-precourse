package game.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarMoveCountTest {

    @Test
    void 자동차_경기_횟수_잘못된_입력(){
        assertThatThrownBy(() -> {
            CarMoveCount count = new CarMoveCount("numbers");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_경기_횟수_정상_입력(){
        CarMoveCount count = new CarMoveCount("123");
        assertThat(count.getCarMoveCount()).isEqualTo(123);

    }
}