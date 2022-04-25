package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.NextStepCar;
import racingcar.domain.cars.Cars;
import racingcar.domain.factory.NextStepCarFactory;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class RacingCarGameTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("RacingCarGame가 실행을 위한 필수 파라메터가 정상적으로 설정되지 않았을때 에러를 발생하는지 확인한다.")
    void 필수_입력_파라메터_셋팅_에러_테스트() {
        assertThatThrownBy(
                () -> {
                    Cars cars = new NextStepCarFactory().makeCar("car1, car2");
                    RacingCarGame racingCarGame = new RacingCarGame();
                    racingCarGame.play();
                }
        ).isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Cars가 설정되어야 합니다.");
    }

    @Test
    @DisplayName("RacingCarGame가 input으로 들어온 자동차를 정상적으로 저장하고 있는지 확인한다.")
    void CARS_객체_정상_생성_확인() {
        Cars cars = new NextStepCarFactory().makeCar("car1, car2");
        RacingCarGame racingCarGame = new RacingCarGame().setCars(cars);
        racingCarGame.cars.getCar(0);

        assertEquals("car1", racingCarGame.cars.getCar(0).getName(),"설정된 첫번째 자동차는 'car1'이여야 합니다.");
        assertEquals("car2", racingCarGame.cars.getCar(1).getName(),"설정된 첫번째 자동차는 'car2'이여야 합니다.");

        assertTrue(racingCarGame.cars.getCar(0) instanceof NextStepCar,"설정된 자동차는 NextStepCar 객체여야 합니다.");
        assertTrue(racingCarGame.cars.getCar(1) instanceof NextStepCar,"설정된 자동차는 NextStepCar 객체여야 합니다.");
    }

    @Test
    @DisplayName("RacingCarGame의 각 게임당 출력되는 포멧이 정상인지 확인한다.")
    void 게임_진행_정상_확인() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    Cars cars = new NextStepCarFactory().makeCar("car1, car2");
                    RacingCarGame racingCarGame = new RacingCarGame().setCars(cars);
                    racingCarGame.play();

                    String output = outputStreamCaptor.toString().replaceAll("\r\n","\n");
                    assertTrue(output.contains("car1 : -\ncar2 : "), "각 자동차당 게임 진행 출력 포멧이 비정상 입니다.");
                },
                8,new Integer[]{3}
        );
    }

    @Test
    @DisplayName("RacingCarGame의 게임 우승자 출력 포멧이 정상인지 확인한다.")
    void 우승자_정상_반환_확인() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    Cars cars = new NextStepCarFactory().makeCar("car1, car2");
                    RacingCarGame racingCarGame = new RacingCarGame().setCars(cars);
                    racingCarGame.play();
                    String winner = racingCarGame.findWinner();

                    assertEquals("car1", winner, "우승자 반환 값이 비정상 입니다.");
                },
                8,new Integer[]{3}
        );
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}