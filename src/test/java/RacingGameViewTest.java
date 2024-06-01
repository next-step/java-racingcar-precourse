import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameViewTest {
    private ByteArrayOutputStream outContent=new ByteArrayOutputStream();
    private PrintStream originOutput=System.out;

    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("입력에서 올바른 자동차 이름을 반환하는지 테스트")
    public void testGetCarNames(){
        String input="KIA,BMW,na\n";
        ByteArrayInputStream inContent=new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        RacingGameView view=new RacingGameView();
        List<String> carNames=view.getCarNames();

        assertThat(carNames).containsExactly("KIA","BMW","na");
    }

    @Test
    @DisplayName("입력에서 올바른 작동 횟수를 반환하는지 테스트")
    public void testGetMoveCount() {
        String input="5\n";
        ByteArrayInputStream inContent=new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        RacingGameView view=new RacingGameView();
        int moveCount=view.getMoveCount();

        assertThat(moveCount).isEqualTo(5);
    }

    @Test
    @DisplayName("이동 횟수가 올바르게 출력되는지 테스트")
    public void testPrintProgress(){
        RacingGameView view=new RacingGameView();
        Car car1=new Car("KIA");
        Car car2=new Car("BMW");
        car1.move(4);
        car1.move(4);
        car1.move(4);
        car2.move(4);

        view.printProgress(List.of(car1, car2));

        String expectedOutput="KIA : ---\nBMW : -\n\n";
        assertThat(outContent.toString()).isEqualToIgnoringNewLines(expectedOutput);
    }

    @Test
    @DisplayName("최종 우승자가 올바르게 출력되는지 테스트")
    public void testPrintWinner(){
        RacingGameView view=new RacingGameView();
        Car car1=new Car("KIA");
        Car car2=new Car("BMW");

        car1.move(4);
        car1.move(4);
        car1.move(4);
        car2.move(4);

        view.printWinner(List.of(car1, car2));

        assertThat(outContent.toString()).contains("최종 우승자: KIA");
    }

}
