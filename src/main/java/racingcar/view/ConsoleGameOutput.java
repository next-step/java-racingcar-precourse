package racingcar.view;

import racingcar.dto.CarRecordDto;
import racingcar.dto.RacingRecordDto;

import java.io.PrintStream;
import java.util.List;

public class ConsoleGameOutput implements GameOutput {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_LAP_COUNT = "시도할 회수는 몇회인가요?";
    private static final String RESULT_TITLE = "실행 결과";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";
    private static final String NOTIFY_WINNERS = "최종 우승자: %s%n";

    private final PrintStream output;

    public ConsoleGameOutput(PrintStream output) {
        this.output = output;
    }

    @Override
    public void inputCarNames() {
        output.println(INPUT_CAR_NAMES);
    }

    @Override
    public void inputLapCount() {
        output.println(INPUT_LAP_COUNT);
    }

    @Override
    public void showRacingRecord(RacingRecordDto racingRecord) {
        output.println();
        output.println(RESULT_TITLE);
        for (int i = 0; i < racingRecord.getLapCount(); i++) {
            showRacingCars(racingRecord, i);
            output.println();
        }
    }

    private void showRacingCars(RacingRecordDto racingRecord, int lapIndex) {
        for (CarRecordDto carRecord : racingRecord.getCarRecords()) {
            int position = carRecord.getPosition(lapIndex);
            String positionExpression = getPositionExpression(position);
            output.printf("%s : %s%n", carRecord.getName(), positionExpression);
        }
    }

    private String getPositionExpression(int position) {
        return new String(new char[position]).replace("\0", "-");
    }

    @Override
    public void showWinners(List<String> winnerNames) {
        output.printf(NOTIFY_WINNERS, String.join(", ", winnerNames));
    }

    @Override
    public void error(String message) {
        output.printf("%s %s%n", ERROR_MESSAGE_PREFIX, message);
    }
}
