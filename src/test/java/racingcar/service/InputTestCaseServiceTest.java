package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.value.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTestCaseServiceTest {

    @Test
    void 테스트케이스_자동차_입력값_가져오기() {
        //when
        String carsInput = new InputTestCaseService(TestCase.CASE1).getCars();

        //then
        assertThat(carsInput).isEqualTo("k3, k5, k7, k9");
    }

    @Test
    void 테스트케이스_트랙_입력값_가져오기() {
        //when
        String trackInput = new InputTestCaseService(TestCase.CASE1).getTrack();

        //then
        assertThat(trackInput).isEqualTo("3");
    }
}
