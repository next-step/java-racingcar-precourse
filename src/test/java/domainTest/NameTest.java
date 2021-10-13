package domainTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Name;
import racinggame.domain.exceptions.CarException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름이 5자 이하 일 때 정상 생성")
    public void generatorNmae() {
        Car car = new Car("lee");
        assertThat(car.getName()).isEqualTo("lee");
    }


    @Test
    @DisplayName("이름이 5자 초과인 자동차 생성시 에러 발생")
    public void errorCarNameOverFive() {
        assertThatThrownBy(() -> {
            Name name = new Name("leeyoungjun");
        }).isInstanceOf(CarException.class);
    }

}
