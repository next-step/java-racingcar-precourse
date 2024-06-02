import Model.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {

    @Test
    void carNameShouldBeFiveOrLess(){
        assertThatThrownBy(() -> new Car("hihihi")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 5글자 이하의 이름으로 지어주세요.");
    }

    @Test
    void moveValueIsFourOrMore(){
        Car car = new Car("test");
        boolean moved = false;

        for (int i =0; i<10; i++){
            car.move();
            if(car.getPosition() > 0){
                moved = true;
                break;
            }
        }
        assertThat(moved).isTrue();
    }
}
