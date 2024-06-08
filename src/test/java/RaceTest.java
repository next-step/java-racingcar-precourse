import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class RaceTest {
    private final Race race = new Race();

    @Test
    @DisplayName("움직임 테스트")
    public void testMoveCars() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        race.moveCars(cars);
        // mockito 라이브러리를 사용할 수 없어 세부적인 테스트가 불가능함.
    }
}
