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
  private Car kia;
  private Car volvo;
  private Car benz;

  @Mock
  MoveNums moveNums;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    kia = new Car("kia");
    volvo = new Car("volvo");
    benz = new Car("benz");
    cars = new Cars(Arrays.asList(kia, volvo, benz));
    carRacing = new CarRacing(cars, moveNums, 5);
  }

  @Test
  void winnerIsVolvo() {
    Mockito.lenient().when(moveNums.getCarMoveNums()).thenReturn(Arrays.asList(1,4,1));
    carRacing.start();
    assertThat(carRacing.winner().get(0).getCarName()).isEqualTo(volvo.getCarName());
  }

  @Test
  void winnerIsVolvoAndBenz() {
    Mockito.lenient().when(moveNums.getCarMoveNums()).thenReturn(Arrays.asList(1,4,4));
    carRacing.start();
    assertThat(carRacing.winner()).contains(volvo, benz);
  }

  @Test
  void winnerIsKiaAndVolvoAndBenz() {
    Mockito.lenient().when(moveNums.getCarMoveNums()).thenReturn(Arrays.asList(4,4,4));
    carRacing.start();
    assertThat(carRacing.winner()).contains(kia, volvo, benz);
  }

}
