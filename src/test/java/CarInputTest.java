import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class CarInputTest {
    @Test
    public void testCarListSplit() {
        String input = "car1,car2,car3";
        String[] expected = {"car1", "car2", "car3"};
        assertArrayEquals(expected, CarInput.carListSplit(input));
    }

    @Test
    public void testGetCarList() {
        String input = "car1,car2,car3\n";
        Scanner sc = new Scanner(input);
        ArrayList<String> carList = CarInput.getCarList(sc);

        assertEquals(3, carList.size());
        assertEquals("car1", carList.get(0));
        assertEquals("car2", carList.get(1));
        assertEquals("car3", carList.get(2));
    }

    @Test
    public void testCreateCarList() {
        String input = "car1,car2\n";
        Scanner sc = new Scanner(input);
        ArrayList<String> carList = CarInput.createCarList(sc);

        assertEquals(2, carList.size());
        assertEquals("car1", carList.get(0));
        assertEquals("car2", carList.get(1));
    }

    @Test
    public void testValidateCarName() {
        assertThrows(IllegalArgumentException.class, () -> CarInput.validateCarName("carnameTooLong"));
    }
}
