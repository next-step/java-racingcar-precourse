import Racing.util.GenerateRandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    GenerateRandomNumber generator = new GenerateRandomNumber();

    @RepeatedTest(100)
    @DisplayName("GenerateRandomNumber 테스트 - 숫자가 0부터 9 사이")
    void getRandomNumberTest() {
        int number = generator.getRandomNumber();
        assertThat(number).isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(GenerateRandomNumber.MAX_NUMBER);
    }
}
