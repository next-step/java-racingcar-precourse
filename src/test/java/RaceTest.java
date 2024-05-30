import static model.RaceCondition.FINISHED;
import static model.RaceCondition.IN_PROGRESS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import model.Car;
import model.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    private Race race;
    private final int attemptCount = 5;

    @BeforeEach
    void setUp() {
        // carList
        List<Car> carList = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );

        race = new Race(carList, attemptCount);
    }

    @Test
    @DisplayName("시도 횟수까지만 이동 가능")
    void canMoveTest() throws Exception {
        assertTrue(race.canMove());

        for (int i = 0; i < attemptCount; i++) {
            race.move();
        }

        assertFalse(race.canMove());
    }

    @Test
    @DisplayName("경기 상태 변경 이벤트 발생 테스트")
    void stateChangeEventTest() throws Exception {
        TestPropertyChangeListener listener = new TestPropertyChangeListener();
        race.addPropertyChangeListener(listener);

        race.move();

        assertTrue(listener.isRaceStatusUpdated());
        assertEquals(IN_PROGRESS, race.getRaceCondition());
        assertEquals(attemptCount - 1, race.getAttemptCount());
    }

    @Test
    @DisplayName("경기 종료 이벤트 발생 테스트")
    void finishedEventTest() throws Exception {
        TestPropertyChangeListener listener = new TestPropertyChangeListener();
        race.addPropertyChangeListener(listener);

        for (int i = 0; i < attemptCount; i++) {
            race.move();
        }

        assertTrue(listener.isRaceFinished());
        assertEquals(FINISHED, race.getRaceCondition());
        assertEquals(0, race.getAttemptCount());
    }

    @Test
    @DisplayName("우승자 목록 반환 테스트")
    void getWinnerListTest() throws Exception {
        for (int i = 0; i < attemptCount; i++) {
            race.move();
        }

        List<String> winnerList = race.getWinnerList();

        assertNotNull(winnerList);
        assertFalse(winnerList.isEmpty());
        assertEquals(FINISHED, race.getRaceCondition());
    }


    static class TestPropertyChangeListener implements PropertyChangeListener {

        private boolean raceStatusUpdated = false;
        private boolean raceFinished = false;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("raceStatusUpdate".equals(evt.getPropertyName())) {
                raceStatusUpdated = true;
            }
            if ("raceFinished".equals(evt.getPropertyName())) {
                raceFinished = true;
            }
        }

        public boolean isRaceStatusUpdated() {
            return raceStatusUpdated;
        }

        public boolean isRaceFinished() {
            return raceFinished;
        }
    }
}
