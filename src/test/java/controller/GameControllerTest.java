package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import domain.RacingCars;
import domain.RacingCount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class GameControllerTest {
    private final String names = "toby,tom,jack";
    private final int count = 4;
    private MockedStatic<Randoms> mock;
    private RacingCars racingCars;
    private GameController controller;

    @BeforeEach
    public void beforeEach() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 4, 0, 5, 5, 1, 6, 6, 2, 7, 7, 4);
        mock.clearInvocations();

        racingCars = new RacingCars(RacingCars.makeCarListFromNames(names));
        controller = new GameController(racingCars, new RacingCount(count));
    }

    @Test
    @DisplayName("주행_테스트")
    public void 주행_테스트() {
        controller.startRacing();
        assertThat(controller.findRacingCar("toby").getPosition()).isEqualTo(4);
        assertThat(controller.findRacingCar("tom").getPosition()).isEqualTo(4);
        assertThat(controller.findRacingCar("jack").getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("최고_주행_거리_테스트")
    public void 최고_주행_거리_테스트() {
        controller.startRacing();
        assertThat(controller.findWinnersPosition()).isEqualTo(4);
    }

    @Test
    @DisplayName("우승자_리스트_테스트")
    public void 우승자_리스트_테스트() {
        controller.startRacing();
        List<Car> winners = controller.findWinners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getCarName()).isEqualTo("toby");
        assertThat(winners.get(1).getCarName()).isEqualTo("tom");
    }

    @AfterEach
    public void afterEach() {
        mock.close();
    }

}
