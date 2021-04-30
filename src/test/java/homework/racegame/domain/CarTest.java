package homework.racegame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName(value = "범위 내 임의의 숫자 생성 여부 테스트")
    public void getRandomNumber() {
        for (int index = 0; index < 1000; index++) {
            int randomNumber = new Random().nextInt(10);
            assertThat(randomNumber).isLessThan(10);
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    @DisplayName(value = "차량 정상 이동 여부 확인 테스트")
    public void moveTest() {
        int moveCount = 0;
        String carName = "K5";
        Car car = new Car(carName);
        for (int index = 0; index < 1000; index++) {
            if (car.isPossibleToMove()) {
                car.move();
                moveCount++;
            }
        }
        assertThat(car.getMoveProgress().length()).isEqualTo(moveCount);
    }

    @Test
    @DisplayName(value = "차량 이동 진행 상태 출력 테스트")
    public void printMoveProgressTest() {
        int moveCount = 0;
        String carName = "K5";
        Car car = new Car(carName);
        for (int index = 0; index < 10; index++) {
            if (car.isPossibleToMove()) {
                car.move();
                moveCount++;
            }
        }
        assertThat(car.getMoveProgress().length()).isEqualTo(moveCount);
        car.printMoveProgress();
    }
}
