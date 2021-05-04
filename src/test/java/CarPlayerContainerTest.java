import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarPlayerContainerTest {
    private CarPlayerContainer carPlayers;

    @BeforeEach
    void setup() {
        this.carPlayers = new CarPlayerContainer();
    }

    @Test
    @DisplayName("순차적으로 전진 개수가 증가하는 player리스트에서 winner를 찾아낸다.")
    void get_winners_in_ordered_players() {
        for (int i = 0; i < 10; i++) {
            CarPlayer carPlayer = mock(CarPlayer.class);
            when(carPlayer.getMoveCount()).thenReturn(i);

            this.carPlayers.add(carPlayer);
        }

        Assertions.assertThat(this.carPlayers.getWinners().size()).isGreaterThan(0);
        Assertions.assertThat(this.carPlayers.getWinners().get(0).getMoveCount()).isEqualTo(9);
    }

    @Test
    @DisplayName("순차적으로 전진 개수가 감소하는 player리스트에서 winner를 찾아낸다.")
    void get_winners_in_reverse_ordered_players() {
        for (int i = 9; i >= 0; i--) {
            CarPlayer carPlayer = mock(CarPlayer.class);
            when(carPlayer.getMoveCount()).thenReturn(i);

            this.carPlayers.add(carPlayer);
        }

        Assertions.assertThat(this.carPlayers.getWinners().size()).isGreaterThan(0);
        Assertions.assertThat(this.carPlayers.getWinners().get(0).getMoveCount()).isEqualTo(9);
    }

    @Test
    @DisplayName("Winner가 여러 명일 경우 모두 찾아낸다.")
    void find_all_winners() {
        for (int i = 0; i < 10; i++) {
            CarPlayer carPlayer = mock(CarPlayer.class);
            when(carPlayer.getMoveCount()).thenReturn(i % 3);

            this.carPlayers.add(carPlayer);
        }

        Assertions.assertThat(this.carPlayers.getWinners().size()).isEqualTo(3);
        Assertions.assertThat(this.carPlayers.getWinners().get(0).getMoveCount()).isEqualTo(2);
    }
}
