package racingcar.adapter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.application.port.ActivityResponse;
import racingcar.application.port.CarResponse;
import racingcar.application.port.RacingCarResultResponse;
import racingcar.application.port.in.RacingCarPlayUseCase;

public class ConsoleController {
    private static final String NAME_SEPARATOR = ",";
    private static final String WINNER_DELIMITER = ", ";
    private static final String CAR_RESPONSE_DELIMITER = " : ";
    private static final String POSITION_TEXT = "-";
    private static final String NEW_LINE = "\n";

    private static final Scanner scanner = new Scanner(System.in);

    private final RacingCarPlayUseCase racingCarPlayUseCase;

    public ConsoleController(final RacingCarPlayUseCase racingCarPlayUseCase) {
        this.racingCarPlayUseCase = racingCarPlayUseCase;
    }

    public void play() {
        String[] names = inputNames();
        int number = inputNumber();
        RacingCarResultResponse racingCarResultResponse = this.racingCarPlayUseCase.play(number, names);
        print(racingCarResultResponse);
    }

    private void print(final RacingCarResultResponse racingCarResultResponse) {
        System.out.println("실행결과");
        printCarActivities(racingCarResultResponse);
        printWinner(racingCarResultResponse.winners());
    }

    private void printCarActivities(final RacingCarResultResponse racingCarResultResponse) {
        racingCarResultResponse.activities().stream()
                .map(ActivityResponse::carResponses)
                .map(this::printCarResponse)
                .forEach(System.out::println);
    }

    private void printWinner(final List<CarResponse> winners) {
        String winnerText = winners.stream().map(CarResponse::name).collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println("최종 우승자 : " + winnerText);
    }

    private String printCarResponse(List<CarResponse> carResponses) {
        return carResponses.stream()
                .map(carResponse -> String
                        .join(CAR_RESPONSE_DELIMITER, carResponse.name(), positionText(carResponse.position())))
                .collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }

    private String positionText(final int position) {
        return POSITION_TEXT.repeat(position);
    }

    private String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = scanner.nextLine();
        return text.split(NAME_SEPARATOR);
    }

    private int inputNumber() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            return inputNumber();
        }
    }
}
