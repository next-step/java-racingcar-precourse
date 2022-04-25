package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RaceRecordTest {

    @Test
    void 경주_기록() {
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        cars.put("A", Car.create("A"));

        cars.get("A").moveForward();
        cars.get("A").moveForward();
        cars.get("A").moveForward();

        RaceRecord record = new RaceRecord();
        record.of(cars);

        for(String r : record.getList()) {
            System.out.println(r);
        }

        assertThat(record.getList()).contains(
                RaceRecord.RACE_RESULT,
                String.format(RaceRecord.RACE_PROGRESS_FORM, "A", "---")
        );
    }

    @Test
    void 승리자() {
        Winners winners = new Winners();
        winners.add("A");
        winners.add("B");
        winners.add("C");

        RaceRecord record = new RaceRecord();
        record.addWinners(winners);

        System.out.println(record.getList().toString());
        assertThat(record.getList().get(record.getList().size() - 1)).contains("A, B, C");
    }

}