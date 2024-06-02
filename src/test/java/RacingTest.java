import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import domain.Racing;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
    Racing racing;

    @BeforeEach
    void init(){
        racing=new Racing();
    }

    @Test
    @DisplayName("차들 올바르게 생성되었는지 Test")
    void makeCarsTest(){
        List<String> carNames= Arrays.asList("Faker","Keria","Zeus");
        racing.makeCars(carNames);
        assertThat(racing.getCarList()).hasSize(3);
    }
    @Test
    @DisplayName("라운드에 차가 한칸씩 잘 이동하는지 Test")
    void roundTest(){
        List<String> carNames=Arrays.asList("Faker","Keria","Zeus");
        racing.makeCars(carNames);
        racing.round();
        assertThat(racing.getCarList()).allMatch(car->car.getDistance()==0||car.getDistance()==1);
    }
    @Test
    @DisplayName("라운드 결과가 올바르게 생성되는지 Test")
    void createRoundResultTest(){
        List<String> carNames=Arrays.asList("Faker","Keria","Zeus");
        racing.makeCars(carNames);
        StringBuilder sb=racing.createRoundResult();
        assertThat(sb.toString()).contains("Faker : ", "Keria : ","Zeus : ");
    }
    @Test
    @DisplayName("올바른 우승 거리를 가져오는지 Test")
    void findWinnerDistanceTest(){
        List<String> carNames=Arrays.asList("Faker","Keria","Zeus");
        racing.makeCars(carNames);
        racing.getCarList().get(0).forward();
        racing.getCarList().get(0).forward();
        racing.getCarList().get(1).forward();
        int max=racing.findWinnerDistance(racing.getCarList());
        assertThat(max).isEqualTo(2);
    }
    @Test
    @DisplayName("올바른 우승자를 찾는지 Test")
    void winnersCarTest(){
        List<String> carNames=Arrays.asList("Faker","Keria","Zeus");
        racing.makeCars(carNames);
        Car car1 = racing.getCarList().get(0);
        Car car2 = racing.getCarList().get(1);
        Car car3 = racing.getCarList().get(2);

        car1.forward();
        car1.forward();
        car2.forward();
        car2.forward();
        car3.forward();
        List<Car> winners = racing.winnerCars(racing.getCarList(),2);

        assertThat(winners).containsExactly(car1,car2);
    }
}
