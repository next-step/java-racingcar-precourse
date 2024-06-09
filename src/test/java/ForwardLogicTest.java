import Controller.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Random;

public class ForwardLogicTest {

    @Test
    public void testForwarding() {
        ForwardLogic logic = new ForwardLogic();

        // 반복 테스트를 통해 결과 확인
        boolean foundTrue = false;
        boolean foundFalse = false;

        for (int i = 0; i < 1000; i++) {
            boolean result = logic.forwarding();
            if (result) {
                foundTrue = true;
            } else {
                foundFalse = true;
            }
            if (foundTrue && foundFalse) {
                break; // 두 가지 경우를 모두 발견하면 테스트 종료
            }
        }

        assertTrue(foundTrue);
    }
}