package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ValidationUtils;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    @DisplayName("자동차_이름_길이_5이하_true")
    void car_length_true_test(){
        boolean result = ValidationUtils.validName("hello");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("자동차_이름_길이_5초과_false")
    void car_length_false_test(){
        boolean result = ValidationUtils.validName("helloCar");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("자동차_이름_중복_확인_true")
    void car_name_duplication_true(){
        boolean result = ValidationUtils.duplicateName(Arrays.asList("hello", "pobi", "pobi2", "hello"));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("자동차_이름_중복_확인_false")
    void car_name_duplication_false(){
        boolean result = ValidationUtils.duplicateName(Arrays.asList("hello", "pobi", "pobi2", "hi"));
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("입력된_자동차_이름_배열_반환_4개")
    void string_car_names_to_list(){
        String carNames = "hello,jeju,kirk,land";
        List<String> listCar = ValidationUtils.stringToList(carNames);
        assertThat(listCar).contains("hello");
        assertThat(listCar).contains("jeju");
        assertThat(listCar).contains("kirk");
        assertThat(listCar).contains("land");
    }

    @Test
    @DisplayName("입력된_자동차_이름_배열_반환_1개")
    void string_car_names_to_list2(){
        String carNames = "hello";
        List<String> listCar = ValidationUtils.stringToList(carNames);
        assertThat(listCar).contains("hello");
    }
}
