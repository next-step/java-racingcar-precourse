package racingcar.model.record;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.distance.ForwardDistance;
import racingcar.model.car.name.CarName;


public class RecordsTest {

    private Records records = new Records();

    @Test
    @DisplayName("거리가 3, 1, 2일 때 3이 ranker")
    void 거리가_3_1_2_일때_3이_ranker_test() {
        records.addRecord(new Record(new CarName("lee"), new ForwardDistance(3)));
        records.addRecord(new Record(new CarName("kim"), new ForwardDistance(1)));
        records.addRecord(new Record(new CarName("ho"), new ForwardDistance(2)));
        assertThat(records.rankSheet()).isEqualTo("lee");
    }
}
