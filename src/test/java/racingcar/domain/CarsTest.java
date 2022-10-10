package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    public void 이름받기(){
        //given
        String input= "pobi,woni,jun";

        //when
        Cars cars = new Cars(input);

        //Then
        assertThat(cars.getCarList().size()).isEqualTo(3);
    }

    @Test
    public void 이름에러내기(){
        //given
        String input= "pobiaaaa,woni,jun";

        //when
        //Then
        assertThatThrownBy(() -> {
            Cars cars = new Cars(input);
            cars.getCarList().size();
        }).isInstanceOf(IllegalArgumentException.class);
    }

}