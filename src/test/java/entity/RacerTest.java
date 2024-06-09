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
        String name = "Racer";
        BigInteger expectedMovedDistance = new BigInteger("0");

        // when
        Racer racer = new Racer(name);

        // then
        assertThat(racer.getName()).isEqualTo(name);
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
}
