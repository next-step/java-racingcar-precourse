package dto;

import entity.Racer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.*;

class RacerDtoTest {
    @Test
    @DisplayName("RacerDto of 메소드 테스트")
    void ofTest() {
        // given
        Racer givenRacer = new Racer("Tester");
        BigInteger givenInput = givenRacer.getMovedDistance();;

        // when
        RacerDto racerDto = RacerDto.of(givenRacer, givenInput);

        // then
        assertThat(racerDto.name()).isEqualTo(givenRacer.getName());
        assertThat(racerDto.movedDistance()).isEqualTo(givenRacer.getMovedDistance());
        assertThat(racerDto.isWinner()).isEqualTo(givenRacer.isWinner(givenInput));
    }
}
