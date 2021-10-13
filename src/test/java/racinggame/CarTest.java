package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

/*
 "pobi, prr, rupi, edi" 3
 1. 이름 분리 해서 cars에 집어 넣기 o
 2. 이름 다섯자 미만인지 판별 o
 3. 자동차마다 0-9의 랜덤한 숫자를 생성 o
 4. 자동차마다 4이상인지 미만인지 판별 o
 5. 자동차마다 더하기해주기 o
 6. 젤 많은 숫자인 자동차 출력 o
*/

public class CarTest {
    private Car pororoCar;
    private Car rupiCar;
    private Car ediCar;

    @BeforeEach
    void setup() {
        Cars cars = new Cars("prr,rupi,edi");
        pororoCar = new Car(cars.cars.get(0));
        rupiCar = new Car(cars.cars.get(1));
        ediCar = new Car(cars.cars.get(2));
    }

    @Nested
    @DisplayName("racingGame 메소드는")
    class Discribe_racingGame {
        @Nested
        @DisplayName("주어진 횟수가 다섯번일 때")
        class Context_with_five_move {
            public static final int CHANCE = 5;

            @Test
            @DisplayName("얼만큼 갔는지 횟수 체크를 한다")
            void with_return_winner() {
                for (int i = 0; i < CHANCE; i++) {
                    pororoCar.play();
                    rupiCar.play();
                    ediCar.play();
                }
                assertThat(pororoCar.getMoveCnt()).isGreaterThanOrEqualTo(0);
                assertThat(rupiCar.getMoveCnt()).isGreaterThanOrEqualTo(0);
                assertThat(ediCar.getMoveCnt()).isGreaterThanOrEqualTo(0);
            }
        }
    }

    @Nested
    @DisplayName("findWinner 메소드는")
    class Describe_findWinner {
        @Nested
        @DisplayName("우승한 자동차가 pororoCar일 때")
        class Context_with_win_pororo {
            int pororoCarCnt = 5;
            int rupiCarCnt = 3;
            int ediCarCnt = 0;

            @Test
            @DisplayName("proroCar를 출력한다.")
            void with_return_pororo() {
                assertThat(pororoCar.getCarName()).isEqualTo("prr");
            }
        }
    }
}
