package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import racingcar.model.CarMoveRule;

public class RacingCarsTest {
    RacingCars racingCars;
    CarMoveRule carMoveRule;
    private static MockedStatic<RandomUtils> mRandomUtils;

    @BeforeEach
    public void set() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        carMoveRule = new CarMoveRule(1, 0, 4, "-");
        cars.add(new RacingCar("hi", carMoveRule));
        cars.add(new RacingCar("hello", carMoveRule));
        cars.add(new RacingCar("hello", carMoveRule));
        racingCars = new RacingCars(cars);
        mRandomUtils = mockStatic(RandomUtils.class);
    }

    @AfterEach
    public void afterClass() {
        mRandomUtils.close();
    }

    @DisplayName("자동차 리스트 생성 테스트")
    @Test
    public void createRacingCarsSuccess_P01() {
        assertThat(racingCars).isNotNull();
    }

    @DisplayName("경주게임_자동차_이름_검증_통과")
    @ParameterizedTest
    @CsvSource(value = {"하이브리드,번개", "하이브리드,번개,번개3"}, delimiter = ':')
    void validCarNamesReturnTrue_P01(String inputName) {
        RacingCars dummyCars = new RacingCars(inputName, carMoveRule);
        assertThat(dummyCars).isNotNull();
    }

    @DisplayName("경주게임_자동차_이름_검증_실패")
    @ParameterizedTest
    @CsvSource(value = {"하이브리드1,하이브리드", "하이브리드,번개44444444,번개3", "hi,,hihi"}, delimiter = ':')
    void validCarNamesThrowException_N01(String inputName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCars(inputName, carMoveRule));
    }

    @DisplayName("라운드를 진행할 때 랜덤값이 모두 4 이상이면, 각 자동차의 포지션은 증가해야한다.")
    @Test
    public void playRound_P01() {
        when(RandomUtils.getRandomNumber()).thenReturn(4);
        racingCars.playRound();
        assertThat(racingCars.cars).allMatch(racingCar ->
                racingCar.getGamePosition().getPosition() == 1
        );
    }

    @DisplayName("라운드를 진행할 때 랜덤값이 모두 4 미만이면, 각 자동차의 포지션은 초기값이어야 한다.")
    @Test
    public void playRound_P02() {
        when(RandomUtils.getRandomNumber()).thenReturn(3);
        racingCars.playRound();
        assertThat(racingCars.cars).allMatch(racingCar ->
                racingCar.getGamePosition().getPosition() == 0
        );
    }

    @DisplayName("게임 결과를 조회했을 때, 우승자가 한명일 경우 우승자 한명의 이름만 반환한다.")
    @Test
    public void getWinners_P01() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("hi", 3, carMoveRule));
        cars.add(new RacingCar("hello", 2, carMoveRule));
        cars.add(new RacingCar("hell2", 2, carMoveRule));
        racingCars = new RacingCars(cars);
        racingCars.setWinners();
        assertThat(racingCars.getWinnerOutPutResult().getPrintWinners()).isEqualTo("hi");
    }

    @DisplayName("게임 결과를 조회했을 때, 우승자가 두명일 경우 우승자 두명의 이름을 반환한다.")
    @Test
    public void getWinners_P02() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("hi", 3, carMoveRule));
        cars.add(new RacingCar("hello", 3, carMoveRule));
        cars.add(new RacingCar("hell2", 2, carMoveRule));
        racingCars = new RacingCars(cars);
        racingCars.setWinners();
        assertThat(racingCars.getWinnerOutPutResult().getPrintWinners()).isEqualTo("hi, hello");
    }

    @DisplayName("게임 현재상태를 조회했을 때, 기대한 값과 같아야 한다.")
    @Test
    public void getCurrentResult_P01() {
        String expected = "hi : ---\nhello : ---\n";
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("hi", 3, carMoveRule));
        cars.add(new RacingCar("hello", 3, carMoveRule));
        racingCars = new RacingCars(cars);
        assertThat(racingCars.getCurrentResult().getResult()).isEqualTo(expected);
    }
}
