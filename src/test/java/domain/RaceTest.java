package domain;

import dto.CarDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RaceTest {

    @Test
    @DisplayName("경기의 결과 정보가 알맞은 우승자를 반환하는지 테스트")
    public void findWinners_ShouldReturn_MaxDistanceCars() {
        //given
        Distance winnerDistance = new Distance(4);
        Cars cars = new Cars(Arrays.asList(
                new Car("꼴등차", new Distance(0)),
                new Car("4등차", new Distance(2)),
                new Car("1등차", winnerDistance),
                new Car("1등차", winnerDistance),
                new Car("2등차", new Distance(3)),
                new Car("3등차", new Distance(1))));

        Race race = new Race(cars);
        RaceReport raceReport = race.createReport();
        //when
        List<CarDto> winners = raceReport.findWinners();
        //then
        assertAll(
            () -> assertThat(winners).hasSize(2),
            () -> assertThat(winners.get(0).getLocation()).isEqualTo(winnerDistance),
            () -> assertThat(winners.get(1).getLocation()).isEqualTo(winnerDistance)
        );
    }
}
