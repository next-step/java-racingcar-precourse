package entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.*;
class RacerTest {
    @Test
    @DisplayName("Racer 생성자 테스트")
    void racerConstructorTest() {
        // given: 생성자 데이터
        String name = "Racer";
        BigInteger expectedMovedDistance = new BigInteger("0");

        // when
        Racer racer = new Racer(name);

        // then
        assertThat(racer.getName()).isEqualTo(name);
        assertThat(racer.getMovedDistance()).isEqualTo(expectedMovedDistance);
    }
}
