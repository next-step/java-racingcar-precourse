import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import Controller.*;
import Model.*;
import View.*;


public class RacingGameViewTest {

    private RacingGameView racingGameView;

    @BeforeEach
    public void setUp() {
        racingGameView = new RacingGameView();
    }

    @Test
    public void testInputCarName() {
        String input = "Car1,Car2,Car3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] result = racingGameView.inputCarName();

        assertArrayEquals(new String[]{"Car1", "Car2", "Car3"}, result);
    }

    @Test
    public void testInputRepeatCount() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = racingGameView.inputRepeatCount();

        assertEquals(5, result);
    }
}
