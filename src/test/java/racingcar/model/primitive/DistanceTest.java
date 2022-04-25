package racingcar.model.primitive;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.primitive.Distance;

class DistanceTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "3,3"})
    @DisplayName("기본적인 Distance 인스턴스 생성 및 정상 값 적재 확인")
    void createDistanceAndValueTest(int input, int expected) {
        Distance distance = new Distance(input);
        assertThat(distance.getValue()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3","2, 4, 6"})
    @DisplayName("거리 값 증가 메서드 add 구현 테스트")
    void increaseDistanceWithAddMethod(int initial, int loopCnt, int expected) {
        Distance distance = new Distance(initial);
        for(int loop = 0; loop < loopCnt; loop++){
            distance.add();
        }
        assertThat(distance.getValue()).isEqualTo(expected);
    }
}