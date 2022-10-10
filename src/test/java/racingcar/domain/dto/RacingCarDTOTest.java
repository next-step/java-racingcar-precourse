package racingcar.domain.dto;

import org.junit.jupiter.api.Test;
import racingcar.domain.Location;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarDTOTest {

    @Test
    void DTO_출력테스트() {
        RacingCar car = new RacingCar(new RacingCarName("Yomni"), new Location(3));

        RacingCarDTO dto = new RacingCarDTO(car);

        String print = dto.toString();
        assertThat("Yomni : ---").isEqualTo(print);
    }
}
