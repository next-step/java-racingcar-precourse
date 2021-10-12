package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class CarsTest {

    @DisplayName("자동차 여러 건 생성 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1", "1,2,3"})
    void constructCars_success(String carsStr) {
        assertThat(new Cars(carsStr).getSize()).isEqualTo(carsStr.split(",").length);
    }

    @DisplayName("자동차들 이동 후 우승자 제대로 불러오는지 확인")
    @Test
    void moveForwardOrStopAndFindWinners_success() {
        try (final MockedStatic<MoveStatus> mockMoveStatus = mockStatic(MoveStatus.class)) {
            mockMoveStatus.when(MoveStatus::createRandom)
                .thenReturn(MoveStatus.FORWARD, MoveStatus.FORWARD, MoveStatus.STOP);
            Cars cars = new Cars("1,2,3");

            cars.moveForwardOrStop();

            assertThat(cars.findWinners()).isEqualTo(new Winners(Arrays.asList(new Name("1"), new Name("2"))));
        }
    }

    @DisplayName("자동차 레이싱 실행 결과 메시지 제대로 생성하는지 테스트")
    @Test
    void makeResultMessage_success() {
        Cars cars = new Cars("1,2,3");

        cars.moveForwardOrStop(0, MoveStatus.FORWARD);
        cars.moveForwardOrStop(1, MoveStatus.FORWARD);
        cars.moveForwardOrStop(2, MoveStatus.STOP);

        assertThat(cars.makeResultMessage()).isEqualTo(new Message("1 : -\n2 : -\n3 : \n"));
    }

}
