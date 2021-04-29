package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    @DisplayName("자동차 이동 테스트 - 1~3일 경우 stop, 4~9일 경우 go")
    public void move() {
        
        // 3. 차가 필요해. 이름 + 현재위치가 있어야 해.
        Car car = new Car("Mercedes", 0);
        
        // 2. 움직이는걸 알려면 차 + 건내받은 랜덤숫자가 필요해.
        Racing racing = new Racing(car, 4);
        
        // 1. 현재 상태를 알기 위해선 움직이는게 필요해. 파라미터는 자동차이름 + 숫자 --> racing
        racing.play(racing);
        racing.play(racing);
        racing.play(racing); 
        
        // 0. 1칸 움직였을때를 가정하고 Test 메소드 만들 예정.
        assertThat(car.getCurrentPosition()).isEqualTo(3);
        
    }
}
