import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CarTest {
    Car car = new Car("test");
    @Test
    void carTest(){
        int count = 0;
        for(int i = 0; i < 10; i++) {
            car.makeDecision();
            if(car.getRand_number() >= 4)
                count++;
        }
        int length = car.getName().length();
        boolean tf = length == count;
        Assertions.assertTrue(tf);
    }
}
