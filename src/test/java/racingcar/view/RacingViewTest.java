package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.GameStatus;
import racingcar.car.model.dto.CarDTO;
import racingcar.car.view.RacingView;

import java.io.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingViewTest {
    RacingView racingView;

    @BeforeEach
    public void init() {
        racingView = new RacingView();
    }


    @Test
    public void 자동차이름받기() {
        //given
        String serverSay = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        String iSay = "t1,t2,t3";
        InputStream in = generateInputStream(iSay);
        OutputStream out = generateOutputStream();

        //when
        String carNames = racingView.getInput(GameStatus.CAR_NAME);

        //then
        assertThat(carNames)
                .isEqualTo(iSay);
        assertThat(out.toString().trim())
                .isEqualTo((serverSay).trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "a", "-1", " "})
    public void 시도횟수입력받기(String input) {
        //given
        String serverSay = "시도할 횟수는 몇회인가요?";
        String iSay = input;
        InputStream in = generateInputStream(iSay);
        OutputStream out = generateOutputStream();
        //when
        String racingNumber = racingView.getInput(GameStatus.RACING_NUMBER);
        //then
        assertThat(racingNumber)
                .isEqualTo(iSay);
        assertThat(out.toString().trim())
                .isEqualTo(serverSay);
    }

    @Test
    public void 차수별_실행결과_출력() {
        //given
        ArrayList<CarDTO> cars = new ArrayList<>();
        CarDTO c1 = new CarDTO("c1", 5);
        CarDTO c2 = new CarDTO("c2", 2);
        cars.add(c1);
        cars.add(c2);
        OutputStream out = generateOutputStream();
        //when

        racingView.printProgress(cars);
        //then
        assertThat(out.toString().trim())
                .isEqualTo("c1 : -----\r\n" + "c2 : --\r\n".trim());
    }

    @Test
    public void 우승자_실행_단일출력() {
        //given
        ArrayList<CarDTO> winners = new ArrayList<>();
        winners.add(new CarDTO("c1", 2));
        OutputStream out = generateOutputStream();
        //when
        racingView.printWinner(winners);
        //then
        assertThat(out.toString().trim())
                .isEqualTo("최종 우승자: c1\r\n".trim());
    }

    @Test
    public void 우승자_실행_다수출력() {
        //given
        ArrayList<CarDTO> cars = new ArrayList<>();
        cars.add(new CarDTO("c1", 2));
        cars.add(new CarDTO("c2", 2));
        OutputStream out = generateOutputStream();
        //when
        racingView.printWinner(cars);
        //then
        assertThat(out.toString().trim())
                .isEqualTo("최종 우승자: c1, c2\r\n".trim());
    }

    private OutputStream generateOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }


    private InputStream generateInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        return in;
    }

}
