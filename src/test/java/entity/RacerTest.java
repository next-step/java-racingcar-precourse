package entity;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacerTest {
    @Test
    @DisplayName("Racer 생성자 테스트")
    void racerConstructorTest() {
        // given: 생성자 데이터
        String givenName = "Racer   ";
        String expectedName = "Racer";
        BigInteger expectedMovedDistance = new BigInteger("0");

        // when
        Racer racer = new Racer(givenName);

        // then
        assertThat(racer.getName()).isEqualTo(expectedName);
        assertThat(racer.getMovedDistance()).isEqualTo(expectedMovedDistance);
    }

    @Test
    @DisplayName("Racer 생성자 실패 테스트")
    void racerConstructorWithInvalidDataTest() {
        // given: 생성자 데이터
        List<String> invalidNameList = Arrays.asList(null, "", "   ");

        for (String invalidName : invalidNameList) {
            // when
            ThrowableAssert.ThrowingCallable constructorCall = () -> new Racer(invalidName);

            // then
            assertThatThrownBy(constructorCall)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Racer.VALIDATE_NAME_ERROR_MESSAGE);
        }
    }

    @Test
    @DisplayName("Racer moveIfCan 전진 테스트")
    void racerMoveIfCan_WillMove() {
        // given: 전진하는 데이터
        BigInteger input = Racer.MOVE_THRESHOLD.add(new BigInteger("1"));
        Racer racer = new Racer("Tester");

        // when
        racer.moveIfCan(input);

        // then
        assertThat(racer.getMovedDistance()).isEqualTo(new BigInteger("1"));
    }

    @Test
    @DisplayName("Racer moveIfCan 정지 테스트")
    void racerMoveIfCan_WillStop() {
        // given: 전진하는 데이터와 전진하지 않는 데이터
        BigInteger input = Racer.MOVE_THRESHOLD;
        Racer racer = new Racer("Tester");

        // when
        racer.moveIfCan(input);

        // then
        assertThat(racer.getMovedDistance()).isEqualTo(new BigInteger("0"));
    }
}
