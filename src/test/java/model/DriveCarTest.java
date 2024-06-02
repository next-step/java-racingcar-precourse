package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriveCarTest {
    private DriveCar driveCar;
    private HashMap<String, String> result;
    private Random random;

    @BeforeEach
    public void setUp() {
        result = new HashMap<>();
        result.put("CarA", "");
        result.put("CarB", "");

        random = new Random() {
            private int callCount = 0;

            @Override
            public int nextInt(int bound) {
                callCount++;
                if (callCount == 1) {
                    return 5; // 첫 번째 호출에 대해 5 반환
                }
                if (callCount == 2) {
                    return 3; // 두 번째 호출에 대해 3 반환
                }
                return super.nextInt(bound);
            }
        };
        driveCar = new DriveCar(result, random);
    }

    @Test
    public void testDriveCarMovesForward() {
        driveCar.drive("CarA");
        String movement = result.get("CarA");

        assertEquals("-", movement);  // 예상 결과는 "-"
    }

}
