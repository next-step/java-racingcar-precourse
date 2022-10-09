package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParserUtilTest {

  @ParameterizedTest
  @DisplayName("자동차이름 파싱 테스트")
  @CsvSource({ "pop, 1", "'pop,bob', 2", "'pop,bob,coc', 3" })
  void 자동차이름파싱(String input, Integer value) {
   List<String> carNames =  ParserUtil.StringToList(input);
   assertThat(carNames.size()).isEqualTo(value);
  }

}
