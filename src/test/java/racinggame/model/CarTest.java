package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.exception.RacinggameException;

@DisplayName("Car Model 테스트")
class CarTest {
    private Car test;

    @BeforeEach
    void setUp() {
        test = new Car.Builder()
                .name("test")
                .position()
                .build();
    }

    @Test
    @DisplayName("Car 생성 확인")
    void createCar() {
        // then
        assertAll(
                () -> assertThat(test).isNotNull(),
                () -> assertThat(test).isInstanceOf(Car.class),
                () -> assertThat(test.getCarName()).isInstanceOf(CarName.class),
                () -> assertThat(test.getCarNameStr()).isEqualTo("test"),
                () -> assertThat(test.getCarPosition()).isInstanceOf(CarPosition.class),
                () -> assertThat(test.getCarPositionInt()).isZero()
        );
    }

    @Test
    @DisplayName("CarName이 null일 경우 기대한 예외가 발생하는지 확인")
    void checkCarNameNull() {
        // then
        assertThatThrownBy(() -> new Car.Builder().name(null).position().build())
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] The car name cannot be null");
    }

    @Test
    @DisplayName("5글자 이하가 아닌 CarName을 입력할 경우 기대한 예외가 발생하는지 확인")
    void checkCarNameLength() {
        // then
        assertThatThrownBy(() -> new Car.Builder().name("exception").position().build())
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] Check the length of the car name");
    }

    @Test
    @DisplayName("입력된 수가 4 이상일 때 CarPosition이 정상적으로 변경되는지 확인")
    void checkCarPositionForward() {
        // given // when
        test.judgeForward(4);

        // then
        assertAll(
                () -> assertThat(test.getCarPosition()).isInstanceOf(CarPosition.class),
                () -> assertThat(test.getCarPositionInt()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("입력된 수가 3 이하일 때 CarPosition이 변경되지 않는지 확인")
    void checkCarPositionStop() {
        // given // when
        test.judgeForward(1);

        // then
        assertAll(
                () -> assertThat(test.getCarPosition()).isInstanceOf(CarPosition.class),
                () -> assertThat(test.getCarPositionInt()).isZero()
        );
    }

    @ParameterizedTest(name = "임의로 생성된 수 {0}에 따라 CarPosition이 {1}로 정상적으로 증가하는지 확인")
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void checkCarPosition(int randomNumber, int expectPosition) {
        // given
        MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);

        // when
        mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomNumber);
        test.forward();
        mockRandoms.close();

        // then
        assertAll(
                () -> assertThat(test).isNotNull(),
                () -> assertThat(test.getCarPositionInt()).isEqualTo(expectPosition)
        );
    }

}
