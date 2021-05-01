import domain.Car;
import domain.Cars;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Racing;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class racingTest {

    private Racing racing;

    private Cars cars;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("자동차 이름 길이 체크.")
    @Test
    void checkCarNameLengthTest() {
        Car carOverLength = new Car("asdfd");
        assertThat(carOverLength.getCarName().getName().length()).isGreaterThan(4);

        Car carNull = new Car("");
        assertThat(carNull.getCarName().getName().length()).isLessThan(1);
    }

    @DisplayName("자동차 이름 목록을 특수문자로 각각 나누기 체크.")
    @Test
    void getDeviceValueTest() {
        racing = new Racing("a,b");
        assertThat(racing.getCars().getCars().get(0).getCarName().getName()).isEqualTo("a");
    }
}
