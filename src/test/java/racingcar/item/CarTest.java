package racingcar.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by victorsung.
 * Date: 2022/04/25
 * Time: 8:28 PM
 */
public class CarTest {

    @Test
    @DisplayName("자동차 셋팅")
    void Car(){
        // given
        Car testCar = new Car("test_car", 5);
        System.out.println(testCar.getName());

        Map<Integer, CarStatus> status = testCar.getStatus();
        System.out.println(status.toString());
        System.out.println(status.size());

        // when
//        CarStatus status = computer.play(new Ball(1, 4));
        // then
        assertThat(status.size()).isEqualTo(5);
    }

}
