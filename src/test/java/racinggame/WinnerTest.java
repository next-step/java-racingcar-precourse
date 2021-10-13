package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;
import racinggame.model.CarGroup;
import racinggame.model.Round;
import racinggame.model.Winner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinnerTest {
    @DisplayName("승리자 이름 알맞게 출력하는 지 여부")
    @Test
    void printWinnerName() {
        CarGroup carGroup = new CarGroup();
        carGroup.appendCar(new Car("apple"));
        carGroup.appendCar(new Car("kiwi"));

        assertThat(new Winner(carGroup).getWinnerNames()).isEqualTo("apple,kiwi");
    }
}
