package racingcar.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceRecordsTest {

    private RaceRecords records;

    @BeforeEach
    void setUp() {
        this.records = new RaceRecords();
    }


    @Test
    @DisplayName("기록이 잘 등록되는가")
    void add() {
        this.records.add(new RaceRecord(1, new RacingCar(new Car("pobi")), RaceResult.GO));
        assertThat(this.records.count()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름으로 전진 개수를 알 수 있는가?")
    void get_steps_by_names() {
        this.records.add(new RaceRecord(1, new RacingCar(new Car("pobi")), RaceResult.GO));
        this.records.add(new RaceRecord(2, new RacingCar(new Car("pobi")), RaceResult.STOP));
        this.records.add(new RaceRecord(3, new RacingCar(new Car("pobi")), RaceResult.GO));

        this.records.add(new RaceRecord(1, new RacingCar(new Car("crong")), RaceResult.GO));
        this.records.add(new RaceRecord(2, new RacingCar(new Car("crong")), RaceResult.GO));
        this.records.add(new RaceRecord(3, new RacingCar(new Car("crong")), RaceResult.GO));

        assertThat(this.records.getStepsByCarName("pobi")).isEqualTo(2);
        assertThat(this.records.getStepsByCarName("crong")).isEqualTo(3);
    }
}
