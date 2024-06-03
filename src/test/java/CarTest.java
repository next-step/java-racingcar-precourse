import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.Utils_and_Message.Utils.getMax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.RacingCar;

public class CarTest {
    @Test
    @DisplayName("랜덤 숫자는 0~9 테스트")
    void randomNumberTest(){
        assertThat(RacingCar.makeComputerNum()).isBetween(0, 9);
    }

    @Test
    @DisplayName("생성한 Car의 이름과 거리 초기화 테스트")
    void carInitTest() {
        //given
        Car car = new Car("test", 0);
        //when, then
        assertThat(car.getName()).isEqualTo("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("5자 넘는 이름 오류 발생 테스트")
    void nameLengthTest() {
        String invalidNames = "a,bcdefg,h";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarName(invalidNames);
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 자동차 이름은 1~5 글자만 가능합니다.");
    }

    @Test
    @DisplayName("이름이 1~5자인 경우")
    public void testValidNames() {
        // 유효한 이름들
        String validNames = "abc,de,fghe";

        assertDoesNotThrow(() -> {
            new CarName(validNames);
        });
    }

    @Test
    @DisplayName("빈 이름 오류 발생 테스트")
    public void testEmptyNameValidation() {
        String invalidNames = "a,,h";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarName(invalidNames);
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 자동차 이름은 1~5 글자만 가능합니다.");
    }

    @Test
    @DisplayName("우승자 1명 테스트")
    public void winnerTest1() {
        Car car1 = new Car("a",3);
        Car car2 = new Car("b",1);
        Car car3 = new Car("c",2);
        Car[] cars = new Car[]{car1,car2,car3};
        RacingCar racingCar = new RacingCar(cars);

        // 차 개수
        assertThat(racingCar.getNumberofCars()).isEqualTo(3);

        // 차 위치 배열
        int[] expectedPositions = {3, 1, 2};
        int[] actualPositions = racingCar.getPositionArr();
        assertArrayEquals(expectedPositions, actualPositions);

        // 우승자 수
        assertThat(racingCar.countWinner()).isEqualTo(1);

        // 우승자 배열
        String[] expectedWinner = new String[]{"a"};
        String[] actualWinner = racingCar.findWinner();
        assertArrayEquals(expectedWinner, actualWinner);

    }

    @Test
    @DisplayName("우승자 2명 테스트")
    public void winnerTest2() {
        Car car1 = new Car("a",3);
        Car car2 = new Car("b",3);
        Car car3 = new Car("c",2);
        Car[] cars = new Car[]{car1,car2,car3};
        RacingCar racingCar = new RacingCar(cars);

        // 우승자 수
        assertThat(racingCar.countWinner()).isEqualTo(2);

        // 우승자 배열
        String[] expectedWinner = new String[]{"a","b"};
        String[] actualWinner = racingCar.findWinner();
        assertArrayEquals(expectedWinner, actualWinner);

    }
}
