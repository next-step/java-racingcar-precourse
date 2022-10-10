package racingcar.domain.dto;

import org.junit.jupiter.api.Test;
import racingcar.domain.Location;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarDTOListTest {

    @Test
    void Dto_List_출력_테스트() {
        RacingCar pobi = new RacingCar(new RacingCarName("pobi"), new Location(5));
        RacingCar crong = new RacingCar(new RacingCarName("crong"), new Location(4));
        RacingCar honux = new RacingCar(new RacingCarName("honux"), new Location(5));

        List<RacingCarDTO> list = new ArrayList<>();
        list.add(new RacingCarDTO(pobi));
        list.add(new RacingCarDTO(crong));
        list.add(new RacingCarDTO(honux));

        RacingCarDTOList carListDTO = new RacingCarDTOList(list);
        assertThat(carListDTO.toString()).isEqualTo("pobi : -----\n" +
                "crong : ----\n" +
                "honux : -----\n");
    }
}
