package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    
    @Test
    @DisplayName("자동차 이동 테스트 - 1~3일 경우 stop, 4~9일 경우 go")
    public void moveTest() {
        // Refactoring을 통한 테스트 로직 수정 및 재테스트
        RandomNumber randomNumber = new RandomNumber();
        
        // 3. 차가 필요해. 이름 입력.
        Car car = new Car("Merce");

        int randomNo = randomNumber.getRandomNumber();
        System.out.println("number : " + randomNo);
        
        // 2. 랜덤숫자를 넘겨서 게임을 진행.
        car.play(randomNo);
        
        System.out.println("car.getCurrentPosition() : " + car.getCurrentPosition());
        
        // 0. 움직였을때를 가정하고 Test 메소드 만들 예정.
        if (randomNo >= 4 && randomNo <= 9) {
            assertThat(car.getCurrentPosition()).isEqualTo(1);
        } else if (randomNo < 0 || randomNo > 9) {
            assertThat(car.getCurrentPosition()).isEqualTo(0);
        }
        
        
        /* AS-IS 초기 테스트 로직
        RandomNumber randomNumber = new RandomNumber();
        
        // 3. 차가 필요해. 이름 + 현재위치가 있어야 해.
        Car car = new Car("Mercedes", 0);
        
        int givenNumber = randomNumber.getRandomNumber();
        
        // 2. 움직이는걸 알려면 차 + 건내받은 랜덤숫자가 필요해.
        Racing racing = new Racing(car, givenNumber);
        
        // 1. 현재 상태를 알기 위해선 움직이는게 필요해. 파라미터는 자동차이름 + 숫자 --> racing
        
        racing.play(racing);
        racing.play(racing);
        racing.play(racing);
        
        System.out.println("racing.getRandomNumber() : " + racing.getRandomNumber());
        System.out.println("car.getCurrentPosition() : " + car.getCurrentPosition());
        
        // 0. 움직였을때를 가정하고 Test 메소드 만들 예정.
        if (givenNumber >= 4 && givenNumber <= 9) {
            assertThat(car.getCurrentPosition()).isEqualTo(3);
        } else if (givenNumber < 0 || givenNumber > 9) {
            assertThat(car.getCurrentPosition()).isEqualTo(0);
        }
        
        */
        
    }
    
}
