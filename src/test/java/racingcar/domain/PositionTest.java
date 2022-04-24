package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void 위치는_같은_위치에_있는_경우_같다고_판별한다() {
        Position position1 = new Position();
        Position position2 = new Position();

        Assertions.assertEquals(position1, position2);
    }

    @Test
    public void 위치는_다른_위치에_있는_경우_다르다고_판별한다() {
        Position position1 = new Position();
        Position position2 = new Position();

        position1.right();
        position1.right();
        position2.right();

        Assertions.assertNotEquals(position1, position2);
    }

    @Test
    public void 위치는_타입이_다른_경우_다르다고_판별한다() {
        Assertions.assertNotEquals(new Position(), new CarName("car"));
    }

    @Test
    public void 위치는_더_오른쪽에_있는_경우를_큰_수로_판별한다() {
        Position position1 = new Position();
        Position position2 = new Position();

        position1.right();

        Assertions.assertTrue(position1.compareTo(position2) > 0);
        Assertions.assertTrue(position2.compareTo(position1) < 0);
    }
}
