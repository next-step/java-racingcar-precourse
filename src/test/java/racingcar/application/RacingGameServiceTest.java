package racingcar.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameServiceTest {

    private RacingGameService racingGameService = new RacingGameService();

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름 목록으로 경주할 자동차들을 생성한다.")
    void test_createCars() {
        //given
        String carsNameString = "하나,둘,셋";

        //when
        Cars cars = racingGameService.createCars(carsNameString);
        List<Car> carList = cars.getCars();

        //then
        assertAll(
                () -> assertThat(carList.get(0).getName().getCarName()).isEqualTo("하나"),
                () -> assertThat(carList.get(0).getPosition().getIntPosition()).isEqualTo(0),
                () -> assertThat(carList.get(1).getName().getCarName()).isEqualTo("둘"),
                () -> assertThat(carList.get(1).getPosition().getIntPosition()).isEqualTo(0),
                () -> assertThat(carList.get(2).getName().getCarName()).isEqualTo("셋"),
                () -> assertThat(carList.get(2).getPosition().getIntPosition()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("사용자가 입력한 회수만큼 게임 라운드를 진행한다.")
    void test_playRoundCount() {
        //given
        String carsNameString = "하나,둘,셋";
        String roundNumberAnswer = "3";

        //when
        GameResult gameResult = racingGameService.startGame(racingGameService.createCars(carsNameString), roundNumberAnswer);

        //then
        assertThat(gameResult.getGameRoundResults().getGameRoundResults()).hasSize(3);
    }
}
