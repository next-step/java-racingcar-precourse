package racingcar.Domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNamesTest {

    @DisplayName("입력받은 자동차 이름은 쉼표(,)를 기준으로 구분 배열로 만들기")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni"})
    void input_car_name_comma_split_array(String inputValues) {
        String[] arryName = inputValues.split(",");

        assertThat(arryName[0]).isEqualTo("pobi");
    }

    @DisplayName("입력받은 자동차 이름은 쉼표(,)를 기준으로 구분 ArrayList 만들기")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni"})
    void input_car_name_comma_split_List(String inputValues) {
        List<String> arrList = Arrays.asList(inputValues.split(","));

        assertThat(arrList.get(0)).isEqualTo("pobi");
    }

    @DisplayName("입력받은 자동차 이름은 쉼표(,)를 기준으로 구분 ArrayList 만들기")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni"})
    void input_car_names_List(String inputValues) {
        CarNames carNames = new CarNames(inputValues);

        assertThat(carNames.getCarNameList().get(0)).isEqualTo("pobi");
    }


    @DisplayName("입력받은 자동차 이름은 공백이 아니여야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void input_car_names_empty_exception(String inputValues) {
        assertThatThrownBy(() -> {
        CarNames carNames = new CarNames(inputValues);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백이 아니여야 합니다.");

    }

}
