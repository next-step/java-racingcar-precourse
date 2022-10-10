package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private List<RacingCar> racingCarList;
    private RacingCars racingCars;
    private String carNames;

    @BeforeEach
    void setUp(){
        carNames = "pobi,woni";
    }

    @ParameterizedTest
    @DisplayName("검증된 입력값으로 List<RacingCar> 생성 테스트")
    @CsvSource(value = {"0:pobi:0", "1:woni:0"}, delimiter = ':')
    void makeRacingCarListTest(int idx, String carName, int carPosition){
        racingCars = new RacingCars(ValidationUtils.makeSplitedArray(carNames));
        racingCarList = racingCars.getRacingCarList();
        assertThat(racingCarList.get(idx).getRacingCarName()).isEqualTo(carName);
        assertThat(racingCarList.get(idx).getRacingCarPosition()).isEqualTo(carPosition);
    }

}
