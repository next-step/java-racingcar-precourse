import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    @DisplayName("입력받은 자동차가 아무것도 없을때")
    public void NoCar() {
        // Given: 테스트를 위한 사전 조건 설정
       String cars="";


        // When: 실제 테스트하고자 하는 동작을 수행
        int result = Baseball.find_same_number(error);

        // Then: 기대하는 결과와 실제 결과를 비교
        assertEquals(1, result);
    }
}
