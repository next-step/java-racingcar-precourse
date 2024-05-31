import model.Car;
import org.junit.jupiter.api.Test;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    public void printWinnersShouldPrintCorrectly() {
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");
        List<Car> winners = Arrays.asList(pobi, jun);

        ResultView resultView = new ResultView();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        assertThat(winnerNames).isEqualTo("pobi, jun");
    }
}
