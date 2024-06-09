import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("Car 클래스 생성 시 위치가 0으로 초기화되는가?")
    void position_initialize_with_zero() {
        // given
        Car car = new Car("test");
        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 클래스 생성 시 이름이 입력과 동일하게 설정되는가?")
    void name_initialize_with_input() {
        //given
        Car car = new Car("test");
        //then
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("moveFoward 메소드에서 위치가 정상적으로 업데이트 되는가?")
    void position_update() {
        //given
        Car car = new Car("test");
        //when
        car.moveFoward();
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("toSting 메소드를 통해 이름과 위치가 정상적으로 얻어지는가?")
    void tosting_output() {
        //given
        Car car = new Car("test");
        //when
        car.moveFoward();
        String output = car.toString();
        //then
        assertThat(output).isEqualTo("test : -");
    }
}