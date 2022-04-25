package racingcar.ui;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Winners;
import racingcar.domain.Position;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

class OutputTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Cars cars;
    private Winners winners;

    @BeforeEach
    void 출력_초기화() {
        cars = new Cars(Arrays.asList(new Car(new Name("pobi"), new Position(0))
                , new Car(new Name("woni"), new Position(4))
                , new Car(new Name("jun"), new Position(2))
                , new Car(new Name("crong"), new Position(4))
        ));
        winners = new Winners();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 실행결과_출력_테스트() {
        Output.printInterimResult(cars);
        assertThat(outputStream.toString()).contains("pobi : ");
        assertThat(outputStream.toString()).contains("woni : ----");
        assertThat(outputStream.toString()).contains("jun : --");
        assertThat(outputStream.toString()).contains("crong : ----");
    }

    @Test
    void 최종우승자_1명_출력_테스트() {
        winners.addWinnerList(new Car(new Name("woni"), new Position(4)));
        assertThat(winners.toString()).isEqualTo("최종 우승자: woni");
    }

    @Test
    void 최종우승자_2명_출력_테스트() {
        winners.addWinnerList(new Car(new Name("woni"), new Position(4)));
        winners.addWinnerList(new Car(new Name("crong"), new Position(4)));
        assertThat(winners.toString()).isEqualTo("최종 우승자: woni, crong");
    }

}