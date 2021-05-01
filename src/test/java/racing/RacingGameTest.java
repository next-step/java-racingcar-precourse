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
    
    @Test
    @DisplayName("게임 진행시 숫자에 따라 전진하는 기능 테스트")
    public void playOneStepTest() {
        
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("1_Car"));
        carList.add(new Car("2_Car"));
        carList.add(new Car("3_Car"));
        carList.add(new Car("4_Car"));
        
        carList.get(0).play(3);
        carList.get(1).play(1);
        carList.get(2).play(5);
        carList.get(3).play(8);
        
        assertThat(carList.get(0).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(carList.get(3).getCurrentPosition()).isEqualTo(1);
        
        carList.get(0).play(0);
        carList.get(1).play(2);
        carList.get(2).play(3);
        carList.get(3).play(5);
        
        assertThat(carList.get(0).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(carList.get(3).getCurrentPosition()).isEqualTo(2);
        
        carList.get(0).play(9);
        carList.get(1).play(1);
        carList.get(2).play(2);
        carList.get(3).play(7);
        
        assertThat(carList.get(0).getCurrentPosition()).isEqualTo(1);
        assertThat(carList.get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(carList.get(3).getCurrentPosition()).isEqualTo(3);
        
    }
    
}
