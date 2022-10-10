package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecordsTest {

    @Test
    @DisplayName("Record 객체의 리스트를 인자로 전달받아 Records 객체를 생성한다")
    void createRecordsTest() {
        Record haha = Record.from(new RacingCar("haha"));
        Record hoho = Record.from(new RacingCar("hoho"));
        List<Record> recordList = Arrays.asList(haha, hoho);
        Records records = Records.of(recordList);
        assertThat(records.getRecordList()).containsExactly(haha, hoho);
    }

    @Test
    @DisplayName("현재 위치가 가장 큰 이름을 반환한다.")
    void getWinnerTest() {
        Record haha = Record.from(new RacingCar("haha"));
        Record hoho = Record.from(new RacingCar("hoho"));
        List<Record> recordList = Arrays.asList(haha, hoho);
        Records records = Records.of(recordList);
        Winners winners = records.getWinners();
        List<String> names = winners.getNames();
        assertThat(names).hasSize(2).containsExactly("haha", "hoho");

    }

}


