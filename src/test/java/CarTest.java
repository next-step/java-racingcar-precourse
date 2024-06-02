import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("전진후 거리증가 확인 테스트")
    void carForwardTest(){
        Car car=new Car("Test");
        car.forward();
        assertThat(car.getDistance()).isEqualTo(1);
    }
    @Test
    @DisplayName("라운드 출력결과 확인테스트")
    void carRoundResultTest(){
        Car car=new Car("Test");
        car.forward();
        car.forward();
        car.forward();
        assertThat(car.roundResult().toString()).isEqualTo("Test : ---");
    }
    @Test
    @DisplayName("우승자 생성결과 테스트")
    void carCreateWinnerTest(){
        Car car=new Car("Test");
        assertThat(car.createWinner().toString()).isEqualTo("Test, ");
    }

}
