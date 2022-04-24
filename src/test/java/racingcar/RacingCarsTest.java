package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class RacingCarsTest {
    public RacingCars racingCars;
    private static MockedStatic<RandomUtils> mRandomUtils;

    @BeforeEach
    public void set() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("hi"));
        cars.add(new RacingCar("hello"));
        cars.add(new RacingCar("hello"));
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

    @DisplayName("라운드를 진행할 때 랜덤값이 모두 4 이상이면, 각 자동차의 포지션은 증가해야한다.")
    @Test
    public void playRound_P01() {
        when(RandomUtils.getRandomNumber()).thenReturn(4);
        racingCars.playRound();
        assertThat(racingCars.cars).allMatch(racingCar ->
                racingCar.getGamePosition() == 1
        );
    }

    @DisplayName("라운드를 진행할 때 랜덤값이 모두 4 미만이면, 각 자동차의 포지션은 초기값이어야 한다.")
    @Test
    public void playRound_P02() {
        when(RandomUtils.getRandomNumber()).thenReturn(3);
        racingCars.playRound();
        assertThat(racingCars.cars).allMatch(racingCar ->
                racingCar.getGamePosition() == 0
        );
    }

    @DisplayName("게임 결과를 조회했을 때, 우승자가 한명일 경우 우승자 한명의 이름만 반환한다.")
    @Test
    public void getWinners_P01() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("hi", 3));
        cars.add(new RacingCar("hello", 2));
        cars.add(new RacingCar("hello1", 2));
        racingCars = new RacingCars(cars);
        assertThat(racingCars.getWinners()).isEqualTo("hi");
    }

    @DisplayName("게임 결과를 조회했을 때, 우승자가 두명일 경우 우승자 두명의 이름을 반환한다.")
    @Test
    public void getWinners_P02() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("hi", 3));
        cars.add(new RacingCar("hello", 3));
        cars.add(new RacingCar("hello1", 2));
        racingCars = new RacingCars(cars);
        assertThat(racingCars.getWinners()).isEqualTo("hi, hello");
    }
}
