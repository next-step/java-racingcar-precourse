package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : choi-ys
 * @date : 2022/04/21 10:27 오후
 */
@DisplayName("Domain:Joiners")
class JoinersTest {
    private String namesByComma = "람보르기니,마카롱택시,카카오택시,우라칸,밀레";
    private int roundCount = 5;
    private Player player;

    @BeforeEach
    void setUp() {
        player = Player.of(namesByComma, roundCount);
    }

    @Test
    @DisplayName("사용자로부터 입력받은 값을 이용하여 게임에 참여할 자동차 객체 리스트 생성 Test")
    public void createCar() {
        // Given
        String[] nameArray = namesByComma.split(",");

        // When
        Joiners joiners = Joiners.of(player);

        // Then
        assertThat(joiners.cars.size()).isEqualTo(nameArray.length);
        for (int i = 0; i < nameArray.length; i++) {
            assertThat(joiners.getCarByIndex(i).getCarName()).isEqualTo(nameArray[i]);
        }
    }
}