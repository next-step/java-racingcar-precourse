package racinggame.model;

import nextstep.utils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racinggame.controller.IOController;
import racinggame.vo.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class RacingGameTest {
    private RacingGame racingGame;
    private Cars playerCars;

    @BeforeEach
    void setup() {
        this.racingGame = new RacingGame(new IOController());

        this.playerCars = new Cars();

        this.playerCars.add(new Car(new PlayerName("car1"), new CarLocation(0)));
        this.playerCars.add(new Car(new PlayerName("car2"), new CarLocation(0)));
        this.playerCars.add(new Car(new PlayerName("car3"), new CarLocation(0)));
    }

    @Test
    void 게임에_참여할_자동차_목록과_총_게임_턴수가_입력되면_게임의_적어도_한_명_이상의_우승자_목록을_생성한다() {
        Assertions.assertThat(this.racingGame.play(this.playerCars, new GameTurnCnt(5)).size()).isGreaterThan(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 게임에_참여한_모든_자동차가_한번도_전진하지_못하면_모두_우승자로_판정된다(int generatedRandomValue) {
        int turnCnt = 5;

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(generatedRandomValue);

            Assertions.assertThat(this.racingGame.play(this.playerCars, new GameTurnCnt(turnCnt)).size()).isEqualTo(this.playerCars.size());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 게임에_참여한_모든_자동차가_한번도_전진하지_못하면_모든_자동차의_위치값은_그대로이다(int generatedRandomValue) {
        int turnCnt = 5;

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(generatedRandomValue);

            Cars winnerCars = this.racingGame.play(this.playerCars, new GameTurnCnt(turnCnt));

            for (Car winnerCar : winnerCars) {
                Assertions.assertThat(winnerCar.getLocation()).isEqualTo(new CarLocation(0));
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 게임에_참여한_모든_자동차가_매_턴마다_전진에_성공하면_모두_우승자로_판정된다(int generatedRandomValue) {
        int turnCnt = 5;

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(generatedRandomValue);

            Assertions.assertThat(this.racingGame.play(this.playerCars, new GameTurnCnt(turnCnt)).size()).isEqualTo(this.playerCars.size());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 게임에_참여한_모든_자동차가_매_턴마다_전진에_성공하면_모든_자동차의_위치값은_턴_수만큼_증가한다(int generatedRandomValue) {
        int turnCnt = 5;

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(generatedRandomValue);

            Cars winnerCars = this.racingGame.play(this.playerCars, new GameTurnCnt(turnCnt));

            for (Car winnerCar : winnerCars) {
                Assertions.assertThat(winnerCar.getLocation()).isEqualTo(new CarLocation(turnCnt));
            }
        }
    }

    @Test
    void 게임에_참여한_특정_자동차_한_대만_전진에_성공하면_우승자_목록은_특정_자동차_하나이다() {
        int turnCnt = 5;

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4)
                    .thenReturn(3)
                    .thenReturn(3);

            Cars winnerCars = this.racingGame.play(this.playerCars, new GameTurnCnt(turnCnt));

            Assertions.assertThat(winnerCars.size()).isEqualTo(1);
            Assertions.assertThat(winnerCars).containsOnly(this.playerCars.get(0));
        }
    }

    @Test
    void 게임에_참여한_특정_자동차_한_대만_전진하지_못하면_우승자_목록은_특정_자동차_한_대를_제외한_나머지이다() {
        int turnCnt = 5;

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3)
                    .thenReturn(4)
                    .thenReturn(4);

            Cars winnerCars = this.racingGame.play(this.playerCars, new GameTurnCnt(turnCnt));

            Assertions.assertThat(winnerCars.size()).isEqualTo(this.playerCars.size() - 1);
            Assertions.assertThat(winnerCars).doesNotContain(this.playerCars.get(0));
        }
    }
}
