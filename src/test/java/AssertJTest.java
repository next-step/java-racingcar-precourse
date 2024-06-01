import org.junit.jupiter.api.BeforeEach;

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
}
