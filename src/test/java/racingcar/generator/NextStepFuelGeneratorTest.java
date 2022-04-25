package racingcar.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextStepFuelGeneratorTest {

    @Test
    @DisplayName("생성된 값이 0~9의 범위인지 확인한다.")
    void 지정_범위_값_생성_확인(){
        FuelGenerator fuelGenerator = new NextStepFuelGenerator();

        int fuel = fuelGenerator.generateFuel();

        assertFalse((fuel > 9 || fuel < 0), "생성된 값이 0~9의 범위가 아닙니다.");
    }

}