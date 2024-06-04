import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ResultEvaluatorTest {
    private final ResultEvaluator resultEvaluator = new ResultEvaluator();

    @Test
    @DisplayName("한 자동차만 우승인 경우 테스트")
    public void testGetWinners_SingleWinner() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        List<String> winners = resultEvaluator.getWinners(cars);
        assertEquals(1, winners.size());
        assertEquals("car1", winners.get(0));
    }

    @Test
    @DisplayName("여러 자동차가 우승인 경우 테스트")
    public void testGetWinners_MultipleWinners() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        cars.get(0).move();
        cars.get(1).move();
        List<String> winners = resultEvaluator.getWinners(cars);
        assertEquals(2, winners.size());
        assertTrue(winners.contains("car1"));
        assertTrue(winners.contains("car2"));
    }
}
