package racingcar;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @ParameterizedTest
    @DisplayName("자동차의 이름 설정 및 호출")
    @ValueSource(strings = {"kia,bmw,benz,audi"})
    void checkCarnameTest(String carNames) {
        String [] carArray = carNames.split(",");
        for (String carName : carArray) {
            assertThat(RacingCar.getNewInstance(carName).getName()).isEqualTo(carName);
        }
    }

    @ParameterizedTest
    @DisplayName("이동 회수 입력 및 개별 레이스테스트")
    @ValueSource(strings = {"kia,bmw,benz,audi"})
    void inputDistanceTest(String carNames) {
        int round = 3;
        String [] carArray = carNames.split(",");
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carArray) {
            racingCars.add(RacingCar.getNewInstance(carName));
        }
        for (int i = 0; i < round; i++) {
            racingCars.forEach(x->{x.start();});
        }
    }

    @ParameterizedTest
    @DisplayName("레이스단위로 테스트")
    @ValueSource(strings = {"kia,bmw,benz,audi"})
    void raceTest(String carNames) {
        int round = 3;
        String [] carArray = carNames.split(",");
        Race race = Race.getIntance(Arrays.asList(carArray), round);
        race.start();
    }
}