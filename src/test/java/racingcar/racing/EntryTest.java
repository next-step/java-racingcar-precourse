package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.ErrorMessage;
import racingcar.car.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EntryTest {
    Entry entry;

    @BeforeEach
    void setup() {
        entry = new Entry(CarName.splitInputCarNames("ray,k3,niro"));
    }

    @Test
    void 자동차_레이싱_참가자_등록_검증() {
        assertThat(entry.getEntryList().get(0).getName().toText()).isEqualTo("ray");
    }

    @Test
    void 자동차_레이싱_참가자_출발_위치_확인() {
        assertThat(entry.getEntryList().get(0).getPosition().toResultText()).isEqualTo("");
        assertThat(entry.getEntryList().get(0).getPosition().toNumber()).isEqualTo(0);
    }

    @Test
    void 참가_자동차가_최소_기준을_충족하지_못할_경우() {
        assertThatThrownBy(() -> new Entry(CarName.splitInputCarNames("ray")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ENTRY_NOT_VALID_SIZE);
    }
}
