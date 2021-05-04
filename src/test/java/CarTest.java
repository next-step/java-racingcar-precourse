import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    public static final String CORRECT_CAR_NAME = "test";
    public static final String BLANK_CAR_NAME = "";
    public static final String OVER_5CHAR_CAR_NAME = "over5charactor";
    private static final int WILL_MOVE_ACCEL_VALUE = 4;
    private static final int WILL_NOT_MOVE_ACCEL_VALUE = 3;

    @Test()
    void test_Car_생성시_빈값을_입력한다면_Exception() {
        assertThrows(InvalidCarNameException.class, () -> {
            Car car = new Car(BLANK_CAR_NAME);
        });
    }

    @Test()
    void test_Car_생성시_널값을_입력한다면_Exception() {
        assertThrows(InvalidCarNameException.class, () -> {
            Car car = new Car(null);
        });
    }

    @Test()
    void test_Car_생성시_이름에_5자_이상을_입력한다면_Exception() {
        assertThrows(InvalidCarNameException.class, () -> {
            Car car = new Car(OVER_5CHAR_CAR_NAME);
        });
    }


    @Test()
    void test_Car의_생성시_정상적인_문자열을_입력했을때_해당_문자열이_getName시_리턴() throws InvalidCarNameException {
        Car car = new Car(CORRECT_CAR_NAME);
        assertEquals(car.getName(), CORRECT_CAR_NAME);
    }

    @Test
    void test_입력받은_값이_4_이상이면_따라_이동한다() throws InvalidCarNameException {
        Car car = new Car(CORRECT_CAR_NAME);
        int beforeMovePosition = car.getPosition();
        car.moveOrDont(WILL_MOVE_ACCEL_VALUE);
        int afterMovePosition = car.getPosition();
        assertEquals(beforeMovePosition + 1, afterMovePosition);
    }

    @Test
    void test_입력받은_값이_4_미만이면_이동하지_않는다() throws InvalidCarNameException {
        Car car = new Car(CORRECT_CAR_NAME);
        int beforeMovePosition = car.getPosition();
        car.moveOrDont(WILL_NOT_MOVE_ACCEL_VALUE);
        int afterMovePosition = car.getPosition();
        assertEquals(beforeMovePosition, afterMovePosition);
    }
}
