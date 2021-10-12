package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/12
 * @description :
 */
public class MoveNumsTest {

  @Test
  void moveNumSizeIs3() {
    Cars cars = new Cars(Arrays.asList(new Car("kia"), new Car("volvo"), new Car("benz")));
    MoveNums moveNums = new MoveNums(cars);
    assertThat(moveNums.getCarMoveNums().size()).isEqualTo(3);
  }

  @Test
  void moveNumSizeIs1() {
    Cars cars = new Cars(Arrays.asList(new Car("kia")));
    MoveNums moveNums = new MoveNums(cars);
    assertThat(moveNums.getCarMoveNums().size()).isEqualTo(1);
  }

}
