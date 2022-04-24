package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarListTest {
    CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarList("CAR,NAME,PORT");
    }


    @Test
    @DisplayName("쉼표를 기준으로 자동차가 생성된다.")
    void carSeperateCommaCreate() {
        assertThat(carList.getCars().get(0)).isEqualTo(new Car("CAR"));
        assertThat(carList.getCars().get(1)).isEqualTo(new Car("NAME"));
        assertThat(carList.getCars().get(2)).isEqualTo(new Car("PORT"));
        assertThatIllegalArgumentException().isThrownBy(() -> new CarList("CAR,,NAME,PORT"));
    }

    @Test
    @DisplayName("우승자는 CAR")
    void singleWinnerTest() {
        carList.getCars().get(0).command(4);
        assertThat(carList.getWinnerName(",")).isEqualTo("CAR");
    }

    @Test
    @DisplayName("공동우승자 CAR,NAME")
    void multyWinnerTest() {
        carList.getCars().get(0).command(4);
        carList.getCars().get(1).command(4);
        assertThat(carList.getWinnerName(",")).isEqualTo("CAR,NAME");
    }


}
