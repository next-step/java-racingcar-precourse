package camp.nextstep.edu.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarListTest {

    private RacingCarList racingCarList;

    @Test
    @DisplayName("레이싱카 리스트 생성 - 성공 테스트")
    void setCarList_successList() {
        // given
        String[] names = new String[]{"pobi", "crong", "honux"};

        // when
        racingCarList = new RacingCarList(names);

        // then
        assertThat(racingCarList.getCarList().size()).isEqualTo(names.length);
    }
}
