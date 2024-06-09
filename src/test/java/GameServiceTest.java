import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.GameService;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }

    @Test
    void testSetupAndRace() {
        String[] names = {"Car1", "Car2", "Car3"};
        int raceCount = 5;
        gameService.setup(names, raceCount);
        gameService.startRacing();
        // 단순히 에러 없이 실행될 수 있음을 검증
        assertTrue(true, "에러 발생 안함");
    }

    @Test
    void testGetResults() {
        String[] names = {"Car1", "Car2", "Car3"};
        int raceCount = 10;
        gameService.setup(names, raceCount);
        gameService.startRacing();

        // 결과 문자열 검증
        String results = gameService.getResults();
        assertTrue(results.startsWith("최종 우승자:"), "'최종 우승자:'");
    }

    @Test
    void testInvalidCarNameLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String[] names = {"Car123456", "Car2", "Car3"}; // 잘못된 이름 길이
            int raceCount = 5;
            gameService.setup(names, raceCount);
        });

        assertEquals("[ERROR] 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }
}
