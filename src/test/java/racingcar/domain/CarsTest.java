package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    public void 이름을_쉼표로_구분하여_n개의_자동차_생성() throws Exception {
        // given
        String carNames = "a,b,c,d";
        // when
        Cars cars = new Cars(carNames);
        // then
        assertThat(cars.size()).isEqualTo(4);
    }

    @Test
    public void 주행거리_최대값_구하기() throws Exception {
        // given
        String carNames = "a,b,c,d";
        // when
        Cars cars = new Cars(carNames);
        cars.drive();
        cars.drive();
        cars.drive(); // 주행 세번
        // then
        assertThat(cars.getMaxDistanceDriven()).isLessThan(4);
    }

    @Test
    public void 주행거리가_최대인_자동차_구하기() throws Exception {
        // given
        String carNames = "a,b,c,d";
        // when
        Cars cars = new Cars(carNames);
        cars.drive();
        cars.drive();
        cars.drive(); // 주행 세번
        // then
        List<String> firstPlaceCarNameList = cars.getFirstPlaceCarNameList();
        System.out.println(firstPlaceCarNameList.toString());
        assertThat(Arrays.asList(carNames.split(","))
                .containsAll(firstPlaceCarNameList))
                .isTrue();
    }

}