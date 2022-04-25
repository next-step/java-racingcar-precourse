package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.response.CarRaceResult;
import racingcar.domain.response.CarRaceResults;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : choi-ys
 * @date : 2022-04-24 오후 9:15
 */
@DisplayName("Domain:CarRaceResults")
class CarRaceResultsTest {

    @Test
    @DisplayName("한 라운드 진행 결과 객체 생성 Test")
    public void createCarRaceResultsTest() {
        // Given
        Car firstCar = new Car("람보르기니");
        Car secondCar = new Car("람보르기니");
        Car thirdCar = new Car("람보르기니");

        CarRaceResult firstCarResult = new CarRaceResult(firstCar, RoundStatus.GO);
        CarRaceResult secondCarResult = new CarRaceResult(secondCar, RoundStatus.GO);
        CarRaceResult thirdCarResult = new CarRaceResult(thirdCar, RoundStatus.STOP);

        // When
        CarRaceResults carRaceResults = new CarRaceResults(Arrays.asList(firstCarResult, secondCarResult, thirdCarResult));

        // Then
        assertThat(carRaceResults.getCarRaceResults()).size().isEqualTo(3);
        assertThat(carRaceResults.getCarRaceResults().get(0).getRoundStatus().isGo()).isTrue();
        assertThat(carRaceResults.getCarRaceResults().get(1).getRoundStatus().isGo()).isTrue();
        assertThat(carRaceResults.getCarRaceResults().get(2).getRoundStatus().isStop()).isTrue();
    }
}