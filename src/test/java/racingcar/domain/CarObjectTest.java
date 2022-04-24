package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CarObjectTest {
    @Test
    void generateCarTest(){
        String carName = "TestCar";
        CarObject carObject = new CarObject(carName);
        assertThat(carObject.toString()).isEqualTo("TestCar : ");
    }
    @Test
    void toStringTest(){
        String carName = "TestCar";
        CarObject carObject = new CarObject(carName);
        carObject.setForwardCount(3);
        assertThat(carObject.toString()).isEqualTo("TestCar : ---");
    }
}
