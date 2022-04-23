package racingcar.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @DisplayName("자동차 이름의 길이가 1~5이하 인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"", "람보르기니79"})
    void validateCarNameLength(String carName) {
        List<String> carNameList = Collections.singletonList(carName);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCars(carNameList))
                .withMessage("[ERROR] 자동차 이름은 길이 1~5 사이로 입력해주세요.");
    }

    @DisplayName("자동차 이름들에 중복이 없는지 검증")
    @Test
    void validateDuplication() {
        List<String> duplicationCarNameList = Arrays.asList("아폴로5호", "아폴로5호", "뉴카");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCars(duplicationCarNameList))
                .withMessage("[ERROR] 자동차 이름은 중복을 허용하지 않습니다.");
    }

    @DisplayName("자동차 이름에 매핑하는 RacingCar 객체로 변환하여 리스트로 가져오는지 확인")
    @Test
    void getRacingCarList() {
        List<String> carNameList = Arrays.asList("레드", "화이트", "그린");

        RacingCars racingCars = new RacingCars(carNameList);
        List<RacingCar> racingCarList = racingCars.getRacingCarList();

        assertEquals(carNameList.size(), racingCarList.size());
    }

}