package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.exception.RacinggameException;

@DisplayName("CarList Model 테스트")
class CarListTest {
    private CarList test;

    @BeforeEach
    void setUp() {
        test = new CarList.Builder()
                .carList(Arrays.asList("car1", "car2", "car3"))
                .build();
    }

    @ParameterizedTest(name = "생성한 CarList에 carName이 {1}인 Car가 정상적으로 생성되었는지 확인")
    @CsvSource(value = {"0:car1", "1:car2", "2:car3"}, delimiter = ':')
    void createCarList(int index, String carName) {
        // then
        assertAll(
                () -> assertThat(test).isNotNull(),
                () -> assertThat(test).isInstanceOf(CarList.class),
                () -> assertThat(test.getCarList().size()).isEqualTo(3),
                () -> assertThat(test.getCarList().get(index).getCarNameStr()).isEqualTo(carName)
        );
    }

    @Test
    @DisplayName("5글자 이하가 아닌 CarName을 입력할 경우 기대한 예외가 발생하는지 확인")
    void checkCarNameLength() {
        // then
        assertThatThrownBy(() -> new CarList.Builder().carList(Arrays.asList("car1", "car2", "exception")).build())
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] Check the length of the car name");
    }

    @Test
    @DisplayName("CarList 사이즈가 2 이상이 아닐 경우 기대한 예외가 발생하는지 확인")
    void checkCarListSize() {
        // then
        assertThatThrownBy(() -> new CarList.Builder().carList(Collections.singletonList("car1")).build())
                .isInstanceOf(RacinggameException.class)
                .hasMessageContaining("[ERROR] Please check the number of cars for the racing game");
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
                () -> assertThat(test.getCarList()).isNotNull(),
                () -> assertThat(test.getCarList().get(0).getCarPositionInt()).isEqualTo(expectPosition)
        );
    }
}
