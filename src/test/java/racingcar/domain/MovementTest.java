package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MovementTest {

    @Test
    void 이동_객체_생성_테스트(){
        Movement movement = new Movement();
        assertThat(movement).isNotNull();
    }

    @Test
    void 이동_테스트(){
        Movement movement = new Movement();
        movement.moving();
        assertThat(movement.getDistance()).isEqualTo(1);
    }

}
