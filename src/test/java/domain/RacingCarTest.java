package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        List<String> names = List.of("pobi");
        racingCar = RacingCar.create(RacingCarCommand.Create.from(names)).get(0);
    }

    @Test
    @DisplayName("copy 메서드 테스트")
    void copyTest() {
        // given
        RacingCar copiedRacingCar = racingCar.copy();

        // when
        racingCar.move();

        // then
        assertThat(racingCar).isNotSameAs(copiedRacingCar);
    }


}
