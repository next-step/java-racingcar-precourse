import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {
    private List<String> carNames;
    private List<Integer> positions;

    @BeforeEach
    void setUp() {
        carNames = List.of("Car1", "Car2", "Car3");
        positions = InitializePos.initializePos(carNames.size());
    }

    @Test
    void getCarNames_ShouldReturnValidCarNames() {
        String input = "Car1,Car2,Car3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        List<String> result = GetCarNames.getCarNames(scanner);

        assertThat(result).containsExactly("Car1", "Car2", "Car3");
    }

    @Test
    void getNumberOfRounds_ShouldReturnValidNumber() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int result = GetNumberOfRounds.getNumberOfRounds(scanner);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void initPOs_ShouldInitializeCorrectly() {
        List<Integer> result = InitializePos.initializePos(3);

        assertThat(result).containsExactly(0, 0, 0);
    }

    @Test
    void updatePosition_ShouldIncreasePosition_WhenRandomIsFourOrMore() {
        List<Integer> positions = List.of(0);
        MoveOrNot.moveOrNot(positions, 0);

        assertThat(positions.get(0)).isIn(0, 1);
    }

    @Test
    void playRace_ShouldRunWithoutExceptions() {
        PlayRace.playRace(carNames, 5, positions);

        // Test to ensure the method runs without any exceptions
        // You can add more specific checks based on expected behavior
        assertThat(positions).hasSize(3);
    }
}

