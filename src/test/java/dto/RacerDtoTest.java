package dto;

import entity.Racer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacerDtoTest {
    @Test
    @DisplayName("RacerDto of 메소드 테스트")
    void ofTest() {
        // given
        Racer givenRacer = new Racer("Tester");
        boolean givenIsWinner = givenRacer.isWinner(givenRacer.getMovedDistance());

        // when
        RacerDto racerDto = RacerDto.of(givenRacer);

        assertThat(racerDto.name()).isEqualTo(givenRacer.getName());
        assertThat(racerDto.movedDistance()).isEqualTo(givenRacer.getMovedDistance());
        assertThat(racerDto.isWinner()).isEqualTo(givenIsWinner);
    }
}
