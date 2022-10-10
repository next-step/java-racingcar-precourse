package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarListTest {
    @Test
    void 이름이_입력되면_구분자_기준으로_객체를_생성한다() {
        String inputString = "abc,bcd,cde";
        List<Car> carList = new CarList(inputString).getCarList();
        assertAll(
                () -> assertThat(carList.get(0).getCarName()).isEqualTo(new CarName("abc")),
                () -> assertThat(carList.get(1).getCarName()).isEqualTo(new CarName("bcd")),
                () -> assertThat(carList.get(2).getCarName()).isEqualTo(new CarName("cde"))
        );
    }

    @Test
    void 빈_값이_입력되면_에러가_발생한다() {
        String inputString = "";
        assertThatIllegalArgumentException().isThrownBy(() -> new CarList(inputString));
    }
}
