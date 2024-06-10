import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WinnerTest {
    static boolean CarRunningInvoker(int testCount) {
        Car car = new Car("test");
        for (int i = 0; i < testCount; i++) {
            car.run();
        }
        int loc = car.getCurLocation();
        return (0 <= loc && loc <= testCount);
    }

    @Test
    void TestCurLocManual1() {
        int testCount = 10;
        boolean passed = WinnerTest.CarRunningInvoker(testCount);
        assertNotEquals("차량의 curLocation은 " + 0 + " ~ " + testCount + " 사이여야 합니다.", passed);
    }

    @Test
    void TestCurLocManual2() {
        int testCount = 100;
        boolean passed = WinnerTest.CarRunningInvoker(testCount);
        assertNotEquals("차량의 curLocation은 " + 0 + " ~ " + testCount + " 사이여야 합니다.", passed);
    }
}
