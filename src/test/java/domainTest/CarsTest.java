package domainTest;

import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("문자열을 받아 N대의 자동차를 생성 테스트")
    @CsvSource(value = {"0:lee", "1:kim", "2:park"}, delimiter = ':')
    public void createCars(int index, String name){
        String names = "lee,kim,park";
        Cars cars = new Cars(names);

        assertThat(cars.getCar(index).getName()).isEqualTo(name);
    }

}
