import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {
    private Game game;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>(Arrays.asList(new Car("페라리"), new Car("람보르기니")));

        game = new Game(3);
    }

    @Test
    @DisplayName("플레이_테스트")
    void printCarStatusTest() {
        Main.play(cars);
    }
}
