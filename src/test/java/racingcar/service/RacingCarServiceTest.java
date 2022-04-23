package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarNamesInput;
import racingcar.domain.Cars;
import racingcar.domain.IndexNumber;
import racingcar.domain.Winners;

class RacingCarServiceTest {
    private static final String TEST_VALUE_NORMAL = "mars,earth,moon,pluto";
    private static final String TEST_VALUE_EMPTY_ONE = "mars,earth, ,pluto";

    private static final String TEST_RESULT_NAME = "earth";
    private static final int TEST_RESULT_NAME_INDEX = 1;
    private static final int TEST_RESULT_SIZE = 4;

    private static final int MOVING_FORWARD_NUMBER = 4;
    private static final int STOP_NUMBER = 0;

    @Test
    void 자동차명_입력시_빈값_존재() {
        CarNamesInput input = new CarNamesInput(TEST_VALUE_EMPTY_ONE);
        RacingCarService service = new RacingCarService();

        assertThatThrownBy(() -> service.initService(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차명_정상_입력값_입력시() {
        CarNamesInput input = new CarNamesInput(TEST_VALUE_NORMAL);
        RacingCarService service = new RacingCarService();

        service.initService(input);
        Cars cars = service.playRace();
        Car targetCar = cars.get(new IndexNumber(TEST_RESULT_NAME_INDEX));

        assertThat(cars.size()).isEqualTo(TEST_RESULT_SIZE);
        assertThat(targetCar.getCarName().getName()).isEqualTo(TEST_RESULT_NAME);
    }

    @Test
    void 레이스_1회_동작후_결과확인() {

        assertRandomNumberInRangeTest(
                () -> {
                    CarNamesInput input = new CarNamesInput(TEST_VALUE_NORMAL);
                    RacingCarService service = new RacingCarService();

                    service.initService(input);
                    Cars cars = service.playRace();

                    assertThat(cars.get(new IndexNumber(0)).getCarPosition().getPosition()).isEqualTo(0);
                    assertThat(cars.get(new IndexNumber(1)).getCarPosition().getPosition()).isEqualTo(1);
                    assertThat(cars.get(new IndexNumber(2)).getCarPosition().getPosition()).isEqualTo(0);
                    assertThat(cars.get(new IndexNumber(3)).getCarPosition().getPosition()).isEqualTo(1);
                },
                STOP_NUMBER, MOVING_FORWARD_NUMBER, STOP_NUMBER, MOVING_FORWARD_NUMBER
        );
    }

    @Test
    void 레이스_2회_동작후_우승자_확인() {

        assertRandomNumberInRangeTest(
                () -> {
                    CarNamesInput input = new CarNamesInput(TEST_VALUE_NORMAL);
                    RacingCarService service = new RacingCarService();

                    service.initService(input);
                    service.playRace();
                    service.playRace();
                    Winners winners = service.getWinners();

                    assertThat(winners.size()).isEqualTo(2);
                    assertThat(winners.get(new IndexNumber(0)).getName()).isEqualTo("earth");
                    assertThat(winners.get(new IndexNumber(1)).getName()).isEqualTo("pluto");
                },
                STOP_NUMBER, MOVING_FORWARD_NUMBER, STOP_NUMBER, MOVING_FORWARD_NUMBER, STOP_NUMBER,
                MOVING_FORWARD_NUMBER, STOP_NUMBER, MOVING_FORWARD_NUMBER
        );
    }

}