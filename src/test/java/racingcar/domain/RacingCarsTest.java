package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.RacingCarRule.NAME_LENGTH_EXCEPTION;
import static racingcar.domain.RacingCarRule.NAME_NULL_EXCEPTION;

class RacingCarsTest {

    @Nested
    @DisplayName("RacingCars 생성자는")
    class Describe_RacingCarsConstructor {

        @Nested
        @DisplayName("자동차의 이름들을 [,]구분하여 전달한다면")
        class Context_SeparateName {

            @Nested
            @DisplayName("각 이름들이 6글자 미만이라면")
            class Context_NameSizeLessThanSix {

                private final String carNames = "aaa,bbbb,cc,d,eee,ffff";

                @Test
                @DisplayName("[,]로 구분된 만큼 자동차를 생성한다.")
                void It_MakeCars() {
                    final int namesLength = carNames.split(",").length;
                    final RacingCars racingCars = new RacingCars(carNames);

                    assertThat(racingCars.isEqualNumberOfCar(namesLength)).isTrue();
                }
            }

            @Nested
            @DisplayName("자동차 이름이 공백이라면")
            class Context_NameIsWhitespace {

                private final String carNames = "aa,,b,cccc";

                @Test
                @DisplayName("자동차 이름을 입력하라는 예외를 던진다.")
                void It_ThrowException() {
                    assertThatThrownBy(() -> new RacingCars(carNames))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(NAME_NULL_EXCEPTION);
                }
            }

            @Nested
            @DisplayName("자동차 이름 사이즈가 6 이상이라면")
            class Context_NameIsOverLength {

                private final String carNames = "aaaa,bbbbbb,cccc";

                @Test
                @DisplayName("자동차 이름의 사이즈를 확인하라는 예외를 던진다.")
                void It_ThrowException() {
                    assertThatThrownBy(() -> new RacingCars(carNames))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(NAME_LENGTH_EXCEPTION);
                }
            }
        }
    }

    @Nested
    @DisplayName("finish()")
    class Describe_FinishMethod {

        @Nested
        @DisplayName("자동차들이 존재한다면")
        class Context_ExistedCars {

            private final String carNames = "test1,test2,test3,test4,test5";
            private final RacingCars racingCars = new RacingCars(carNames);
            private final WinnerCondition condition = new RacingWinnerMaxForwardStrategy();
            private String expect;

            @BeforeEach
            void setUp() {
                StringJoiner sj = new StringJoiner(", ");
                String[] names = carNames.split(",");
                for (String name : names) {
                    sj.add(name);
                }
                expect = sj.toString();
            }

            @Test
            @DisplayName("가장 멀리 간 우승자들의 정보를 문자열로 반환한다.")
            void It_FindWinners() {
                assertThat(racingCars.finish(condition)).isEqualTo(expect);
            }
        }
    }

    @Nested
    @DisplayName("race()")
    class Describe_RaceMethod {

        @Nested
        @DisplayName("숫자가 4이상이라면")
        class Context_RandomNumberMoreThanFour {

            private final String carNames = "test1,test2,test3,test4,test5";
            private final int[] randomNumbers = new int[] {3,5,6,3,4};
            private String expect;

            @BeforeEach
            void setUp() {
                StringBuilder sb = new StringBuilder();
                sb.append("test1 : \n")
                    .append("test2 : -\n")
                    .append("test3 : -\n")
                    .append("test4 : \n")
                    .append("test5 : -\n");
                expect = sb.toString();
            }

            @Test
            @DisplayName("자동차가 전진한다.")
            void It_ForwardCar() {
                RacingCarsOnlyTest testService = new RacingCarsOnlyTest(carNames);
                assertThat(testService.race(randomNumbers)).isEqualTo(expect);
            }
        }
    }
}
