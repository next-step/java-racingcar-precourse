package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {

  private List<Integer> randomNumbers = new ArrayList();

  @BeforeEach
  void setup() {
    randomNumbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
  }

  @Test
  @DisplayName("전진 후진 을 위한 랜덤 0-9사이 숫자 생성")
  void 랜덤숫자생성() {

    Integer randomNumber = RandomUtil.getRandomNumber();
    assertThat(randomNumbers.contains(randomNumber)).isTrue();
  }

}
