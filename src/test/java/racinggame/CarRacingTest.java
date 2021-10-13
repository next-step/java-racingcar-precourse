package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/13
 * @description :
 */
public class CarRacingTest {

  private CarRacing carRacing;
  private Cars cars;

  @Mock
  MoveNums moveNums;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    cars = new Cars(Arrays.asList(new Car("kia"), new Car("volvo"), new Car("benz")));
    carRacing = new CarRacing(cars, moveNums, 5);
  }

  @Test
  void winnerIsVolvo() {
    Mockito.lenient().when(moveNums.getCarMoveNums()).thenReturn(Arrays.asList(1,4,1));
    carRacing.start();
    assertThat(carRacing.winner().get(0).getCarName()).isEqualTo("volvo");
  }

  @Test
  void winnerIsVolvoAndBenz() {
    Mockito.lenient().when(moveNums.getCarMoveNums()).thenReturn(Arrays.asList(1,4,4));
    carRacing.start();
    assertThat(carRacing.winner().get(0)).isEqualTo("volvo");
  }

}
