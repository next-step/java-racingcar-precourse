package racinggame;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.cars.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racinggame.domain.constants.Status.FORWARD;
import static racinggame.domain.constants.Status.NAMING_COLON;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = "슈퍼카")
    void setCarName(String input) {

        Car car = new Car(input);
        assertEquals(car.getName(), input);
    }

    @Test
    void forward() {
        String carName = "슈퍼카";
        StringBuilder resultMessage = new StringBuilder();
        ;
        Car car = new Car(carName);

        assertEquals(car.forward(), resultMessage.append(carName).append(NAMING_COLON.getMessage()).append(FORWARD.getMessage()).toString());

    }

    @Test
    void stopOrForward() {
        String carName = "슈퍼카";
        int[] randomArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        StringBuilder resultMessage = new StringBuilder();
        ;
        Car car = new Car(carName);

        for (int random : randomArray) {
            car.judgeToStopOrForward(random);
        }

        resultMessage.append(carName)
                .append(NAMING_COLON.getMessage())
                .append(FORWARD.getMessage())
                .append(FORWARD.getMessage())
                .append(FORWARD.getMessage())
                .append(FORWARD.getMessage())
                .append(FORWARD.getMessage())
                .append(FORWARD.getMessage());

        assertEquals(car.showResult(), resultMessage.toString());
    }


}
