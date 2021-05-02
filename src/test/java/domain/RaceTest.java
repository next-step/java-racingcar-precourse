package domain;

import dto.CarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RaceReportFormatUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RaceTest {
    private final Distance winnerDistance = new Distance(4);
    private Cars cars;
    private Race race;

    @BeforeEach
    public void setUp() {
        //given
         cars = new Cars(Arrays.asList(
                new Car("꼴등차", new Distance(0)),
                new Car("3등차", new Distance(2)),
                new Car("1등차", winnerDistance),
                new Car("1등차", winnerDistance),
                new Car("2등차", new Distance(3)),
                new Car("4등차", new Distance(1))));

         race = new Race(cars);
    }

    @Test
    @DisplayName("경기의 결과 정보가 알맞은 우승자를 반환하는지 테스트")
    public void findWinners_ShouldReturn_MaxDistanceCars() {
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

    @Test
    public void testFormatReport() {
        RaceReport raceReport = race.createReport();
        String reportOutput = RaceReportFormatUtil.format(raceReport);
        assertAll(
                () -> assertThat(reportOutput).contains("꼴등차:"),
                () -> assertThat(reportOutput).contains("4등차:-"),
                () -> assertThat(reportOutput).contains("3등차:--"),
                () -> assertThat(reportOutput).contains("2등차:---"),
                () -> assertThat(reportOutput).contains("1등차:----")
        );
    }
}
