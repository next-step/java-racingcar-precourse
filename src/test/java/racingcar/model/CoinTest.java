package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CoinTest {

    @DisplayName("숫자 이외의 값이 입력되면 예외를 리턴한다")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void convertToNumberTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Coin(input);
        });
    }

    @DisplayName("코인 사용시 코인 횟수 차감")
    @ParameterizedTest
    @ValueSource(ints = {3})
    void compareCoinUseAfterCoinCount(int input) {

        Coin coin = new Coin(input);

        coin.useCoin();

        assertThat(coin.get()).isEqualTo(2);
    }

    @DisplayName("코인 1개 남은 상태에서 사용 후 게임종료 여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void compareCoinLastUseAfterIsContinue(int input) {

        Coin coin = new Coin(input);

        coin.useCoin();

        assertThat(coin.isContinue()).isFalse();

    }


}