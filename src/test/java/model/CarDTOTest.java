package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarDTOTest {

    @Test
    @DisplayName("CarDTO 이름 getter 테스트")
    public void testGetName() throws Exception {
        // given
        CarDTO carDTO = new CarDTO("Hyundai");
        String expectedName = "Hyundai";

        // when
        String carDTOName = carDTO.getName();

        // then
        assertThat(carDTOName)
                .isEqualTo(expectedName);
    }

    @Test
    @DisplayName("랜덤 넘버 생성 범위 테스트")
    public void testRandomNumberGenerating() throws Exception {
        // given
        CarDTO carDTO = new CarDTO("carName");

        // when
        int randomNumber = carDTO.getRandomNumber();

        // then
        assertThat(randomNumber).isBetween(0, 9);
    }

}