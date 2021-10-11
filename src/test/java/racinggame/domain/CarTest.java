package racinggame.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racinggame.enums.ErrorMessageEnum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.*;

import org.mockito.MockedStatic;

public class CarTest {
    private static MockedStatic<MoveJudge> moveJudgeMockedStatic;

    @BeforeAll
    static void setUp() {
        moveJudgeMockedStatic = mockStatic(MoveJudge.class);
    }

    @AfterAll
    static void tearDown() {
        moveJudgeMockedStatic.close();
    }

    @Test
    void CAR_생성() {
        Name carName = new Name("sun");
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName.getName());
        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }

    @Test
    void CAR_생성_실패_이름_5자_초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(new Name("invalidName"));
        }).withMessage(ErrorMessageEnum.INPUT_CAR_NAME_SIZE_ERROR.getMessage());
    }

    @Test
    void CAR_생성_실패_이름_공백() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(new Name(""));
        }).withMessage(ErrorMessageEnum.INPUT_CAR_NAME_SIZE_ERROR.getMessage());
    }

    @Test
    void CAR_생성_실패_이름_NULL() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(new Name(null));
        }).withMessage(ErrorMessageEnum.INPUT_CAR_NAME_SIZE_ERROR.getMessage());
    }

    @Test
    void CAR_전진() {
        Car car = new Car(new Name("sun"));

        when(MoveJudge.judge()).thenReturn(MoveStatus.MOVE);
        car.changePosition();

        assertThat(car.getPosition().getValue()).isEqualTo(1);
    }

    @Test
    void CAR_정지() {
        Car car = new Car(new Name("sun"));

        when(MoveJudge.judge()).thenReturn(MoveStatus.STOP);
        car.changePosition();

        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }

    @Test
    void CAR_동일_위치() {
        Car car = new Car(new Name("sun"));
        Position expectedPosition = new Position(3);

        when(MoveJudge.judge()).thenReturn(MoveStatus.MOVE);
        car.changePosition();
        car.changePosition();
        car.changePosition();

        assertThat(car.isSamePosition(expectedPosition)).isTrue();
    }

}
