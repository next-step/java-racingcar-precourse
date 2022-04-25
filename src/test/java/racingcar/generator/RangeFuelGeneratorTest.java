package racingcar.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RangeFuelGeneratorTest {
    int minValue = 2;
    int maxValue = 8;

    @Test
    @DisplayName("주어진 범위에 맞는 값을 생성하는지 확인한다.")
    void 범위_값_생성_확인(){
        FuelGenerator fuelGenerator = Mockito.mock(RangeFuelGenerator.class, Mockito.CALLS_REAL_METHODS);
        int fuel = fuelGenerator.generateFuel(minValue, maxValue);
        assertFalse((fuel > maxValue || fuel < minValue), "생성된 값이 input값의 범위에 해당되지 않습니다.");
    }
}