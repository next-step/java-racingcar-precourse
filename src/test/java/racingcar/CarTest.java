package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 클래스가 올바르게 생성되는지 테스트한다.")
    void makeCarTest() {
        Car car = new Car("felix");
        assertThat(car instanceof Car).isTrue();
    }

    @Test
    @DisplayName("자동차 클래스가 자신의 이름을 올바르게 리턴하는지 테스트한다.")
    void displayCarNameTest() {
        Car car = new Car("felix");
        assertThat(car.getName()).isEqualTo("felix");
    }

    @Test
    @DisplayName("자동차의 이름이 다섯자를 초과할 경우 에러 발생을 테스트한다.")
    void makeCarNameErrorTest() {
        assertThatThrownBy(() -> {
            Car car = new Car("felix1");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("자동차를 한칸 전진하라는 메세지를 보냈을 때, 위치가 올바르게 증가하는지 테스트한다.")
    void moveForwardTest() {
        Car car = new Car("felix");
        car.moveForward();
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자를 뽑았을 때, 자동차가 움직일지 말지를 결정하는 메서드를 테스트한다.")
    void isMoveTest() {
        Car car = new Car("felix");
        assertThat(car.isMove(3)).isFalse();
        assertThat(car.isMove(4)).isTrue();
    }

    @Test
    @DisplayName("차가 정상적으로 행동하는지 테스트한다.(전진케이스)")
    void carBehaviorTest1() {
        Car car = new Car("felix");
        int number = 4; //Randoms.pickNumberInRange(0, 9);
        car.carBehavior(number);
        assertThat(car.getCurrentPosition()).isEqualTo(1);
        assertThat(car.displayTrace()).isEqualTo("-");
    }

    @Test
    @DisplayName("차가 정상적으로 행동하는지 테스트한다.(가만히 있는 케이스)")
    void carBehaviorTest2() {
        Car car = new Car("felix");
        int number = 4; //Randoms.pickNumberInRange(0, 9);
        car.carBehavior(number);
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }


}
