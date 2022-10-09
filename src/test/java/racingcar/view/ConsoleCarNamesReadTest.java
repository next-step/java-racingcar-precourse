package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import racingcar.model.cars.Car;
import racingcar.model.cars.CarNamesAnalyzer;
import racingcar.model.cars.Cars;

public class ConsoleCarNamesReadTest {
    @Test
    void 콘솔_입력_자동차_목록_생성() {
        String carNames = "가나다,123,  _ ";
        this.setInput(carNames);

        Cars cars = ConsoleCarNames.createCars();
        List<Car> carList = cars.get();

        String[] carNameArray = CarNamesAnalyzer.getInstance().getNamesArray(carNames);
        for (int i = 0; i < carList.size(); i++) {
            assertEquals(carNameArray[i], carList.get(i).getTitle().get());
        }
    }

    @Test
    void 콘솔_입력_예외_공백() {
        String[] errorStrings = new String[]{""};
        this.assertNotAcceptableStringsThrowException(errorStrings, NoSuchElementException.class);
    }

    private <T extends Exception> void assertNotAcceptableStringsThrowException(String[] errorStrings, Class<T> e) {
        for (String errorString : errorStrings) {
            this.setInput(errorString);
            assertThatThrownBy(() -> ConsoleCarNames.read()).isInstanceOf(e);
        }
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
