package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {

    private static List<Car> players;
    private Car player1;
    private Car player2;
    private Car player3;

    @BeforeEach
    void setUp() {
        player1 = new Car(new Name("p1"));
        player2 = new Car(new Name("p2"));
        player3 = new Car(new Name("p3"));

        players = Arrays.asList(player1, player2, player3);
    }

    @Test
    void 생성() {
        Cars cars = new Cars(players);
        assertThat(cars.getCars()).contains(player1, player2, player3);
    }

    @Test
    void 이동() {
        try (final MockedStatic<MoveJudge> moveJudgeMockedStatic = Mockito.mockStatic(MoveJudge.class)) {
            moveJudgeMockedStatic.when(MoveJudge::judge)
                    .thenReturn(MoveStatus.MOVE, MoveStatus.STOP, MoveStatus.STOP);

            Cars cars = new Cars(players);
            cars = cars.move();

            assertThat(cars.getCars().get(0).getPosition().getValue()).isEqualTo(1);
            assertThat(cars.getCars().get(1).getPosition().getValue()).isEqualTo(0);
            assertThat(cars.getCars().get(2).getPosition().getValue()).isEqualTo(0);
        }
    }

    @Test
    void 위치_반환() {
        try (final MockedStatic<MoveJudge> moveJudgeMockedStatic = Mockito.mockStatic(MoveJudge.class)) {
            moveJudgeMockedStatic.when(MoveJudge::judge)
                    .thenReturn(MoveStatus.MOVE, MoveStatus.STOP, MoveStatus.STOP,
                            MoveStatus.MOVE, MoveStatus.STOP, MoveStatus.STOP);

            Cars cars = new Cars(players);
            cars.move();
            cars.move();

            Map<String, String> currentStatus = cars.getCarsStatus();
            assertThat(currentStatus.get("p1")).isEqualTo("--");
            assertThat(currentStatus.get("p2")).isEqualTo("");
            assertThat(currentStatus.get("p3")).isEqualTo("");
        }
    }

    @Test
    void 가장_큰_위치() {
        try (final MockedStatic<MoveJudge> moveJudgeMockedStatic = Mockito.mockStatic(MoveJudge.class)) {
            moveJudgeMockedStatic.when(MoveJudge::judge)
                    .thenReturn(MoveStatus.MOVE, MoveStatus.STOP, MoveStatus.STOP,
                            MoveStatus.MOVE, MoveStatus.STOP, MoveStatus.STOP);

            Cars cars = new Cars(players);
            Position position = new Position(2);

            cars.move();
            cars.move();
            Position maxPosition = cars.getMaxPosition();

            assertThat(position).isEqualTo(maxPosition);
        }
    }

    @Test
    void 우승자_반환() {
        try (final MockedStatic<MoveJudge> moveJudgeMockedStatic = Mockito.mockStatic(MoveJudge.class)) {
            moveJudgeMockedStatic.when(MoveJudge::judge)
                    .thenReturn(MoveStatus.MOVE, MoveStatus.STOP, MoveStatus.STOP,
                            MoveStatus.MOVE, MoveStatus.STOP, MoveStatus.STOP);

            Cars cars = new Cars(players);
            Position maxPosition = new Position(2);

            cars.move();
            cars.move();

            Cars winners = cars.winners(maxPosition);

            assertThat(winners.getCars()).containsExactly(player1);
        }
    }

}
