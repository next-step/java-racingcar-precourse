package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

  private List<Car> cars;
  private Random random;

  @BeforeEach
  void setUp() {
    cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
    random = new Random() {
      @Override
      public int nextInt(int bound) {
        return bound / 2; // 항상 5를 반환하게 해서 움직이게 함 (4 이상)
      }
    };
  }

  @Test
  void getWinners_singleWinner() {
    cars.get(0).move();
    cars.get(0).move();
    cars.get(1).move();

    Game game = new Game(cars, 0);
    List<Car> winners = game.getWinners();

    assertEquals(1, winners.size());
    assertEquals("car1", winners.get(0).getName());
  }

  @Test
  void getWinners_multipleWinners() {
    cars.get(0).move();
    cars.get(1).move();
    cars.get(2).move();

    Game game = new Game(cars, 0);
    List<Car> winners = game.getWinners();

    assertEquals(3, winners.size());
  }
}
