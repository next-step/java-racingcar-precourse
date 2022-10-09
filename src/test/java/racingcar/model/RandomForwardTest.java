package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.entity.Cars;
import racingcar.view.OutputResult;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomForwardTest {
    @Test
    void 전진_결과_테스트() {
        Cars cars = new Cars("aaa");

        OutputStream oStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(oStream));

        int returnMoveValue = 1;
        for (String key : cars.getCarMap().keySet()) {
            cars.getCarMap().put(key, returnMoveValue);
            OutputResult.printCarForwardState(key, cars.getCarMap().get(key));
        }

        assertThat("aaa : -\r\n").isEqualTo(oStream.toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1", "3:0"}, delimiter = ':')
    void 전진_가능값_테스트(String RandomValue, String returnCount) {
        int moveCount = 0;
        if (Integer.parseInt(RandomValue) >= 4) {
            moveCount++;
        }

        assertEquals(moveCount, Integer.parseInt(returnCount));
    }
}
