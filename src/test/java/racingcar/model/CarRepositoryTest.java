package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarRepositoryTest {
    private static final int TEST_MOVING_FORWARD = 4;
    private static final int TEST_MOVING_STOP = 2;
    private CarRepository carCandidates = CarRepository.getInstance();
    @BeforeEach
    void getReadyCarCandidates() {
        carCandidates.clear();
    }

    @Test
    @DisplayName("일급 컬렉션 형태의 경주 참가 차 리스트 생성")
    void 일급컬렉션테스트() {
        int carNum = 10;
        for (int i = 0; i < carNum; i++)
            carCandidates.addCar(new Car("test_" + i));

        assertThat(carCandidates.getSize()).isEqualTo(carNum);
    }

    @Test
    @DisplayName("일급 컬렉션 형태의 경주 참가 차 리스트 생성")
    void 일급컬렉션테스트2() {
        int carNum = 3;
        for (int i = 0; i < carNum; i++)
            carCandidates.addCar(new Car("test_" + i));

        assertThat(carCandidates.getSize()).isEqualTo(carNum);
    }

    @RepeatedTest(100)
    @DisplayName("자동차 매 턴마다 전진하는 기능 테스트 수행")
    void 자동차움직이기테스트() {
        // given
        int carNum = 4;
        for (int i = 0; i < carNum; i++)
            carCandidates.addCar(new Car("test_" + i));

        // when && then
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(TEST_MOVING_FORWARD);

            carCandidates.startRound();
            carCandidates.startRound();
            assertThat(carCandidates.getMaxDistance()).isEqualTo(2);
        }

        // when && then
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(TEST_MOVING_STOP);

            carCandidates.startRound();
            carCandidates.startRound();
            assertThat(carCandidates.getMaxDistance()).isEqualTo(2);
        }

    }

    @Test
    @DisplayName("이터레이터 반환 메소드 테스트")
    void 이터레이터반환() {
        // given
        int carNum = 10;
        for (int i = 0; i < carNum; i++)
            carCandidates.addCar(new Car("test_" + i));

        // when
        Iterator<Car> carIt = carCandidates.asIterator();
        int res = 0;
        while(carIt.hasNext()) {
            res++;
            carIt.next();
        }

        // then
        assertThat(res).isEqualTo(carNum);
    }

}