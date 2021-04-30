package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    
    @Test
    @DisplayName("입력받은 값을 쉼표로 분리하여 객체에 할당")
    public void nameSplitTest() {
        
        String userInput = "bee, apple, joy, p";
        userInput = userInput.replace(" ", "");
        
        List<Car> carList = new ArrayList<>();
        
        String[] carNameArray;
        carNameArray = userInput.split(",");
        
        for (int i = 0; i < carNameArray.length; i++) {
            carList.add(new Car(carNameArray[i]));
        }
        
        assertThat(carList.get(0).getCarName()).isEqualTo("bee");
        assertThat(carList.get(1).getCarName()).isEqualTo("apple");

    }
}
