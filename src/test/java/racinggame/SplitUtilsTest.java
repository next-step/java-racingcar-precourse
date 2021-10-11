package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class SplitUtilsTest {

  @Test
  void splitCarName(){
    String[] carNames = SplitUtils.split("benz,kia,volvo");
    assertThat(carNames.length).isEqualTo(3);
    assertThat(carNames[0]).isEqualTo("benz");
    assertThat(carNames[1]).isEqualTo("kia");
    assertThat(carNames[2]).isEqualTo("volvo");
  }

}
