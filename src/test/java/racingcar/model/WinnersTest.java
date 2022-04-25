package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    @DisplayName("우승자 리스트를 입력할 때, 객체생성에 성공한다.")
    @Test
    public void createWinnersSuccess_P01() {
        ArrayList<CarName> dummyWinners = new ArrayList<>();
        dummyWinners.add(new CarName("hi"));
        dummyWinners.add(new CarName("hello"));
        Winners winners = new Winners(dummyWinners);
        assertThat(winners).isNotNull();
    }
}
