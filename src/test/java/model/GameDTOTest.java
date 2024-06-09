package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameDTOTest {
    @Test
    @DisplayName("GameDTO 생성 테스트")
    public void testCreateGameDTO() throws Exception {
        // given
        List<CarDTO> cars = Arrays.asList(new CarDTO("car1"), new CarDTO("car2"), new CarDTO("car3"));
        int iteration = 3;

        // when
        GameDTO gameDTO = new GameDTO(cars, iteration);

        // then
        assertThat(gameDTO.getIteration()).isEqualTo(iteration);
        assertThat(gameDTO.getCarNames()).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("자동차 movemnets 테스트")
    public void testCarMovements() throws Exception {
        // given
        List<CarDTO> cars = Arrays.asList(new CarDTO("car1"), new CarDTO("car2"), new CarDTO("car3"));
        int iteration = 3;
        GameDTO gameDTO = new GameDTO(cars, iteration);

        // when
        gameDTO.getCarsMovements();

        // then
        assertThat(gameDTO.getRecords()
                .get("car1")).isBetween(0, 3);
    }
}