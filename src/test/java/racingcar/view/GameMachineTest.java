package racingcar.view;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import racingcar.controller.RacingCarGame;
import racingcar.domain.factory.NextStepCarFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class GameMachineTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("User가 입력한 게임 횟수가 숫자 포맷이 아닐때 에러를 발생시키는지 확인한다.")
    void INPUT_COUNT_비정상_에러_테스트() {
        consoleInput(new String[]{"car1, car2", "F"});

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertTrue(outputStreamCaptor.toString().contains("[ERROR] 잘못된 값을 입력하셨습니다.(정수 입력)"));
    }

    @Test
    @DisplayName("User가 입력한 게임 횟수가 0일 때 에러를 발생시키는지 확인한다.")
    void INPUT_COUNT_0_에러_테스트() {
        consoleInput(new String[]{"car1, car2", "0"});

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertTrue(outputStreamCaptor.toString().contains("[ERROR] 실행할 횟수를 0 이상 입력해주세요."));
    }

    @Test
    @DisplayName("User가 입력한 자동차의 이름의 길이가 5이상 일 때 에러를 발생시키는지 확인한다.")
    void INPUT_CAR_비정상_이름_길이_에러_테스트() {
        consoleInput(new String[]{"carcarcar, car2", "1"});

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertTrue(outputStreamCaptor.toString().contains("[ERROR] 이름의 길이가 잘못되었습니다."));
    }


    @Test
    @DisplayName("User가 입력한 자동차의 개수가 0이하 일 때 에러를 발생시키는지 확인한다.")
    void INPUT_CAR_비정상_개수_에러_테스트() {
        consoleInput(new String[]{"", "1"});

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertTrue(outputStreamCaptor.toString().contains("[ERROR] 경주할 자동차를 1대 이상 입력해 주세요."));
    }

    @Test
    @DisplayName("GameMachine 실행을 위한 필수 파라메터가 정상적으로 설정되지 않았을때 에러를 발생하는지 확인한다.")
    void 필수_입력_파라메터_셋팅_에러_테스트() {
        consoleInput(new String[]{"car1, car2", "1"});

        new GameMachine()
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertTrue(outputStreamCaptor.toString().contains("[ERROR] Car factory가 설정되어야 합니다."));

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .run();

        assertTrue(outputStreamCaptor.toString().contains("[ERROR] Racing car Game이 설정되어야 합니다."));
    }

    @Test
    @DisplayName("User가 설정한 횟수 만큼 게임을 진행하고, 출력 포맷이 정상적으로 보이는지 확인한다.")
    void 게임_진행_횟수_정상_테스트() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    consoleInput(new String[]{"car1, car2", "3"});

                    new GameMachine()
                            .setCarFactory(
                                    new NextStepCarFactory()
                            )
                            .setRacingCarGame(
                                    new RacingCarGame()
                            )
                            .run();

                    String output = outputStreamCaptor.toString().replaceAll("\r\n","\n");
                    assertTrue(output.contains("car1 : \ncar2 : -"), "각 게임 당 진행 출력 포멧이 비정상 입니다.");
                    assertTrue(output.contains("car1 : -\ncar2 : -"), "각 게임 당 진행 출력 포멧이 비정상 입니다.");
                    assertTrue(output.contains("car1 : --\ncar2 : -"), "각 게임 당 진행 출력 포멧이 비정상 입니다.");
                },
                1,new Integer[]{8, 9, 2, 6, 3}
        );
    }

    @Test
    @DisplayName("게임 종료 후 우승자 출력부가 포멧에 맞게 보여지는지 확인한다.")
    void 게임_결과_출력_포멧_정상_테스트() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    consoleInput(new String[]{"car1, car2", "1"});

                    new GameMachine()
                            .setCarFactory(
                                    new NextStepCarFactory()
                            )
                            .setRacingCarGame(
                                    new RacingCarGame()
                            )
                            .run();

                    assertTrue(outputStreamCaptor.toString().contains("최종 우승자: car2"),"우승자 출력 포맷이 비정상 입니다.");
                },
                1,new Integer[]{8}
        );
    }

    public void consoleInput(String[] args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}