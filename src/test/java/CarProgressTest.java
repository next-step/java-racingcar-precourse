import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarProgressTest {
    @DisplayName("CarProgress class Test")
    @ParameterizedTest(name = "carName: {0}, progressCnt: {1}일 때")
    @CsvSource({
            "aaaa, 3, 'aaaa : ---'",
            "bbb, 6, 'bbb : ------'",
            "c, 0, 'c : '"
    })
    public void progressTest(String carName, int progressCnt, String expected) {
        CarProgress car = new CarProgress(carName);
        for (int i = 0; i < progressCnt; i++) {
            car.move();
        }

        Assertions.assertThat(car.toString())
                .isEqualTo(expected);
    }
}
