package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarMovingTest {

    @Test
    void 랜덤값_생성_0_to_9() {
        int randomMovingNum = Randoms.pickNumberInRange(0, 9);
        assertThat(randomMovingNum).isGreaterThanOrEqualTo(0);
        assertThat(randomMovingNum).isLessThanOrEqualTo(9);
    }

    @Test
    void 자동차_전진_메세지_출력() {
        String moving = "-";
        int movingNum = 5;
        String message = "pobi: ";

        for (int i = 0; i < movingNum; i++) {
            message = message.concat(moving);
        }

        System.out.println(message);

    }


}
