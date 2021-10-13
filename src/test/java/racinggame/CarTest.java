package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Car;
import racinggame.domain.Cars;


public class CarTest {
    private Car pororo;
    private Car rupi;
    private Car edi;
    private Car joy;

    @BeforeEach
    void setup() {
        Cars pororoCars = new Cars("prr,rupi,edi");
        pororo = new Car(pororoCars.cars.get(0));
        rupi = new Car(pororoCars.cars.get(1));
        edi = new Car(pororoCars.cars.get(2));

        Cars redVelvetCars = new Cars("joy");
        joy = new Car(redVelvetCars.cars.get(0));
    }

    @Nested
    @DisplayName("play 메소드는")
    class Discribe_racingGame {
        @Nested
        @DisplayName("주어진 횟수가 다섯번일 때")
        class Context_with_five_move {
            public static final int CHANCE = 5;

            @Test
            @DisplayName("얼만큼 갔는지 횟수 체크를 한다")
            void with_return_winner() {
                for (int i = 0; i < CHANCE; i++) {
                    pororo.play();
                    rupi.play();
                    edi.play();
                }

                assertThat(pororo.getMoveCnt()).isGreaterThanOrEqualTo(0);
                assertThat(rupi.getMoveCnt()).isGreaterThanOrEqualTo(0);
                assertThat(edi.getMoveCnt()).isGreaterThanOrEqualTo(0);
            }
        }
    }

    @Nested
    @DisplayName("canMove 메소드는")
    class Discribe_canMove {
        @Nested
        @DisplayName("랜덤한 숫자가")
        class Context_with_five_move {
            @DisplayName("4 이상이면 한칸 앞으로 간다.")
            @ParameterizedTest
            @CsvSource(value = {"5", "6", "7", "8", "9"})
            void move_one_point(Integer randomNum) {
                assertThat(joy.canMove(randomNum)).isTrue();
            }

            @DisplayName("4 미만이면 움직이지 않는다.")
            @ParameterizedTest
            @CsvSource(value = {"0", "1", "2", "3"})
            void stop(Integer randomNum) {
                assertThat(joy.canMove(randomNum)).isFalse();
            }
        }
    }
}
