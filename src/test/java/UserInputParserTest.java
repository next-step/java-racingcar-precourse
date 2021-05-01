import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class UserInputParserTest {
    private UserInputParser userInputParser;

    @BeforeEach
    void setup() {
        this.userInputParser = new UserInputParser();
    }

    @ParameterizedTest
    @CsvSource(value = {"bac,wrterddf:1", "2314cx,12,3,08d:3", "192887ds,  !@8c8  ,*cc &*(sd1, czvzxd,eterd ,!))*Fdf,  :2"}, delimiter = ':')
    @DisplayName("사용자가 쉼표를 기준으로 입력한 자동차 이름들을 파싱한다.")
    void parse(String userInput, int validCarNameCount) {
        List<CarName> carNames = this.userInputParser.parse(userInput);

        Assertions.assertThat(carNames.size()).isEqualTo(validCarNameCount);
    }
}
