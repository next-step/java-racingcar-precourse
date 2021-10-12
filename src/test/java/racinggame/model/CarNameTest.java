package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.RacinggameException;

@DisplayName("CarName Model 테스트")
class CarNameTest {

    @Test
    @DisplayName("CarName 생성 확인")
    void createCarName() {
        // given // when
        CarName createTest = new CarName.Builder()
                .name("test")
                .build();

        // then
        assertAll(
                () -> assertThat(createTest).isNotNull(),
                () -> assertThat(createTest).isInstanceOf(CarName.class),
                () -> assertThat(createTest.getCarName()).isEqualTo("test")
        );
    }

    @Test
    @DisplayName("CarName이 null일 경우 기대한 예외가 발생하는지 확인")
    void checkCarNameNull() {
        // then
        assertThatThrownBy(() -> new CarName.Builder().name(null).build())
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] The car name cannot be null");
    }

    @Test
    @DisplayName("5글자 이하가 아닌 CarName을 입력할 경우 기대한 예외가 발생하는지 확인")
    void checkCarNameLength() {
        // then
        assertThatThrownBy(() -> new CarName.Builder().name("exception").build())
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] Check the length of the car name");
    }
}
