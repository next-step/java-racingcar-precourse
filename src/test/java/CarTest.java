import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CarTest {
    @Test
    void LENGTH_EXCEPTION() {
        assertThatThrownBy(() -> new Car("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    void MOVE_TEST() {
        Car car = new Car("pobi");
        car.makeMove();
        assertThat(car.getPosition()).isBetween(0, 1);
    }
    @Test
    public void testMakeCarList() {
        String input = "pobi,woni,jun";
        String[] carNames = input.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name.trim()));
        }
        assertEquals(3, carList.size());
        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
    }
}
