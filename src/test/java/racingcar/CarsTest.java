package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class CarsTest {
    private static final String overCarName = "tester";
    private static final String InputString1 = "test1";
    private static final String InputString2 = "test2";
    private static final String InputStringDouble = "test1,test2";
    private static final String InputStringWithoutComma = "test1 test2";
    private static final String InputStringOverName = "test1,tester2";
    private static final String InputStringWithEmpty1 = "test1,,test2";
    private static final String InputStringWithEmpty2 = ",test1,test2";
    private static final String InputStringWithSpace = "test1, ,test2";


    @BeforeAll
    static void beforeAll() {
    }

    @Test
    @DisplayName("자동차 이름 1개 입력")
    void input_CarName_single() {
        Cars cars = new Cars(InputString1);
        assertThat(cars.getCars().get(0).getName().equals(InputString1)).isTrue();
        assertThat(cars.getCars().get(0).getName().equals(InputString2)).isFalse();
    }


    @Test
    @DisplayName("자동차 이름 2개 입력")
    void input_CarName_double() {
        Cars cars = new Cars(InputStringDouble);
        assertThat(cars.getCars().get(0).getName().equals(InputString1)).isTrue();
        assertThat(cars.getCars().get(1).getName().equals(InputString2)).isTrue();
    }

    @Test
    @DisplayName("자동차 이름 콤마 없이 입력")
    void input_Without_Comma() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(InputStringWithoutComma))
                .withMessageContaining("초과");
    }

    @Test
    @DisplayName("자동차 이름 한개만 최대치 초과")
    void input_OverName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(overCarName))
                .withMessageContaining("초과");
    }

    @Test
    @DisplayName("여러 자동차 중 한개만 최대치 초과")
    void input_Multi_OverName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(InputStringOverName))
                .withMessageContaining("초과");
    }

    @Test
    @DisplayName("자동차 이름 미입력 케이스")
    void input_Miss_Name() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(InputStringWithEmpty1))
                .withMessageContaining("미입력");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(InputStringWithEmpty2))
                .withMessageContaining("미입력");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(InputStringWithSpace))
                .withMessageContaining("미입력");
    }

}
