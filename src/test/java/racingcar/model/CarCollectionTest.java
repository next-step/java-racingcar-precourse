package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {
    @Test
    @DisplayName("특정 인덱스 번째에 있는 자동차가 움직이는 명령에 움직였는지 확인")
    void go_특정인덱스에_있는_자동차가_움직인다() {
        // given
        CarCollection carCollection = new CarCollection(new CarNames("a,b,c"));
        // when
        carCollection.go(1);
        // then
        Assertions.assertThat(carCollection.toString()).containsIgnoringCase("b : -");
    }
    @Test
    @DisplayName("특정 인덱스 번째에 있는 자동차가 정지하는 명령에 정지했는지 확인")
    void go_특정인덱스에_있는_자동차가_정지한다() {
        // given
        CarCollection carCollection = new CarCollection(new CarNames("a,b,c"));
        // when
        carCollection.stop(1);
        // then
        Assertions.assertThat(carCollection.toString()).doesNotContainIgnoringCase("b : -");
    }

}