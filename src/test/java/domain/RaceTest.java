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

         race = new Race(cars, new Count(3));
    }

    @Test
    @DisplayName("경기의 결과 정보가 알맞은 우승자를 반환하는지 테스트")
    public void findWinners_ShouldReturn_MaxDistanceCars() {
        race.end();
        RaceReport raceReport = race.report();
        //when
        List<CarDto> winners = raceReport.getWinners();
        //then
        assertAll(
            () -> assertThat(winners).hasSize(2),
            () -> assertThat(winners.get(0).getLocation()).isEqualTo(winnerDistance),
            () -> assertThat(winners.get(1).getLocation()).isEqualTo(winnerDistance)
        );
    }

    @Test
    @DisplayName("경기를 한 턴 진행시키면, 경기의 남은 턴 수가 정상적으로 차감되는지 테스트")
    public void playOneCount_ShouldDiscount_RemainMoveCount() {
        //when
        race.playOneCount();
        //then
        assertAll(
                () -> assertThat(race.getRemainMoveCount()).isEqualTo(new Count(2)),
                () -> assertThat(race.isEnd()).isFalse()
        );
    }

    @Test
    @DisplayName("경기의 남은 횟수가 모두 소진되었을때, 경기의 상태가 완료로 변경되는지 테스트")
    public void allMoveCountUsed_RaceStatus_MustBeEnd() {
        //when
        race.playOneCount();
        race.playOneCount();
        race.playOneCount();
        //then
        assertAll(
                () -> assertThat(race.getRemainMoveCount()).isEqualTo(Count.zero()),
                () -> assertThat(race.isEnd()).isTrue()
        );
    }

    @Test
    @DisplayName("race의 결과를 제대로 포매팅하는지 테스트")
    public void testFormatReport() {
        RaceReport raceReport = race.report();
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
