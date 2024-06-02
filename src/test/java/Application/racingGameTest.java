package Application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class RacingGameModelTest {
    private RacingGameModel model;

    @BeforeEach
    void setUp() {
        model = new RacingGameModel();
    }

    @Test
    void initializeGame_shouldInitializeCarPositions() {
        String[] carNames = {"car1", "car2", "car3"};
        model.initializeGame(carNames);

        Map<String, Integer> carPositions = model.getCarPositions();
        assertThat(carPositions).hasSize(3);
        assertThat(carPositions).containsKeys("car1", "car2", "car3");
        assertThat(carPositions.values()).allMatch(position -> position == 0);
    }

    @Test
    void moveCars_shouldMoveCarsCorrectly() {
        String[] carNames = {"car1", "car2", "car3"};
        model.initializeGame(carNames);

        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4; // Always return 4 to ensure cars move
            }
        };

        model.moveCars(fixedRandom);

        Map<String, Integer> carPositions = model.getCarPositions();
        assertThat(carPositions.values()).allMatch(position -> position == 1);
    }

    @Test
    void moveCars_shouldNotMoveCarsIfRandomLessThan4() {
        String[] carNames = {"car1", "car2", "car3"};
        model.initializeGame(carNames);

        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3; // Always return 3 to ensure cars don't move
            }
        };

        model.moveCars(fixedRandom);

        Map<String, Integer> carPositions = model.getCarPositions();
        assertThat(carPositions.values()).allMatch(position -> position == 0);
    }

    @Test
    void getWinners_shouldReturnCorrectWinners() {
        String[] carNames = {"car1", "car2", "car3"};
        model.initializeGame(carNames);

        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4; // Always return 4 to ensure cars move
            }
        };

        model.moveCars(fixedRandom);
        model.moveCars(fixedRandom);
        model.moveCars(new Random() {
            @Override
            public int nextInt(int bound) {
                return 3; // Always return 3 to ensure cars don't move
            }
        });

        List<String> winners = model.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("car1", "car2", "car3");
    }

    @Test
    void getWinners_shouldReturnSingleWinnerWhenThereIsOne() {
        String[] carNames = {"car1", "car2", "car3"};
        model.initializeGame(carNames);

        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4; // Always return 4 to ensure cars move
            }
        };

        model.moveCars(fixedRandom);
        model.moveCars(fixedRandom);

        model.getCarPositions().put("car1", 3); // Manually set car1 to have the highest position

        List<String> winners = model.getWinners();
        assertThat(winners).containsExactly("car1");
    }
}
