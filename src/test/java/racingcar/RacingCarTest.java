package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        this.racingCar = new RacingCar(Arrays.asList("felix", "pobi", "woni", "jun"));
    }



    @Test
    @DisplayName("쉼표를 기준으로 구분한 자동차 이름이 주어졌을 때 차 객체들을 올바르게 생성하는지 테스트한다.")
    void makeCarsTest() {
        racingCar.mapCar(Arrays.asList("felix", "pobi", "woni", "jun"));
        String[] names = new String[]{"felix", "pobi", "woni", "jun"};
        for (int i = 0; i < 4; i++) {
            assertThat(racingCar.getCars().get(i).getName()).isEqualTo(names[i]);
        }
    }

    @ParameterizedTest
    @CsvSource(value={"33333333:0", "44444444:8", "44440123:4", "01234567:4"}, delimiter = ':')
    @DisplayName("주어진 횟수만큼 자동차에게 행동할지를 결정하라고 메세지를 전달한다.")
    void repeatCarBahaviorTest(String numbersSource, String expectedPosition) {
        //TODO
    }



}
