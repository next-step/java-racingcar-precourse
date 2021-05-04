import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberTest {

    @RepeatedTest(100000)
    void randomNumber() {
        Assertions.assertEquals(RandomNumber.getZero2Nine() >= 0, true);
        Assertions.assertEquals(RandomNumber.getZero2Nine() <= 9, true);
    }
}
