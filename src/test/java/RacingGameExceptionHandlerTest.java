import View.RacingGameExceptionHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameExceptionHandlerTest {

    @Test
    public void testIsRightString() {
        RacingGameExceptionHandler handler = new RacingGameExceptionHandler();
        assertTrue(handler.isRightString("Car1,Car2,Car3"));
        assertFalse(handler.isRightString("Car1,Car2,Car333"));
        assertFalse(handler.isRightString(",Car2,Car3"));
        assertFalse(handler.isRightString("Car1,"));
        assertFalse(handler.isRightString(""));
    }

    @Test
    public void testIsInt() {
        RacingGameExceptionHandler handler = new RacingGameExceptionHandler();
        assertTrue(handler.isInt("123"));
        assertFalse(handler.isInt("abc"));
        assertFalse(handler.isInt("12a3"));
        assertFalse(handler.isInt(""));
    }
}
