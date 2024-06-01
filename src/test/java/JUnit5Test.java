import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;

public class JUnit5Test {

    private ArrayList<Car> carList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        carList.add(new Car("a"));
        carList.add(new Car("b"));
    }
}
