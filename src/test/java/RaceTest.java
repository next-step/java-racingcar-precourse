import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceTest {
    private Race race;
    private List<String> carNames;

    @BeforeEach
    public void setUp() {
        carNames = Arrays.asList("Na", "Gyu", "Kia");
        race = new Race(carNames);
    }

    @Test
    @DisplayName("모든 자동차는 moveCars가 불리면 움직이는지 테스트")
    public void testMoveCars() {
        for(int i=0;i<10;i++){
            race.moveCars();
        }
        List<Car> carsAfterMove=race.getCars();

        boolean allCarsMoved=carsAfterMove.stream()
                .allMatch(car->car.getPosition()>0);

        assertTrue(allCarsMoved, "모든 자동차가 움직였음");
    }

    @Test
    @DisplayName("winner는 maxPosition에 있는지 테스트")
    public void testGetWinner() {
        race.moveCars();
        List<Car> winners=race.getWinner();
        int maxPosition=race.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        assertFalse(winners.isEmpty(), "winner가 한 명 이상 있어야 함");
        assertTrue(winners.stream()
                .allMatch(car->car.getPosition()==maxPosition),
                "모든 winners는 maxPosition을 가짐");
    }
}
