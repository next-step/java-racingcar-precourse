import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoveHistoryTest {

    private MoveHistory moveHistory;

    @BeforeEach
    void setup() {
        this.moveHistory = new MoveHistory();
    }

    @ParameterizedTest
    @CsvSource(value = {"3:---", "13:-------------", "32:--------------------------------"})
    @DisplayName("여러번 전진한 내역을 보관 및 출력한다.")
    void print_movements(int moveCount, int movePrint) {
        for (int i = 0; i < moveCount; i++) {
            this.moveHistory.add(new Movement());
        }

        Assertions.assertThat(this.moveHistory.countMove()).isEqualTo(moveCount);
        Assertions.assertThat(this.moveHistory.toString()).isEqualTo(movePrint);
    }
}
