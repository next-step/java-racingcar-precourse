package racingcar.cars;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    private static Car pobiCar;

    @BeforeAll
    public static void 자동차_세팅() throws IllegalArgumentException {
        pobiCar = new Car("pobi");
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하만 유효합니다.")
    public void 자동차_이름_유효성() throws IllegalArgumentException {
        assertAll(
                () -> assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(() -> new Car("일이삼사오육칠"))
                        .withMessageMatching("자동차 이름은 \\d+자 이하만 가능하다."));
    }

    @Test
    @DisplayName("자동차 이름")
    public void 자동차_이름_가져오기() throws IllegalArgumentException {

        assertThat(pobiCar.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 위치")
    public void 자동차_위치_세팅() throws IllegalArgumentException {
        pobiCar.setLocation(true);
        assertThat(pobiCar.getLocation()).isEqualTo(1);
        pobiCar.setLocation(true);
        assertThat(pobiCar.getLocation()).isEqualTo(2);
        pobiCar.setLocation(false);
        assertThat(pobiCar.getLocation()).isEqualTo(2);
        pobiCar.setLocation(true);
        assertThat(pobiCar.getLocation()).isEqualTo(3);
    }

}
