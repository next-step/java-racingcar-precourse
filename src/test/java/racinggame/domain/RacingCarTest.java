package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.type.MovingStatus;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    public void initRacingCar() {
        this.racingCar = new RacingCar(new CarName("싱싱카"));
    }

    @Test
    public void 레이싱카는_이름을_가진다() {
        String name = racingCar.getName();
        Assertions.assertThat(name != null && name.length() > 0).isTrue();
    }

    @Test
    public void 레이싱카는_숫자가_4이상이면_전진한다() {
        int preDistance = racingCar.getDistance();
        this.racingCar.move(4);

        Assertions.assertThat(racingCar.getDistance()).isEqualTo(preDistance + 1);
    }

    @Test
    public void 레이싱카는_숫자가_3이하면_멈춘다() {
        int preDistance = racingCar.getDistance();
        Assertions.assertThat(preDistance).isEqualTo(preDistance);
    }

    @Test
    public void 레이싱카의_처음_거리는_0이다() {
        RacingCar racingCar = new RacingCar(new CarName("test"));
        Assertions.assertThat(racingCar.getDistance()).isEqualTo(0);
    }

    @Test
    public void 레이싱카의_처음_상태는_정지상태이다() {
        RacingCar racingCar = new RacingCar(new CarName("test"));
        Assertions.assertThat(racingCar.getMovingStatus()).isEqualTo(MovingStatus.STOP);
    }

    @Test
    public void 레이상카는_숫자_4이상이면_전진상태를_가진다() {
        RacingCar racingCar = new RacingCar(new CarName("test"));
        racingCar.move(4);
        Assertions.assertThat(racingCar.getMovingStatus()).isEqualTo(MovingStatus.FORWARD);
    }

    @Test
    public void 레이상카는_숫자_3이하이면_정지상태를_가진다() {
        RacingCar racingCar = new RacingCar(new CarName("test"));
        racingCar.move(3);
        Assertions.assertThat(racingCar.getMovingStatus()).isEqualTo(MovingStatus.STOP);
    }
}
