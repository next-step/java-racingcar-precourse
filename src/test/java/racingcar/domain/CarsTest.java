package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.lineUpCars(Arrays.asList("이름1", "이름2", "이름3"));
    }

    @Test
    @DisplayName("초기화가 전달받은 이름들로 잘 됐는지 확인")
    void 초기화_테스트() {
        assertThat(cars.toString())
                .contains("이름1 :")
                .contains("이름2 :")
                .contains("이름3 :");
    }

    @Test
    @DisplayName("레이싱을 한 턴 실행했을 때, 값이 바뀌는지 확인")
    void 랜덤_인수가_적용되는지_확인() {
        final String previousRecord = cars.toString();
        cars.processRound();
        assertThat(cars.toString()).isNotEqualTo(previousRecord);
    }


}