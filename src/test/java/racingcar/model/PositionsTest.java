package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionsTest {

    @Test
    @DisplayName("가장 큰 값을 가진 Position 조회")
    void maximumPosition() {
        // given
        List<Position> positionList = new LinkedList<>();
        positionList.add(new Position());
        positionList.add(new Position());
        positionList.add(new Position());
        positionList.get(0).increment();

        // when
        Positions positions = new Positions(positionList);

        // then
        assertThat(positions.getMaximumPosition()).isEqualTo(positionList.get(0));
    }
}
