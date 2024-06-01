import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertJTest {

    @BeforeEach
    void setUp() {
        RacingGame.racingCar.add(new Car("c1"));
        RacingGame.racingCar.add(new Car("c2"));
        RacingGame.racingCar.add(new Car("c3"));
        RacingGame.racingCar.add(new Car("c4"));
        RacingGame.racingCar.add(new Car("c5"));
        RacingGame.racingCar.add(new Car("c6"));
        for(int i=0; i<10; i++)
            RacingGame.racing();
        RacingGame.lineUp();
    }

    @Test
    @DisplayName("randNum() 메서드가 0~9 사이 값을 반환하는가?")
    void testRandomNumRange() {
        for(int i=0; i<1000; i++)
            Assertions.assertThat(RacingGame.randNum()).isBetween(0, 9);
    }

    @Test
    @DisplayName("순위별로 차량이 올바르게 정렬 되는가?")
    void testLanking() {
        for(int i=0; i<RacingGame.racingCar.size()-1; i++)
            Assertions.assertThat(RacingGame.racingCar.get(i).getPosition().length()).isGreaterThanOrEqualTo(RacingGame.racingCar.get(i+1).getPosition().length());
    }

    @Test
    @DisplayName("우승 차량이 올바르게 선정 되는가?")
    void testResult() {
        Car winner = new Car("1st");
        RacingGame.racingCar.add(winner);
        RacingGame.racingCar.add(new Car("c7"));
        for(int i=0; i<11; i++)
            winner.forward();
        RacingGame.lineUp();
        Assertions.assertThat(RacingGame.winner()).isEqualTo(0);
        Assertions.assertThat(RacingGame.racingCar.get(RacingGame.winner()).getName()).isEqualTo(winner.getName());
    }
}
