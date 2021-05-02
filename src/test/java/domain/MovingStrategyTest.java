package domain;

import dto.CarDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("주사위 이동 전략이 굴린 주사위의 지정한 숫자 이상일 경우에만 자동차를 이동시키는지 테스트")
    public void ifDiceTickOverPoint_MoveCar_OrNot(int diceTick) {
        //given
        Car car = new Car("test");
        Dice dice = new Dice(diceTick);
        DiceMovingStrategy diceMovingStrategy = new DiceMovingStrategy();

        //when
        diceMovingStrategy.ifDiceOverMovingPointMoveCarOrNot(car, dice);

        //then
        int resultDistance = getResultDistance(diceTick);
        CarDto carDto = car.toDto();
        assertThat(carDto.getLocation()).isEqualTo(new Distance(resultDistance));
    }

    private int getResultDistance(int diceTick) {
        int result = 0;
        if (diceTick >= DiceMovingStrategy.MOVING_POINT) {
            result = 1;
        }
        return result;
    }
}
