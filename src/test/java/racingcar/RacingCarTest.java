package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import com.sun.org.apache.xml.internal.utils.StopParseException;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest extends NsTest{
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 공동_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("this,car,is,mine", "1");
                    assertThat(output()).contains("this : -", "car : ",  "is : -",  "mine : ", "최종 우승자:this, is");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
