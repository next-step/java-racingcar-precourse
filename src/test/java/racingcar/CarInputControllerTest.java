package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.domain.CarNames;
import racingcar.domain.MoveCount;
import racingcar.view.CarInputController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarInputControllerTest {

    final String carNames = "woni,jihee,monky";
    final int MOVE_COUNT = 5;

    CarInputController inputController;

    void setCarNames() {
        setSystemOut();
        setCarNamesInStreams();

        inputController = new CarInputController(new Scanner(System.in));
    }

    void setMoveCount() {
        setSystemOut();
        setMoveCountInStreams();

        inputController = new CarInputController(new Scanner(System.in));
    }

    @Test
    void 여러_대의_자동차_이름을_쉼표로_구분하여_입력_받는다() {
        setCarNames();

        CarNames expectedCarNames = getCarNames();

        CarNames actualCarNames = inputController.inputCarNames();

        assertThat(actualCarNames).isEqualTo(expectedCarNames);
    }

    @Test
    void 사용자는_자동차의_이동_횟수를_입력할_수_있다() {
        setMoveCount();

        MoveCount moveCount = inputController.inputMoveCount();
        assertThat(moveCount).isEqualTo(new MoveCount(MOVE_COUNT));
    }

    public CarNames getCarNames() {
        String[] carNamesLiteral = carNames.split(",");
        CarNames carNames = CarNames.createEmpty();
        for (String carNameLiteral : carNamesLiteral) {
            carNames.add(new CarName(carNameLiteral));
        }

        return carNames;
    }

    private void setMoveCountInStreams() {
        System.setIn(new ByteArrayInputStream(String.valueOf(MOVE_COUNT).getBytes()));
    }

    private void setCarNamesInStreams() {
        System.setIn(new ByteArrayInputStream(carNames.getBytes()));
    }

    private void setSystemOut() {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

}