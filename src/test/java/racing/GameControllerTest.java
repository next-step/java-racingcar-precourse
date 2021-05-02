package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest {

    @Test
    void flushOutput_ShouldPrintCarInputMessage() {
        GameController controller = new GameController(new Race());
        Output actual = controller.flushOutput();

        assertThat(actual).isEqualTo(new Output("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"));
    }


    @Test
    void flushOutput_ShouldPrintRoundInputMessage() {
        GameController controller = new GameController(new Race());
        controller.flushOutput();
        controller.setCars(new CarSet());

        Output actual = controller.flushOutput();

        assertThat(actual).isEqualTo(new Output("시도할 회수는 몇회인가요?"));
    }

    @Test
    void flushOutput_ShouldStartAfterInputComplete() {
        RaceSpy spy = new RaceSpy();
        GameController controller = new GameController(spy);

        controller.setCars(new CarSet());
        controller.setRound(new Round(10));
        controller.start();

        assertThat(spy.isStart).isTrue();
    }

    @Test
    void flushOutput_ShouldPrintResult() {
        Race race = new Race();
        race.setGenerator(new EnergyGeneratorStub(4));
        GameController controller = new GameController(race);

        controller.setCars(new CarSet(new Car("abc")));
        controller.setRound(new Round(1));
        controller.start();

        Output output = controller.flushOutput();
        assertThat(output).isEqualTo(new Output("실행 결과\nabc:-\n\nabc가 최종 우승했습니다."));
    }


    @Test
    void flushOutput_ShouldPrintResultMultipleCar() {
        Race race = new Race();
        race.setGenerator(new EnergyGeneratorStub(4, 4, 3));
        GameController controller = new GameController(race);

        controller.setCars(new CarSet(new Car("abc"),new Car("def"),new Car("ghi")));
        controller.setRound(new Round(2));
        controller.start();

        Output output = controller.flushOutput();
        assertThat(output).isEqualTo(new Output("실행 결과\nabc:-\ndef:-\nghi:\n\nabc:--\ndef:--\nghi:\n\nabc,def가 최종 우승했습니다."));
    }
}
