package racingcar.view;

import racingcar.functional.LoopHelper;
import racingcar.racing.Car;
import racingcar.racing.Racing;

public class OutputView {
    private static final String MOVE_DISPLAY_CHARACTER = "-";

    public static void RacingMoveResultPrint(Racing racing) {
        StringBuilder sb = new StringBuilder();

        for (Car participant: racing.getParticipants()) {
            sb.append(participant.getName());
            sb.append(" : ");
            sb.append(generateSpecificConsecutiveCharacter(MOVE_DISPLAY_CHARACTER, participant.getPosition()));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void RacingEndResultPrint(Racing racing) {
        System.out.println(
            "최종 우승자: " + String.join(", ", LoopHelper.listMap(racing.getWinners(), Car::getName))
        );
    }

    private static String generateSpecificConsecutiveCharacter(String text, Integer count) {
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < count; index++) {
            sb.append(text);
        }

        return sb.toString();
    }
}
