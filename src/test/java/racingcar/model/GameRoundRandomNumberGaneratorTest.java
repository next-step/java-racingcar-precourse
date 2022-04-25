package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoundRandomNumberGaneratorTest {
    private GameRoundRandomNumberGanerator gameRoundRandomNumberGanerator;

    @BeforeEach
    public void setUp() {
        this.gameRoundRandomNumberGanerator = new GameRoundRandomNumberGanerator();
    }

    @Test
    @DisplayName("0~9사이의 랜덤값을 확인하는 테스트")
    public void generateRacingCarGameRoundNumberTest() {
        // Given
        int radomNumber;

        // Given & When
        radomNumber = gameRoundRandomNumberGanerator.generateRacingCarGameRoundNumber();

        // When & Then
        assertThat(radomNumber)
                .isBetween(0, 9);
    }

}