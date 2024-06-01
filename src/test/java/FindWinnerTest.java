import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class FindWinnerTest {

    Winner win;
    ArrayList<Car> carList;

    Car c1;
    Car c2;

    @BeforeEach
    void setUp() {

        carList = new ArrayList<>();
        c1 = new Car("c1");
        c2 = new Car("c2");
        c1.movingForward(8);

        carList.add(c1);
        carList.add(c2);
        
        win = new Winner(carList);
    }

    @Test
    @DisplayName("find winner test")
    public void findWinnerTest() {

        ArrayList<String> winners = new ArrayList<>();
        winners.add("c1");
        
        assertThat(win.getWinners()).isEqualTo(winners);
    }
}
